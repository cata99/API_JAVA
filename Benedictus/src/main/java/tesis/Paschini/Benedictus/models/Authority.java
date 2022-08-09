package tesis.Paschini.Benedictus.models;

import javax.persistence.*;

@Entity
@Table(name="authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "label", nullable = false)
    private String label;
    @Column(name="phone", unique = true)
    private String phone;
    @Column(name = "location", nullable = false, unique = true)
    private String location;


    public Authority() {
    }

    public Authority(Long id, String label, String phone, String location) {
        this.id = id;
        this.label = label;
        this.phone = phone;
        this.location = location;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

}
