package tesis.Paschini.Benedictus.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="life_events")
public class LifeEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Date date;
    private String label;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id")
    private People people;

    public LifeEvent(Long id, Date date, String label, People people) {
        this.id = id;
        this.date = date;
        this.label = label;
        this.people = people;
    }

    @Id
    //TODO ver estrategia del id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Column(name="date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name="label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
