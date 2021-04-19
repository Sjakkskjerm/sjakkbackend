package no.ntnu.sjakkskjerm.auth.security.reqrep;

import java.util.List;

public class JwtResponse {
    private String jwt;
    private String type = "Bearer";

    private Long userId;
    private String username;
    private String email;
    private String club;
    private List<String> roles;

    public JwtResponse(String jwt, Long userId, String username, String email, String club, List<String> roles) {
        this.jwt = jwt;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.club = club;
        this.roles = roles;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
