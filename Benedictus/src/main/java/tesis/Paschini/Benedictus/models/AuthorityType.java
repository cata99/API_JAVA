package tesis.Paschini.Benedictus.models;

import javax.persistence.*;

@Entity
@Table(name="authorities_type")
public class AuthorityType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String service;

    public AuthorityType(Long id, String service) {
        this.id = id;
        this.service = service;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="service")
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
