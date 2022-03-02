package pl.piotr.pizzaapplication.data.entity.size;

import pl.piotr.pizzaapplication.data.entity.ordersize.OrderSizeEntity;
import pl.piotr.pizzaapplication.data.entity.pizza.PizzaEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sizes")
public class SizeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "size_type")
    private String sizeType;

    @Column(name = "size_base")
    private String priceBase;

    @Column(name = "pizza_id")
    private String pizzaId;

    @OneToMany(mappedBy = "size")
    private Set<OrderSizeEntity> orderSizes;

    @ManyToOne
    @JoinColumn(name = "pizza_id", insertable = false, updatable = false)
    private PizzaEntity pizza;

}
