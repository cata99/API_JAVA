package tesis.Paschini.Benedictus.model;


import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="label", unique = true, nullable = false)
    private String label;

    public Role() {
    }

    public void setId(Long id) {
        this.id = id;
    }

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
