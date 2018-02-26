package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HEROES")
public class Hero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Hero(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Hero(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
