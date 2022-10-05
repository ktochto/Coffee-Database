package ktochto.com.example.kto.service;

import ktochto.com.example.kto.model.Coffee;
import ktochto.com.example.kto.repository.CoffeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoffeeManageService {
    @Autowired
    private final CoffeeRepository coffeeRepository;

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