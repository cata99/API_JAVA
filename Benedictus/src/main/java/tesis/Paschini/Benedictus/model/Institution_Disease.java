package tesis.Paschini.Benedictus.model;

import javax.persistence.*;

@Entity
@Table(name="institution_disease")
public class Institution_Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
    
    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    public Institution_Disease() {
    }

    public Institution_Disease(Long id, Institution institution, Disease disease) {
        this.id = id;
        this.institution = institution;
        this.disease = disease;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}
