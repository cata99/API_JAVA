package tesis.Paschini.Benedictus.model;

import javax.persistence.*;

@Entity
@Table(name="institution_authority")
public class InstitutionAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "authority_id")
    private Authority authority;

    public InstitutionAuthority() {
    }

    public InstitutionAuthority(Long id, Institution institution, Authority authority) {
        this.id = id;
        this.institution = institution;
        this.authority = authority;
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

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
