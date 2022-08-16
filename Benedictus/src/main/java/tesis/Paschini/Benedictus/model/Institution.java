package tesis.Paschini.Benedictus.model;


import javax.persistence.*;

@Entity
@Table(name="institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name = "location", nullable = false, unique = true)
    private String location;
    @Column(name = "description")
    private String description;


    public Institution() {
    }

    public Institution(Long id, String phone, String name, String location, String description) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.location = location;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
