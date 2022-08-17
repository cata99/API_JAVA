package tesis.Paschini.Benedictus.model;

import javax.persistence.*;


@Entity
@Table(name="Delivery_Quantity")
public class Delivery_Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Delivery_Quantity() {
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

