package pl.piotr.pizzaapplication.remote.rest.dto.response;


import java.util.List;

public class OrderCollectionDto {

    private List<OrderDto> orders;

    public OrderCollectionDto() {

    }

    public OrderCollectionDto(List<OrderDto> orders) {
        this.orders = orders;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
