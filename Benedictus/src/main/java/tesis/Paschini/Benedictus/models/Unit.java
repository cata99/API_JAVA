package tesis.Paschini.Benedictus.models;

import javax.persistence.*;

@Entity
@Table(name="unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final Long id;
    private String unit;

    public Unit(Long id, String unit) {
        this.id = id;
        this.unit = unit;
    }

    @Id
    //TODO generation strategy
    public Long getId() {
        return id;
    }

    @Column(name="unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
