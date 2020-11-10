package couture.concessionnaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@RepositoryRestResource(path="brand")
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    public Set<Brand> findBrandsByNameStartsWith(@PathVariable("name") String name);
}
