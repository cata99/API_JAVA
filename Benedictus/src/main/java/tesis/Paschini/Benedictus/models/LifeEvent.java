package tesis.Paschini.Benedictus.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="life_events")
public class LifeEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="date")
    private Date date;
    @Column(name="label")
    private String label;

    public LifeEvent() {
    }

    public LifeEvent(Long id, Date date, String label) {
        this.id = id;
        this.date = date;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
