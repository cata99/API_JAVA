package tesis.Paschini.Benedictus.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
@Table(name="donation")
@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="creation_date")
    private String creationDate;

    @Column(name="update_date")
    private String updateDate;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;

    public Donation (){
    }

    public Donation(Long id, String creationDate, String updateDate, Institution institution, User user, PersonalInformation personalInformation) {
        this.id = id;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.institution = institution;
        this.user = user;
        this.personalInformation = personalInformation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }


}
