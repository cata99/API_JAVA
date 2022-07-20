package tesis.Paschini.Benedictus.models;

import javax.persistence.*;

@Entity
@Table(name="attributes")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    private String field;
    private String value;
    //TODO ver esta relacion
    private Unit unitId;

    public Attribute(Long id, Product product, String field, String value, Unit unitId) {
        this.id = id;
        this.product = product;
        this.field = field;
        this.value = value;
        this.unitId = unitId;
    }


    public Long getId() {
        return id;
    }

    //TODO relation
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name="field")
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Column(name="value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }
}
