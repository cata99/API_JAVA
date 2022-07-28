package tesis.Paschini.Benedictus.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "institution_id", referencedColumnName = "id")
    private Institution institution;
    @Column(name="label")
    private String label;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "group")
    private Set<User> users = new HashSet<>();

    public Group(Long id, Institution institution, String label) {
        this.id = id;
        this.institution = institution;
        this.label = label;
    }

    @Id
    //TODO generation strategy
    public Long getId() {
        return id;
    }
    //TODO relation


    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
