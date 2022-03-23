package pl.piotr.pizzaapplication.domain.service;

import org.springframework.stereotype.Service;
import pl.piotr.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.piotr.pizzaapplication.data.repository.PizzaRepository;
import pl.piotr.pizzaapplication.domain.mapper.PizzaMapper;
import pl.piotr.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.PizzaDto;

import static pl.piotr.pizzaapplication.domain.service.AuthorizationService.checkToken;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;

    public PizzaService(PizzaRepository pizzaRepository, PizzaMapper pizzaMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
    }

    public PizzaDto addPizza(AddPizzaDto addPizzaDto, String token) {
        checkToken(token);

        PizzaEntity savedPizzaEntity = pizzaRepository.save(pizzaMapper.mapToPizzaEntity(addPizzaDto));
    }
}
