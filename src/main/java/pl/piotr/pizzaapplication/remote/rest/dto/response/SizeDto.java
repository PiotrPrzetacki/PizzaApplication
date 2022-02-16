package pl.piotr.pizzaapplication.remote.rest.dto.response;

import pl.piotr.pizzaapplication.domain.model.SizeType;

import java.math.BigDecimal;

public class SizeDto {

    private Integer id;
    private SizeType size;
    private BigDecimal price;

    public SizeDto() {
    }

    public SizeDto(Integer id, SizeType size, BigDecimal price) {
        this.id = id;
        this.size = size;
        this.price = price;
    }

    //modyfikator dostępu do metody public/ typ zwracany Integer/ nazwa metody getId
    public Integer getId() {
        return id;
    }

    //void - brak typu zwróconego
    public void setId(Integer id) {
        this.id = id;
    }

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
