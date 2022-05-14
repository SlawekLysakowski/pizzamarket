package pl.edu.wszib.pizzamarket.data.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column (name = "id", nullable = false)
    private Long id;
    @Column(name = "pizza_name", nullable = false)
    private String PizzaName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_address_id")
    private OrderAddressEntity orderAddressEntity;

    public Long getId() {
        return id;
    }

    public String getPizzaName() {
        return PizzaName;
    }

    public OrderAddressEntity getOrderAddressEntity() {
        return orderAddressEntity;
    }
}
