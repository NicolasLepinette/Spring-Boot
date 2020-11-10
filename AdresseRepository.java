package couture.concessionnaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@RepositoryRestResource(path="adress")
public interface AdressRepository extends JpaRepository<Adress, Integer> {
    public Set<Adress> findAdresssByNameStartsWith(@PathVariable("name") String name);
}
