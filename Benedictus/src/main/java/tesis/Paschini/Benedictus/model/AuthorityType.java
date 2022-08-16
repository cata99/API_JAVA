package tesis.Paschini.Benedictus.model;

import javax.persistence.*;

@Entity
@Table(name="authorities_type")
public class AuthorityType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="service")
    private String service;




    public AuthorityType() {
    }

    public AuthorityType(Long id, String service) {
        this.id = id;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
