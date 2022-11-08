package tesis.Paschini.Benedictus.model;

import javax.persistence.*;

@Entity
@Table(name="life_events")
public class LifeEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="date")
    private String date;
    @Column(name="label")
    private String label;

    @ManyToOne
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public LifeEvent() {
    }

    public LifeEvent(Long id, String date, String label, PersonalInformation personalInformation) {
        this.id = id;
        this.date = date;
        this.label = label;
        this.personalInformation = personalInformation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
