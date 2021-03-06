package pl.edu.wszib.pizzamarket.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.pizzamarket.data.entities.PizzaEntity;
import pl.edu.wszib.pizzamarket.services.OrderService;
import pl.edu.wszib.pizzamarket.web.models.OrderAddressModel;
import pl.edu.wszib.pizzamarket.data.repositories.PizzaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {

    private final PizzaRepository pizzaRepository;
    private final OrderService orderService;

    public MenuController(PizzaRepository pizzaRepository, OrderService orderService) {
        this.pizzaRepository = pizzaRepository;
        this.orderService = orderService;

    }

    @GetMapping
    public String showPizzaMenu(Model model) {
        List<PizzaEntity> pizzas = pizzaRepository.findAll();
        model.addAttribute("pizzas", pizzas);
        return "menuPage";
    }

    @GetMapping("order/{pizzaId}")
    public String showPizzaOrderPage(@PathVariable Long pizzaId, @ModelAttribute("orderAddress") OrderAddressModel orderAddress, Model model) {
    PizzaEntity pizza = pizzaRepository.findById(pizzaId).orElseThrow(EntityNotFoundException::new);
    model.addAttribute("pizza", pizza);
        return "orderPizzaPage";
    }

    @PostMapping("order/{pizzaId}")
    public String processPizzaOrder(@PathVariable Long pizzaId, @ModelAttribute("orderAddress") OrderAddressModel orderAddress){

        orderService.saveOrder(pizzaId, orderAddress);
        return "redirect:/menu";
    }



}
