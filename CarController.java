package couture.concessionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping(path="car")
public class CarController {
    @Autowired
    private CarRepository CarRepository;

    @GetMapping
    public Iterable<Car> getCars()
    {
        return CarRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable("id") int id)
    {
        return CarRepository.findById(id);
    }

    @GetMapping("/search/{name}")
    public Set<Car> findCarsByNameStartsWith(@PathVariable("name") String name)
    {
        return CarRepository.findCarsByNameStartsWith(name);
    }

    @PostMapping("/add")
    public void createCar(@RequestBody Car newCar) {
        if (!CarRepository.existsById(newCar.getCarId())) {
            CarRepository.save(newCar);
        }
    }
}