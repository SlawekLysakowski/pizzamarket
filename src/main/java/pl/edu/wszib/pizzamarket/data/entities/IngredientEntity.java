package pl.edu.wszib.pizzamarket.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class IngredientEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
