package bg.softuni.pochivkarest.service;

import bg.softuni.pochivkarest.model.entity.Role;
import bg.softuni.pochivkarest.model.entity.User;
import bg.softuni.pochivkarest.model.user.PochivkaUserDetails;
import bg.softuni.pochivkarest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PochivkaUserDetailsService  {
    private UserRepository userRepository;

    @Autowired
    public PochivkaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return this.userRepository
//                .findByUsername(username)
//                .map(this::map)
//                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found!"));
//    }

//    private UserDetails map(User user) {
//        return new PochivkaUserDetails(
//                user.getUsername(),
//                user.getPassword(),
//                user.getFirstName(),
//                user.getLastName(),
//                user.getRoles().stream().map(this::map).toList());
//    }
//
//    private GrantedAuthority map(Role role) {
//        return new SimpleGrantedAuthority("ROLE_" + role.getName().name());
//    }
}
