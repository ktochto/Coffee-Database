package ktochto.com.example.kto.controller;

import ktochto.com.example.kto.model.Coffee;
import ktochto.com.example.kto.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/coffee")
    public String findAll(Model model) {
        List<Coffee> coffee = coffeeService.findAll();
        model.addAttribute("coffee", coffee);
        return "coffee-list";
    }

    @GetMapping("/coffee-create")
    public String createCoffeeForm() {
        return "coffee-create";
    }

    @PostMapping("/coffee-create")
    public String createCoffee(Coffee coffee) {
        coffeeService.saveCoffee(coffee);
        return "redirect:/coffee";
    }

    @GetMapping("/coffee-delete/{id}")
    public String deleteCoffee(@PathVariable("id") Long id) {
        coffeeService.deleteCoffee(id);
        return "redirect:/coffee";
    }

    @GetMapping("/update/{id}")
    public String updateCoffeeForm(@PathVariable("id") Long id, Model model){
        Coffee coffee = coffeeService.findCoffee(id);
        model.addAttribute("coffee", coffee);
        return "coffee-update";
    }

    @PostMapping("/update/{id}")
    public String updateCoffee(Coffee coffee){
        coffeeService.saveCoffee(coffee);
        return "redirect:/coffee";
    }

    @RequestMapping("/")
    public String filterCoffee(Model model, @Param("keyword") String keyword) {
        model.addAttribute("coffee", coffeeService.findByCountry(keyword));
        model.addAttribute("keyword", keyword);
        return "coffee-list";
    }


}
