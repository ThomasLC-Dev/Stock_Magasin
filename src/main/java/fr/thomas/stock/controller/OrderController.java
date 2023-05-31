package fr.thomas.stock.controller;

import fr.thomas.stock.mapper.OrderMapper;
import fr.thomas.stock.model.dto.OrderDTO;
import fr.thomas.stock.model.dto.OrderResponseDTO;
import fr.thomas.stock.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getOrders(){
        return new ResponseEntity<>(OrderMapper.orderListToDto(orderService.getOrders()), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable(name = "orderId") Long orderId){
        return new ResponseEntity<>(OrderMapper.orderToDto(orderService.getOrder(orderId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody OrderDTO orderDTO){
        orderService.saveOrder(orderDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable(name = "orderId") Long orderId, @RequestBody OrderDTO orderDTO){
        orderService.updateOrder(orderId, orderDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable(name = "orderId") Long orderId){
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
