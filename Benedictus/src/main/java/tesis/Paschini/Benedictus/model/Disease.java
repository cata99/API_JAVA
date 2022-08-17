package tesis.Paschini.Benedictus.model;

import javax.persistence.*;

@Entity
@Table(name="diseases")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="label", nullable = false)
    private String label;

    public Disease() {
    }

    public Disease(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public void setId(Long id) {
        this.id = id;
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
