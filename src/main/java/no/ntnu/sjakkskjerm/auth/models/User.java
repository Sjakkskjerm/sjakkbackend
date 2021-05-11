package no.ntnu.sjakkskjerm.auth.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    //ID, Brukernavn, Passord, Epost, Klubb, Rolle.

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long userId;

    @NotBlank
    @Size(max = 25)
    private String username;

    @NotBlank
    @Size(max = 75)
    @JsonIgnore
    private String password;

    @NotBlank
    @Size(max = 50)
    private String email;

    @NotBlank
    private String club;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_userId"), inverseJoinColumns = @JoinColumn(name = "role_roleId"))
    private Set<Role> roleSet = new HashSet<>();

    public User() {}

    public User(String username, String password, String email, String club) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.club = club;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
