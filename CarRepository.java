package couture.concessionnaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@RepositoryRestResource(path="car")
public interface CarRepository extends JpaRepository<Car, Integer> {
    public Set<Car> findCarsByNameStartsWith(@PathVariable("name") String name);
}
