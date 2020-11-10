package couture.concessionnaire;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Adress {
    @Id
    private int id;
    private String name;

    public Adress() {
    }

    public int getAdressId() {
        return id;
    }

    public void setAdressId(int id) {
        this.id = id;
    }

    public String getAdressName() {
        return name;
    }

    public void setAdressName(String name) {
        this.name = name;
    }
}
