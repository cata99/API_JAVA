package tesis.Paschini.Benedictus.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="authorities")
public class Authority {

    private final Long id;
    @Column(name = "label", nullable = false)
    private String label;
    @Column(name="phone", nullable = true, unique = true)
    private String phone;
    @Column(name = "location", nullable = false, unique = true)
    private String location;
    @OneToMany
    @JoinColumn(name="type_id", referencedColumnName = "id")
    private AuthorityType typeId;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER,
            mappedBy = "authorities")
    private Set<Institution> institutions = new HashSet<>();

    public Authority(Long id, String label, String phone, String location, AuthorityType typeId) {
        this.id = id;
        this.label = label;
        this.phone = phone;
        this.location = location;
        this.typeId = typeId;
    }

    @Id
    //TODO ver estrategia del id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public AuthorityType getTypeId() {
        return typeId;
    }

    public void setTypeId(AuthorityType typeId) {
        this.typeId = typeId;
    }
}
