package couture.concessionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping(path="dealer")
public class DealerController {
    @Autowired
    private DealerRepository DealerRepository;

    @GetMapping
    public Iterable<Dealer> getDealers()
    {
        return DealerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Dealer> getDealer(@PathVariable("id") int id)
    {
        return DealerRepository.findById(id);
    }

    @GetMapping("/search/{name}")
    public Set<Dealer> findDealersByNameStartsWith(@PathVariable("name") String name)
    {
        return DealerRepository.findDealersByNameStartsWith(name);
    }

    @PostMapping("/add")
    public void createDealer(@RequestBody Dealer newDealer) {
        if (!DealerRepository.existsById(newDealer.getDealerId())) {
            DealerRepository.save(newDealer);
        }
    }
}