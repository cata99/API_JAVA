package tesis.Paschini.Benedictus.models;

import javax.persistence.*;

@Entity
@Table(name="donation_product")
public class Donation_Product {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "donation_id")
    private Donation donation;

    @Column(name="quantity")
    private Long quantity;

    public Donation_Product() {
    }

    public Donation_Product(Long id, Product product, Donation donation, Long quantity) {
        this.id = id;
        this.product = product;
        this.donation = donation;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
