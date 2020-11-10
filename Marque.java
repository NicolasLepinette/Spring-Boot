package couture.concessionnaire;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Brand {
    @Id
    private int id;
    private String name;
    @OneToMany
    @JoinColumn(name = "brand_id")
    private Set<Car> cars = new HashSet<Car>();

    @ManyToMany(mappedBy = "brands")
    private Set<Dealer> dealers = new HashSet<Dealer>();


    public Brand() {
    }

    public int getBrandId() {
        return id;
    }

    public void setBrandId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return name;
    }

    public void setBrandName(String name) {
        this.name = name;
    }
}
