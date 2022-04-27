package pl.piotr.pizzaapplication.domain.service;

import org.springframework.stereotype.Service;
import pl.piotr.pizzaapplication.data.repository.OrderRepository;
import pl.piotr.pizzaapplication.data.repository.OrderSizeRepository;
import pl.piotr.pizzaapplication.domain.exception.ResourceNotFoundException;

import static pl.piotr.pizzaapplication.domain.service.AuthorizationService.checkToken;

@Service
public class DeleteOrderService {

    private final OrderRepository orderRepository;
    private final OrderSizeRepository orderSizeRepository;

    public DeleteOrderService(OrderRepository orderRepository, OrderSizeRepository orderSizeRepository) {
        this.orderRepository = orderRepository;
        this.orderSizeRepository = orderSizeRepository;
    }

    public void deleteOrder(Integer orderId, String token){
        checkToken(token);
        boolean orderExist = orderRepository.existsById(orderId);
        if(!orderExist){
            throw new ResourceNotFoundException("Zamówienie o podanym id nie istnieje");
        }
        orderSizeRepository.deleteAllByOrderId(orderId);
        orderRepository.deleteById(orderId);
    }
}
