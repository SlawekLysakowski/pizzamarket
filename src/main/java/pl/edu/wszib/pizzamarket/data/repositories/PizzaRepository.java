package pl.edu.wszib.pizzamarket.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pizzamarket.data.entities.PizzaEntity;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaEntity, Long> {
}
