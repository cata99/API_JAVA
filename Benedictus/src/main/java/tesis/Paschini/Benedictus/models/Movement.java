package tesis.Paschini.Benedictus.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movements")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final Long id;
    @Column(name="user_id")
    private User userId;
    @Column(name="institution_id")
    private Institution institutionId;
    @Column(name="date")
    private Date date;
    @Column(name = "kind_of_movement", nullable = false)
    private Boolean kindOfMovement;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "movement_product",
            joinColumns = @JoinColumn(
                    name = "movement_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id", referencedColumnName = "id"
            )
    )
    private Set<Product> products = new HashSet<>();

    public Movement(Long id, User userId, Institution institutionId, Date date, Boolean kindOfMovement) {
        this.id = id;
        this.userId = userId;
        this.institutionId = institutionId;
        this.date = date;
        this.kindOfMovement = kindOfMovement;
    }

    @Id
    //TODO ver estrategia del id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Institution getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Institution institutionId) {
        this.institutionId = institutionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getKindOfMovement() {
        return kindOfMovement;
    }

    public void setKindOfMovement(Boolean kindOfMovement) {
        this.kindOfMovement = kindOfMovement;
    }
}
