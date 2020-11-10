package couture.concessionnaire;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Car {
    @Id
    private int id;
    private String name;


    public Car() {
    }

    public int getCarId() {
        return id;
    }

    public void setCarId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return name;
    }

    public void setCarName(String name) {
        this.name = name;
    }
}
