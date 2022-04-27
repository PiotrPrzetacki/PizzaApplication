package pl.piotr.pizzaapplication.domain.service;

import org.springframework.stereotype.Service;
import pl.piotr.pizzaapplication.data.entity.order.OrderEntity;
import pl.piotr.pizzaapplication.data.entity.ordersize.OrderSizeEntity;
import pl.piotr.pizzaapplication.data.repository.OrderRepository;
import pl.piotr.pizzaapplication.data.repository.OrderSizeRepository;
import pl.piotr.pizzaapplication.data.repository.SizeRepository;
import pl.piotr.pizzaapplication.domain.exception.ResourceNotFoundException;
import pl.piotr.pizzaapplication.domain.mapper.TokenMapper;
import pl.piotr.pizzaapplication.domain.model.OrderStatusType;
import pl.piotr.pizzaapplication.remote.rest.dto.request.AddOrderDto;
import pl.piotr.pizzaapplication.remote.rest.dto.request.PersonOrderDto;
import pl.piotr.pizzaapplication.remote.rest.dto.request.PizzaOrderDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.TokenDto;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddOrderService {

    private final SizeRepository sizeRepository;
    private final OrderRepository orderRepository;
    private final OrderSizeRepository orderSizeRepository;
    private final TokenMapper tokenMapper;

    public AddOrderService(SizeRepository sizeRepository, OrderRepository orderRepository, OrderSizeRepository orderSizeRepository,
                           TokenMapper tokenMapper){
        this.sizeRepository = sizeRepository;
        this.orderRepository = orderRepository;
        this.orderSizeRepository = orderSizeRepository;
        this.tokenMapper = tokenMapper;
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

        Date now = new Date();
        PersonOrderDto person = addOrderDto.getPerson();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setClientName(person.getName());
        orderEntity.setClientAddress(person.getAddress());
        orderEntity.setClientPhone(person.getPhone());
        orderEntity.setFloor(person.getFloor());
        orderEntity.setStatus(OrderStatusType.NEW.name());
        orderEntity.setCreatedAt(now);
        orderEntity.setUpdatedAt(now);
        orderEntity.setToken(token);
        orderRepository.save(orderEntity);

        Integer orderId = orderEntity.getId();

        List<PizzaOrderDto> pizzaOrderDtoList = addOrderDto.getPizzas();
        List<OrderSizeEntity> orderSizeEntities = pizzaOrderDtoList
                .stream()
                .map(PizzaOrderDto -> {
                    OrderSizeEntity orderSizeEntity = new OrderSizeEntity();
                    orderSizeEntity.setSizeId(PizzaOrderDto.getSizeId());
                    orderSizeEntity.setOrderId(orderId);
                    orderSizeEntity.setSizeCount(PizzaOrderDto.getCount());
                    return orderSizeEntity;
                }).collect(Collectors.toList());
        orderSizeRepository.saveAll(orderSizeEntities);

        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);

        return tokenMapper.mapToTokenDto(orderEntity);
    }
}
