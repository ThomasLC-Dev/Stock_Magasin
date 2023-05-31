package fr.thomas.stock.mapper;

import fr.thomas.stock.model.Order;
import fr.thomas.stock.model.dto.OrderResponseDTO;

import java.util.List;

public class OrderMapper {
    public static List<OrderResponseDTO> orderListToDto(List<Order> orders){
        return orders.stream().map(OrderMapper::orderToDto).toList();
    }
    public static OrderResponseDTO orderToDto(Order order){
        return new OrderResponseDTO(order.getId(), order.getCustomerName(), OrderProductMapper.orderProductListToDto(order.getOrderProducts()));
    }
}
