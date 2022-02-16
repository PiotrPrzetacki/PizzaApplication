package pl.piotr.pizzaapplication.remote.rest.dto.request;

import pl.piotr.pizzaapplication.domain.model.OrderStatusType;

import java.util.List;

public class OrderUpdateDto {
    private OrderStatusType status;
    private List<PersonOrderDto> pizzas;
    private PersonOrderDto person;

    public OrderUpdateDto() {

    }

    public OrderUpdateDto(OrderStatusType status, List<PersonOrderDto> pizzas, PersonOrderDto person) {
        this.status = status;
        this.pizzas = pizzas;
        this.person = person;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

    public List<PersonOrderDto> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PersonOrderDto> pizzas) {
        this.pizzas = pizzas;
    }

    public PersonOrderDto getPerson() {
        return person;
    }

    public void setPerson(PersonOrderDto person) {
        this.person = person;
    }
}
