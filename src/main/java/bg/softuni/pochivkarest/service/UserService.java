package bg.softuni.pochivkarest.service;

import bg.softuni.pochivkarest.model.dto.UserRegisterDTO;
import bg.softuni.pochivkarest.model.entity.User;
import bg.softuni.pochivkarest.model.mapper.UserMapper;
import bg.softuni.pochivkarest.model.user.PochivkaUserDetails;
import bg.softuni.pochivkarest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public boolean findUserByUsername(String username) {
        Optional<User> optByUsername = this.userRepository.findByUsername(username);
        if (optByUsername.isPresent()) {
            return true;
        }
        return false;
    }

    public boolean findUserByEmail(String email) {
        Optional<User> optByEmail = this.userRepository.findByEmail(email);
        if (optByEmail.isPresent()) {
            return true;
        }
        return false;
    }

    public boolean passwordsMatch(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return false;
        }
        return true;
    }

    public UserRegisterDTO register(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        this.userMapper.userRegisterDTOToUser(userRegisterDTO, user);
        this.userRepository.save(user);
        return userRegisterDTO;
    }

    public UserRegisterDTO getUserByUsername(String username) {
        Optional<User> optByUsername = this.userRepository.findByUsername(username);
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        if (optByUsername.isPresent()) {
            User user = optByUsername.get();
            userRegisterDTO.setUsername(user.getUsername());
            userRegisterDTO.setEmail(user.getEmail());
            userRegisterDTO.setPassword(user.getPassword());
            userRegisterDTO.setConfirmPassword(user.getPassword());
            userRegisterDTO.setFirstName(user.getFirstName());
            userRegisterDTO.setLastName(user.getLastName());
            userRegisterDTO.setTelephone(user.getTelephone());
            if (user.getTown() != null) {
                userRegisterDTO.setTown(user.getTown().getName().getValue());
            }
        }
        return userRegisterDTO;
    }

    public UserRegisterDTO update(UserRegisterDTO userEdit, PochivkaUserDetails userDetails) {
        Optional<User> optByUsername = this.userRepository.findByUsername(/**userDetails.getUsername()*/"username");
        User user;
        if (optByUsername.isPresent()) {
            user = optByUsername.get();
            this.userMapper.userRegisterDTOToUser(userEdit, user);
            this.userRepository.save(user);
            userDetails.setUsername(user.getUsername());
        }
        return userEdit;
    }
}
