package bg.softuni.pochivkarest.model.user;


import java.util.Collection;

public class PochivkaUserDetails {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
//    private Collection<GrantedAuthority> authorities;

    public PochivkaUserDetails(String username,
                               String password,
                               String firstName,
                               String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.authorities = authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

}
