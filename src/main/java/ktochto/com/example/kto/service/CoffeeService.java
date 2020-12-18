package ktochto.com.example.kto.service;

import ktochto.com.example.kto.model.Coffee;
import ktochto.com.example.kto.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    @Autowired
    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public Coffee findCoffee(Long id) { return coffeeRepository.getOne(id); }

    public List<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    public void saveCoffee(Coffee coffee) {
        coffeeRepository.save(coffee);
    }

    public void deleteCoffee(Long id) {
        coffeeRepository.deleteById(id);
    }

    public List<Coffee> findByCountry(String keyword) {
        return coffeeRepository.findAllByCountry(keyword);
    }

}