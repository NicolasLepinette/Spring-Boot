package couture.concessionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping(path="adress")
public class AdressController {
    @Autowired
    private AdressRepository AdressRepository;

    @GetMapping
    public Iterable<Adress> getAdresss()
    {
        return AdressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Adress> getAdress(@PathVariable("id") int id)
    {
        return AdressRepository.findById(id);
    }

    @GetMapping("/search/{name}")
    public Set<Adress> findAdresssByNameStartsWith(@PathVariable("name") String name)
    {
        return AdressRepository.findAdresssByNameStartsWith(name);
    }

    @PostMapping("/add")
    public void createAdress(@RequestBody Adress newAdress) {
        if (!AdressRepository.existsById(newAdress.getAdressId())) {
            AdressRepository.save(newAdress);
        }
    }
}