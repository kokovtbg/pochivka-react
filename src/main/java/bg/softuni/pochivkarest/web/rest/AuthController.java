package bg.softuni.pochivkarest.web.rest;

import bg.softuni.pochivkarest.model.dto.UserLoginDTO;
import bg.softuni.pochivkarest.model.dto.UserRegisterDTO;
import bg.softuni.pochivkarest.model.entity.User;
import bg.softuni.pochivkarest.payload.response.JwtResponse;
import bg.softuni.pochivkarest.payload.response.MessageResponse;
import bg.softuni.pochivkarest.repository.RoleRepository;
import bg.softuni.pochivkarest.repository.UserRepository;
import bg.softuni.pochivkarest.security.jwt.JwtUtils;
import bg.softuni.pochivkarest.security.services.UserDetailsImpl;
import bg.softuni.pochivkarest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody UserLoginDTO loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterDTO signUpRequest) {
        if (userService.findUserByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userService.findUserByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }


        // Create new user's account
        userService.register(signUpRequest);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
