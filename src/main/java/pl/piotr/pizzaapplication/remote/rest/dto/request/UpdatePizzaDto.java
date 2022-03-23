package pl.piotr.pizzaapplication.remote.rest.dto.request;

import java.util.List;

public class UpdatePizzaDto {
    private String name;
    private List<AddSizeDto> sizes;

    public UpdatePizzaDto() {
    }

    public UpdatePizzaDto(String name, List<AddSizeDto> sizes) {
        this.name = name;
        this.sizes = sizes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddSizeDto> getSizes() {
        return sizes;
    }

    public void setSizes(List<AddSizeDto> sizes) {
        this.sizes = sizes;
    }
}
