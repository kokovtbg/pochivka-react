package bg.softuni.pochivkarest.web.rest;

import bg.softuni.pochivkarest.model.dto.UserLoginDTO;
import bg.softuni.pochivkarest.security.dto.AuthenticationResponse;
import bg.softuni.pochivkarest.security.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody UserLoginDTO request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
