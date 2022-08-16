package tesis.Paschini.Benedictus.model;

import javax.persistence.*;


@Entity
@Table(name="Delivery_Quantity")
public class Delivery_Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_attribute_id")
    private Product_Attribute productAttribute;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Delivery_Quantity() {
    }

    public Delivery_Quantity(Long id, Product_Attribute productAttribute, Delivery delivery) {
        this.id = id;
        this.productAttribute = productAttribute;
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product_Attribute getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(Product_Attribute productAttribute) {
        this.productAttribute = productAttribute;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}

