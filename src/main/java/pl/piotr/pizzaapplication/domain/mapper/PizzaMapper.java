package pl.piotr.pizzaapplication.domain.mapper;

import org.springframework.stereotype.Component;
import pl.piotr.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.piotr.pizzaapplication.remote.rest.dto.request.AddPizzaDto;

@Component
public class PizzaMapper {

    public PizzaEntity mapToPizzaEntity(AddPizzaDto addPizzaDto) {
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setName(addPizzaDto.getName());
        return pizzaEntity;
    }
}
