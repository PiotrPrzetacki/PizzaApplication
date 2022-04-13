package pl.piotr.pizzaapplication.domain.service;

import org.springframework.stereotype.Service;
import pl.piotr.pizzaapplication.data.repository.SizeRepository;
import pl.piotr.pizzaapplication.domain.exception.ResourceNotFoundException;
import pl.piotr.pizzaapplication.remote.rest.dto.request.AddOrderDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.TokenDto;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddOrderService {

    private SizeRepository sizeRepository;

    public AddOrderService(SizeRepository sizeRepository){
        this.sizeRepository = sizeRepository;
    }

    public TokenDto addOrder(AddOrderDto addOrderDto){

        Set<Integer> sizeIds = addOrderDto.getPizzas()
                .stream()
                .map(pizzaOrderDto -> pizzaOrderDto.getSizeId())
                .collect(Collectors.toSet());
        Boolean existSizes = sizeRepository.existsAllByIdIn(sizeIds);
        if(!existSizes){
            throw new ResourceNotFoundException("Pizze o podanym rozmiarze nie istnieją w bazie danych");
        }
        String token = UUID.randomUUID().toString();
    }
}
