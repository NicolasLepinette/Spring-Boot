package couture.concessionnaire;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Dealer {
    @Id
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "dealer_id")
    private Set<Adress> adresss = new HashSet<Adress>();

    @ManyToMany
    @JoinTable(
            name = "dealer_brand",
            joinColumns = @JoinColumn(name = "dealer_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    private Set<Brand> brands = new HashSet<Brand>();

    public Dealer() {

    }

    public int getDealerId() {
        return id;
    }

    public void setDealerId(int id) {
        this.id = id;
    }

    public String getDealerName() {
        return name;
    }

    public void setDealerName(String name) {
        this.name = name;
    }
}
