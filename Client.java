package couture.concessionnaire;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Customer {
    @Id
    private int id;
    private String name;
    @OneToMany
    @JoinColumn(name = "customer_id")
    private Set<Car> cars = new HashSet<Car>();

    public Customer() {
    }

    public int getCustomerId() {
        return id;
    }

    public void setCustomerId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return name;
    }

    public void setCustomerName(String name) {
        this.name = name;
    }
}
