package tesis.Paschini.Benedictus.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "female_quantity", nullable = false)
    private String femaleQuantity;
    @Column(name = "male_quantity", nullable = false)
    private String maleQuantity;
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Report() {
    }

    public Report(Long id, String description, Date date, String femaleQuantity, String maleQuantity) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.femaleQuantity = femaleQuantity;
        this.maleQuantity = maleQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFemaleQuantity() {
        return femaleQuantity;
    }

    public void setFemaleQuantity(String femaleQuantity) {
        this.femaleQuantity = femaleQuantity;
    }

    public String getMaleQuantity() {
        return maleQuantity;
    }

    public void setMaleQuantity(String maleQuantity) {
        this.maleQuantity = maleQuantity;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
