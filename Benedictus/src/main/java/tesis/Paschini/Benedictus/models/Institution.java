package tesis.Paschini.Benedictus.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final Long id;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name = "location", nullable = false, unique = true)
    private String location;
    @Column(name = "description")
    private String description;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "institution", fetch = FetchType.LAZY)
    private Group group;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "institutionId")
    private Set<Report> reports = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "institution_disease",
            joinColumns = @JoinColumn(
                    name = "institution_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "disease_id", referencedColumnName = "id"
            )
    )
    private Set<Disease> diseases = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "institution_authority",
            joinColumns = @JoinColumn(
                    name = "institution_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "authority_id", referencedColumnName = "id"
            )
    )
    private Set<Authority> authorities = new HashSet<>();

    public Institution(Long id, String phone, String name, String location, String description) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.location = location;
        this.description = description;
    }

    @Id
    //TODO ver estrategia del id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
