package tesis.Paschini.Benedictus.models;

import javax.persistence.*;

@Entity
@Table(name="groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="label")
    private String label;


    public Group() {
    }

    public Group(Long id, Institution institution, String label) {
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
