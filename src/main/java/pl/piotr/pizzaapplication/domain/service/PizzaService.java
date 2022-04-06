package pl.piotr.pizzaapplication.domain.service;

import org.springframework.stereotype.Service;
import pl.piotr.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.piotr.pizzaapplication.data.entity.size.SizeEntity;
import pl.piotr.pizzaapplication.data.repository.PizzaRepository;
import pl.piotr.pizzaapplication.data.repository.SizeRepository;
import pl.piotr.pizzaapplication.domain.exception.ResourceNotFoundException;
import pl.piotr.pizzaapplication.domain.mapper.PizzaMapper;
import pl.piotr.pizzaapplication.domain.mapper.SizeMapper;
import pl.piotr.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.piotr.pizzaapplication.remote.rest.dto.request.AddSizeDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.MenuDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.PizzaDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.SizeDto;

import java.util.List;
import java.util.stream.Collectors;

import static pl.piotr.pizzaapplication.domain.service.AuthorizationService.checkToken;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final SizeRepository sizeRepository;
    private final PizzaMapper pizzaMapper;
    private final SizeMapper sizeMapper;

    public PizzaService(PizzaRepository pizzaRepository, SizeRepository sizeRepository, PizzaMapper pizzaMapper, SizeMapper sizeMapper) {
        this.pizzaRepository = pizzaRepository;
        this.sizeRepository = sizeRepository;
        this.pizzaMapper = pizzaMapper;
        this.sizeMapper = sizeMapper;
    }

    public PizzaDto addPizza(AddPizzaDto addPizzaDto, String token) {
        checkToken(token);

        PizzaEntity pizzaEntity = pizzaMapper.mapToPizzaEntity(addPizzaDto);
        pizzaRepository.save(pizzaEntity);

        List<AddSizeDto> addSizeDtoList = addPizzaDto.getSizes();
        List<SizeEntity> sizeEntities = addSizeDtoList
                .stream()
                .map(addSizeDto -> sizeMapper.mapToSizeEntity(addSizeDto, pizzaEntity.getId()))
                .collect(Collectors.toList());
        List<SizeEntity> savedSizeEntities = sizeRepository.saveAll(sizeEntities);

        List<SizeDto> sizeDtoList = savedSizeEntities
                .stream()
                .map(sizeMapper::mapToSizeDto)
                .collect(Collectors.toList());


        return pizzaMapper.mapToPizzaDto(pizzaEntity, sizeDtoList);

    }

    public MenuDto getMenu(){
        List<PizzaEntity> pizzaEntities = pizzaRepository.findAll();
        List<PizzaDto> pizzaDtoList = pizzaEntities
                .stream()
                .map(pizzaEntity -> pizzaMapper.mapToPizzaDto(pizzaEntity))
                .collect(Collectors.toList());

        return new MenuDto(pizzaDtoList);
    }

    public  void deletePizza(Integer pizzaId, String token){
        checkToken(token);
        boolean pizzaExist = pizzaRepository.existsById(pizzaId);
        if(!pizzaExist){
            throw new ResourceNotFoundException("Pizza o podanym id nie istnieje");
        }
        pizzaRepository.deleteById(pizzaId);
    }
}
