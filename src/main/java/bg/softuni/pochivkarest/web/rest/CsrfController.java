package bg.softuni.pochivkarest.web.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000/")
@RestController
public class CsrfController {
//    @GetMapping("/csrf")
//    public CsrfToken csrfToken(CsrfToken token) {
//        return token;
//    }
}
