package tesis.Paschini.Benedictus.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id")
    private Institution institutionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    //TODO ver esta relacion con fede

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movement_id", referencedColumnName = "id")
    private Movement movementId;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "female_quantity", nullable = false)
    private String femaleQuantity;
    @Column(name = "male_quantity", nullable = false)
    private String maleQuantity;

    public Report(Long id, Institution institutionId, User userId, Movement movementId, String description, Date date) {
        this.id = id;
        this.institutionId = institutionId;
        this.userId = userId;
        this.movementId = movementId;
        this.description = description;
        this.date = date;
    }

    public Report(Long id, Institution institutionId, User userId, Movement movementId, String description, Date date, String femaleQuantity, String maleQuantity) {
        this.id = id;
        this.institutionId = institutionId;
        this.userId = userId;
        this.movementId = movementId;
        this.description = description;
        this.date = date;
        this.femaleQuantity = femaleQuantity;
        this.maleQuantity = maleQuantity;
    }

    public Long getId() {
        return id;
    }

    public Institution getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Institution institutionId) {
        this.institutionId = institutionId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Movement getMovementId() {
        return movementId;
    }

    public void setMovementId(Movement movementId) {
        this.movementId = movementId;
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
}
