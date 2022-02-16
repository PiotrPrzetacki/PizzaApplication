package pl.piotr.pizzaapplication.remote.rest.dto.response;

import java.util.List;

public class PizzaDto {

    private Integer id;
    private String name;
    private List<SizeDto> sizes;

    public PizzaDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SizeDto> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeDto> sizes) {
        this.sizes = sizes;
    }

    public PizzaDto(Integer id, String name, List<SizeDto> sizes) {
        this.id = id;
        this.name = name;
        this.sizes = sizes;
    }
}