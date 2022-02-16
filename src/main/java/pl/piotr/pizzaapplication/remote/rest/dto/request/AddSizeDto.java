package pl.piotr.pizzaapplication.remote.rest.dto.request;

import pl.piotr.pizzaapplication.domain.model.SizeType;

public class AddSizeDto {

    private SizeType size;
    private Integer price;

    public AddSizeDto() {

    }

    public AddSizeDto(SizeType size, Integer price) {
        this.size = size;
        this.price = price;
    }

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
