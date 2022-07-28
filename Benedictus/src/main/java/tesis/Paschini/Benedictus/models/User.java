package tesis.Paschini.Benedictus.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final Long id;
    @Column(name="referent")
    private Boolean referent;
    @Column(name = "date_of_start")
    private Date dateOfStart;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private People people;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userId")
    private Set<Report> reports = new HashSet<>();
    private Long groupId;
    @Column(name="user", nullable = false, unique = true)
    private String user;
    @Column(name="password", nullable = false, unique = true)
    private String password;
    @Column(name ="token", nullable = false, unique = true)
    private String token;
    @Column(name ="expirationDate")
    private Date expirationDate;
    @Column(name="people_id", nullable = false)
    private Long peopleId;
    @Column(name="active", nullable = false)
    private Boolean active;

    public User(Long id, Boolean referent, Date dateOfStart, Set<Role> roles, Long groupId, String user, String password, Long peopleId) {
        this.id = id;
        this.referent = referent;
        this.dateOfStart = dateOfStart;
        this.roles = roles;
        this.groupId = groupId;
        this.user = user;
        this.password = password;
        this.peopleId = peopleId;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
