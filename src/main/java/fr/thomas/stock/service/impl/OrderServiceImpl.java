package fr.thomas.stock.service.impl;

import fr.thomas.stock.exception.ElementNotFoundException;
import fr.thomas.stock.exception.NotEnoughQuantityException;
import fr.thomas.stock.model.Order;
import fr.thomas.stock.model.OrderProduct;
import fr.thomas.stock.model.OrderProductId;
import fr.thomas.stock.model.Product;
import fr.thomas.stock.model.dto.OrderDTO;
import fr.thomas.stock.model.dto.OrderProductDTO;
import fr.thomas.stock.model.dto.ProductDTO;
import fr.thomas.stock.repository.OrderRepository;
import fr.thomas.stock.service.OrderService;
import fr.thomas.stock.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderServiceImpl(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new ElementNotFoundException("Order not found !"));
    }

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomerName(orderDTO.getCustomerName());
        order = orderRepository.save(order);
        order.setOrderProducts(this.productIdArrayToProductList(orderDTO.getProducts(), order.getId()));
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(Long orderId, OrderDTO orderDTO) {
        Order order = this.getOrder(orderId);
        order.setCustomerName((orderDTO.getCustomerName() == null) ? order.getCustomerName() : orderDTO.getCustomerName());
        order.setOrderProducts((orderDTO.getProducts() == null) ? order.getOrderProducts() : this.productIdArrayToProductList(orderDTO.getProducts(), orderId));
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        this.getOrder(orderId);
        orderRepository.deleteById(orderId);
    }

    private void checkQuantityForProducts(OrderProductDTO[] orderProducts){
        for(OrderProductDTO orderProductDTO : orderProducts) {
            Product product = productService.getProduct(orderProductDTO.getProductId());

            if (orderProductDTO.getQuantity() > product.getQuantity()) {
                throw new NotEnoughQuantityException("Not enough quantity for " + product.getName());
            }
        }
    }

    private List<OrderProduct> productIdArrayToProductList(OrderProductDTO[] orderProducts, Long orderId){
        List<OrderProduct> products = new ArrayList<>();

        // Check Product quantity
        this.checkQuantityForProducts(orderProducts);

        for(OrderProductDTO orderProductDTO : orderProducts){
            Product product = productService.getProduct(orderProductDTO.getProductId());
            Order order = this.getOrder(orderId);

            // Order Product ID
            OrderProductId orderProductId = new OrderProductId();
            orderProductId.setOrderId(orderId);
            orderProductId.setProductId(orderProductDTO.getProductId());

            // Order Product Object
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setId(orderProductId);
            orderProduct.setProduct(product);
            orderProduct.setOrder(order);
            orderProduct.setQuantity(orderProductDTO.getQuantity());

            // Remove Product quantity
            Integer newQuantity = product.getQuantity() - orderProduct.getQuantity();
            productService.updateProduct(product.getId(), new ProductDTO(product.getId(), product.getName(), newQuantity, product.getPrice()));

            products.add(orderProduct);
        }
        return products;
    }
}
