package fr.thomas.stock.mapper;

import fr.thomas.stock.model.Order;
import fr.thomas.stock.model.OrderProduct;
import fr.thomas.stock.model.dto.OrderProductResponseDTO;
import fr.thomas.stock.model.dto.OrderResponseDTO;

import java.util.List;

public class OrderProductMapper {
    public static List<OrderProductResponseDTO> orderProductListToDto(List<OrderProduct> orderProducts){
        return orderProducts.stream().map(OrderProductMapper::orderProductToDto).toList();
    }
    public static OrderProductResponseDTO orderProductToDto(OrderProduct orderProduct){
        orderProduct.getProduct().setQuantity(null);
        return new OrderProductResponseDTO(orderProduct.getQuantity(), ProductMapper.productToDto(orderProduct.getProduct()));
    }
}
