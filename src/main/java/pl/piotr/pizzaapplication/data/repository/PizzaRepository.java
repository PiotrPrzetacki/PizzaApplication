package pl.piotr.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotr.pizzaapplication.data.entity.pizza.PizzaEntity;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {

}
