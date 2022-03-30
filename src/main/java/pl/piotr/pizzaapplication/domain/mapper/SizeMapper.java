package pl.piotr.pizzaapplication.domain.mapper;

import org.springframework.stereotype.Component;
import pl.piotr.pizzaapplication.data.entity.size.SizeEntity;
import pl.piotr.pizzaapplication.domain.model.SizeType;
import pl.piotr.pizzaapplication.remote.rest.dto.request.AddSizeDto;
import pl.piotr.pizzaapplication.remote.rest.dto.response.SizeDto;

import java.math.BigDecimal;

@Component
public class SizeMapper {

    public SizeEntity mapToSizeEntity(AddSizeDto addSizeDto, Integer pizzaId){
        SizeEntity sizeEntity = new SizeEntity();
        sizeEntity.setSizeType(addSizeDto.getSize().name());
        sizeEntity.setPriceBase(BigDecimal.valueOf(addSizeDto.getPrice()));
        sizeEntity.setPizzaId(pizzaId);
        return sizeEntity;
    }

    public SizeDto mapToSizeDto(SizeEntity sizeEntity){
        SizeDto sizeDto = new SizeDto();
        sizeDto.setSize(SizeType.valueOf(sizeEntity.getSizeType()));
        sizeDto.setPrice(sizeEntity.getPriceBase());
        sizeDto.setId(sizeEntity.getId());
        return sizeDto;
    }
}
