package bg.softuni.pochivkarest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {

//    @GetMapping("/login")
//    public String login() {
//        return "user-login";
//    }
//
//    // NOTE: This should be post mapping!
//    @PostMapping("/users/login-error")
//    public String onFailedLogin(
//            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String userName,
//            RedirectAttributes redirectAttributes) {
//
//        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, userName);
//        redirectAttributes.addFlashAttribute("bad_credentials",
//                true);
//
//        return "redirect:/login";
//    }
}
