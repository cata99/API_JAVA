package tesis.Paschini.Benedictus.payload.request;

import tesis.Paschini.Benedictus.model.Group;
import tesis.Paschini.Benedictus.model.PersonalInformation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

public class UpdateUserRequest {

    // Personal Information data
    private PersonalInformation personalInformation;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    private Group group;

    private Set<String> role;

    private Date dateOfStart;

    private Boolean referent;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public Boolean getReferent() {
        return referent;
    }

    public void setReferent(Boolean referent) {
        this.referent = referent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
