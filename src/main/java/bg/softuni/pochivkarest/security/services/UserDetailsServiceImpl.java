package bg.softuni.pochivkarest.security.services;

import bg.softuni.pochivkarest.model.entity.Role;
import bg.softuni.pochivkarest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).map(u -> new UserDetailsImpl(u.getUsername(),
                        u.getPassword(),
                        u.getFirstName(),
                        u.getLastName(),
                        u.getRoles().stream().map(this::map).toList()))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    }

    private GrantedAuthority map(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role.getName().name());
    }
}
