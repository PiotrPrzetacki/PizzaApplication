package pl.piotr.pizzaapplication.remote.rest.dto.request;

public class PizzaOrderDto {

    private Integer id;
    private Integer sizeId;
    private Integer count;

    public PizzaOrderDto() {
    }

    public PizzaOrderDto(Integer id, Integer sizeId, Integer count) {
        this.id = id;
        this.sizeId = sizeId;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCunt(Integer cunt) {
        this.count = cunt;
    }
}
