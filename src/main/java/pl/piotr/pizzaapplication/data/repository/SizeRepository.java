package pl.piotr.pizzaapplication.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotr.pizzaapplication.data.entity.size.SizeEntity;

public interface SizeRepository extends JpaRepository<SizeEntity, Integer> {

}
