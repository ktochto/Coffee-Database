package ktochto.com.example.kto.controller;

import ktochto.com.example.kto.model.Coffee;
import ktochto.com.example.kto.service.CoffeeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CoffeeController {
    private final CoffeeManageService coffeeManageService;
    private static final String REDIRECT_COFFEE = "redirect:/coffee";
    private static final String COFFEE_ATTRIBUTE = "coffee";

    @Autowired
    public CoffeeController(CoffeeManageService coffeeManageService) {
        this.coffeeManageService = coffeeManageService;
    }

    @GetMapping("/coffee")
    public String findAll(Model model) {
        List<Coffee> coffee = coffeeManageService.findAll();
        model.addAttribute(COFFEE_ATTRIBUTE, coffee);
        return "coffee-list";
    }

    @GetMapping("/coffee-create")
    public String createCoffeeForm(Coffee coffee) {
        return "coffee-create";
    }

    @PostMapping("/coffee-create")
    public String createCoffee(@Validated Coffee coffee, Model model) {
        coffeeManageService.saveCoffee(coffee);
        return REDIRECT_COFFEE;
    }

    @GetMapping("/coffee-delete/{id}")
    public String deleteCoffee(@PathVariable("id") Long id) {
        coffeeManageService.deleteCoffee(id);
        return REDIRECT_COFFEE;
    }

    @GetMapping("/update/{id}")
    public String updateCoffeeForm(@PathVariable("id") Long id, Model model){
        Coffee coffee = coffeeManageService.findCoffee(id);
        model.addAttribute(COFFEE_ATTRIBUTE, coffee);
        return "coffee-update";
    }

    @PostMapping("/update/{id}")
    public String updateCoffee(Coffee coffee){
        coffeeManageService.saveCoffee(coffee);
        return REDIRECT_COFFEE;
    }

    @RequestMapping("/")
    public String filterCoffee(Model model, @Param("keyword") String keyword) {
        model.addAttribute(COFFEE_ATTRIBUTE, coffeeManageService.findByCountry(keyword));
        model.addAttribute("keyword", keyword);
        return "coffee-list";
    }


}
