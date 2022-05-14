package pl.edu.wszib.pizzamarket.web.mappers;

import pl.edu.wszib.pizzamarket.data.entities.OrderAddressEntity;
import pl.edu.wszib.pizzamarket.data.repositories.OrderRepository;
import pl.edu.wszib.pizzamarket.data.repositories.PizzaRepository;
import pl.edu.wszib.pizzamarket.services.OrderService;
import pl.edu.wszib.pizzamarket.web.models.OrderAddressModel;

public class OrderAddressMapper {

    public static OrderAddressEntity toEntity(OrderAddressModel model){
        OrderAddressEntity entity = new OrderAddressEntity();
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setStreet(model.getStreet());
        entity.setPostalCode(model.getPostalCode());
        entity.setCity(model.getCity());
        return entity;
    }

}
