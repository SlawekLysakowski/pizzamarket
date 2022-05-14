package pl.edu.wszib.pizzamarket.services;

import org.springframework.stereotype.Service;
import pl.edu.wszib.pizzamarket.data.entities.OrderAddressEntity;
import pl.edu.wszib.pizzamarket.data.entities.OrderEntity;
import pl.edu.wszib.pizzamarket.data.entities.PizzaEntity;
import pl.edu.wszib.pizzamarket.web.mappers.OrderAddressMapper;
import pl.edu.wszib.pizzamarket.web.models.OrderAddressModel;
import pl.edu.wszib.pizzamarket.data.repositories.OrderRepository;
import pl.edu.wszib.pizzamarket.data.repositories.PizzaRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class OrderService {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;

    public OrderService(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void saveOrder(Long pizzaId, OrderAddressModel orderAddressModel){
        PizzaEntity pizzaEntity = pizzaRepository.findById(pizzaId).orElseThrow(EntityNotFoundException::new);
        OrderAddressEntity orderAddressEntity = OrderAddressMapper.toEntity(orderAddressModel);
        pl.wszib.pizzamarket.data.entities.OrderEntity orderEntity = new OrderEntity();
        orderEntity.setPizzaName(pizzaEntity.getName());
        orderEntity.setOrderAddress(orderAddressEntity);
        orderRepository.save(orderEntity);
    }

}
