package tesis.Paschini.Benedictus.model;

import javax.persistence.*;

@Entity
@Table(name="attributes")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="field")
    private String field;

    @Column(name="unit")
    private String unit;


    public Attribute() {
    }

    public Attribute(Long id, String field, String unit) {
        this.id = id;
        this.field = field;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
