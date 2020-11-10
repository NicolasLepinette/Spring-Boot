package couture.concessionnaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@RepositoryRestResource(path="dealer")
public interface DealerRepository extends JpaRepository<Dealer, Integer> {
    public Set<Dealer> findDealersByNameStartsWith(@PathVariable("name") String name);
}
