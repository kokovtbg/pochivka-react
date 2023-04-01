package bg.softuni.pochivkarest.security.dto;


public class AuthenticationResponse {
    private String token;
    private String username;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

