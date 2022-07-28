package tesis.Paschini.Benedictus.models;

import javax.persistence.*;

@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final Long id;
    @Column(name = "unit")
    private String unit;


    public Unit(Long id, String unit) {
        this.id = id;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
