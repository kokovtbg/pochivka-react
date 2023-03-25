package bg.softuni.pochivkarest.web.rest;

import bg.softuni.pochivkarest.model.dto.UserLoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class LoginControllerREST {

    @PostMapping("/login-rest")
    public ResponseEntity<String> authenticateUser(@RequestBody UserLoginDTO loginDto){

        return ResponseEntity.ok("User signed-in successfully!.");
    }
}
