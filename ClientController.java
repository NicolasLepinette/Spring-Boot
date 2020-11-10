package couture.concessionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping(path="customer")
public class CustomerController {
    @Autowired
    private CustomerRepository CustomerRepository;

    @GetMapping
    public Iterable<Customer> getCustomers()
    {
        return CustomerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable("id") int id)
    {
        return CustomerRepository.findById(id);
    }

    @GetMapping("/search/{name}")
    public Set<Customer> findCustomersByNameStartsWith(@PathVariable("name") String name)
    {
        return CustomerRepository.findCustomersByNameStartsWith(name);
    }

    @PostMapping("/add")
    public void createCustomer(@RequestBody Customer newCustomer) {
        if (!CustomerRepository.existsById(newCustomer.getCustomerId())) {
            CustomerRepository.save(newCustomer);
        }
    }
}