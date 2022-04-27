package pl.piotr.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotr.pizzaapplication.data.entity.order.OrderEntity;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    OrderEntity findByToken(String token);
    List<OrderEntity> findAllByStatus(String status);
}
