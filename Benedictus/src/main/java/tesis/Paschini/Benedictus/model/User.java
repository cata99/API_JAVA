package tesis.Paschini.Benedictus.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "referent")
    private Boolean referent;
    @Column(name = "date_of_start")
    private Date dateOfStart;
    @Column(name = "user", nullable = false, unique = true)
    private String user;
    @Column(name = "password", nullable = false, unique = true)
    private String password;
    @Column(name = "token", nullable = false, unique = true)
    private String token;
    @Column(name = "expirationDate")
    private Date expirationDate;

    @OneToOne
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "active", nullable = false)
    private Boolean active;

    //TODO falta relacion con roles

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public User() {
    }

    public User(Long id, Boolean referent, Date dateOfStart , String user, String password) {
        this.id = id;
        this.referent = referent;
        this.dateOfStart = dateOfStart;
        this.user = user;
        this.password = password;

    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public Boolean getReferent() {
        return referent;
    }

    public void setReferent(Boolean referent) {
        this.referent = referent;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
