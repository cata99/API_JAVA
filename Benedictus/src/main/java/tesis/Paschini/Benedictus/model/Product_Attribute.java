package tesis.Paschini.Benedictus.model;

import javax.persistence.*;

@Entity
@Table(name= "product_attribute")
public class Product_Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @MapsId("attribute_id")
    private Attribute attribute;

    @Column(name="quantity")
    private Long quantity;

    public Product_Attribute() {
    }

    public Product_Attribute(Long id, Product product, Attribute attribute, Long quantity) {
        this.id = id;
        this.product = product;
        this.attribute = attribute;
        this.quantity = quantity;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
