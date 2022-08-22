package tesis.Paschini.Benedictus.model;

import javax.persistence.*;


@Entity
@Table(name="DeliveryQuantity")
public class DeliveryQuantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "donation_product_id")
    private DonationProduct donationProduct;
    
    @Column(name="quantity")
    private Long quantity;

    public DonationProduct getDonationProduct() {
        return donationProduct;
    }

    public void setDonationProduct(DonationProduct donationProduct) {
        this.donationProduct = donationProduct;
    }


    public DeliveryQuantity() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}

