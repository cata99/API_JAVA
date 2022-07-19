package tesis.Paschini.Benedictus.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="diseases")
public class Disease {

    private final Long id;
    private String label;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER,
            mappedBy = "diseases")
    private Set<Institution> institutions = new HashSet<>();
    //TODO ver lo de la cantidad

    public Disease(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    @Id
    //TODO ver estrategia del id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    @Column(name="label", nullable = false)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
