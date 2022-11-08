package tesis.Paschini.Benedictus.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;


@Entity
@Table(name="delivery")
@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Delivery() {
    }

    public Delivery(Long id, String date, Institution institution, User user) {
        this.id = id;
        this.date = date;
        this.institution = institution;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
