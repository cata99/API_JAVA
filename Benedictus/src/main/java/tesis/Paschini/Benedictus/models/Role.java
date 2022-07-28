package tesis.Paschini.Benedictus.models;


import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final Long id;
    @Column(name="label", unique = true, nullable = false)
    private String label;

    public Role(Long id, String label) {
        this.id = id;
        this.label = label;
    }
    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
