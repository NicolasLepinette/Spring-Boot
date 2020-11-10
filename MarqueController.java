package couture.concessionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping(path="brand")
public class BrandController {
    @Autowired
    private BrandRepository BrandRepository;

    @GetMapping
    public Iterable<Brand> getBrands()
    {
        return BrandRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Brand> getBrand(@PathVariable("id") int id)
    {
        return BrandRepository.findById(id);
    }

    @GetMapping("/search/{name}")
    public Set<Brand> findBrandsByNameStartsWith(@PathVariable("name") String name)
    {
        return BrandRepository.findBrandsByNameStartsWith(name);
    }

    @PostMapping("/add")
    public void createBrand(@RequestBody Brand newBrand) {
        if (!BrandRepository.existsById(newBrand.getBrandId())) {
            BrandRepository.save(newBrand);
        }
    }
}