package fr.thomas.stock.service;

import fr.thomas.stock.model.Order;
import fr.thomas.stock.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    public List<Order> getOrders();
    public Order getOrder(Long orderId);
    public void saveOrder(OrderDTO orderDTO);
    public void updateOrder(Long orderId, OrderDTO orderDTO);
    public void deleteOrder(Long orderId);
}
