package bg.softuni.pochivkarest.web;

import bg.softuni.pochivkarest.model.dto.UserRegisterDTO;
import bg.softuni.pochivkarest.model.user.PochivkaUserDetails;
import bg.softuni.pochivkarest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {
//    private UserService userService;
//
//    @Autowired
//    public UserProfileController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/user-profile")
//    public String getUserProfile(@AuthenticationPrincipal PochivkaUserDetails userDetails,
//                                 Model model) {
//        UserRegisterDTO userDTO = this.userService.getUserByUsername(userDetails.getUsername());
//        model.addAttribute("userProfile",  userDTO);
//        return "user-profile";
//    }
}
