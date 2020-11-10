package couture.concessionnaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@RepositoryRestResource(path="customer")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Set<Customer> findCustomersByNameStartsWith(@PathVariable("name") String name);
}
