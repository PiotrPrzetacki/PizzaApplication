package pl.piotr.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotr.pizzaapplication.data.entity.size.SizeEntity;

import java.util.Set;

public interface SizeRepository extends JpaRepository<SizeEntity, Integer> {

    void deleteAllByPizzaId(Integer pizzaId);

    Boolean existsAllByIdIn(Set<Integer> sizeIds);
}
