package no.ntnu.sjakkskjerm.auth.security.reqrep;

import java.util.List;

public class JwtResponse {
    private String access_token;
    private String type = "Bearer";
    private Long userId;
    private List<String> roles;

    public JwtResponse(String access_token, Long userId, List<String> roles) {
        this.access_token = access_token;
        this.userId = userId;
        this.roles = roles;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
