package pixel.orangeBuddy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pixel.orangeBuddy.Entity.*;
import pixel.orangeBuddy.Service.UserService;
import pixel.orangeBuddy.Service.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        User user = userService.registerUser(userDto);
        if (user != null) {
            return ResponseEntity.ok("First Name: " + user.getFirstName() + " Last Name: " + user.getLastName());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        boolean isAuthenticated = userService.authenticate(loginDto);
        LoginResponse loginResponse = new LoginResponse();
        if (isAuthenticated) {
            User user = userService.findByEmail(email);
            userService.save(user);
            loginResponse.setLogin("successful");
            loginResponse.setUserName(user.getUserName());
            loginResponse.setSurveyFilled(user.isSurveyFilled());
            return ResponseEntity.ok(loginResponse );
        } else {
            loginResponse.setLogin("unsuccessful");
            loginResponse.setUserName("invalid");
            loginResponse.setSurveyFilled(false);
            return ResponseEntity.ok(loginResponse);
        }
    }


    @PostMapping("/survey")
    public ResponseEntity<String> updateSurveyStatus(@RequestBody UserSurvey userSurvey) {
        String username = userSurvey.getUserName();
        String email = userSurvey.getEmail();
        boolean isSurveyFilled = userSurvey.isSurveyFilled();
        System.out.println(username + email + isSurveyFilled);
        userServiceImpl.updateSurveyStatus(username, email, isSurveyFilled);
        return new ResponseEntity<>("Survey status updated successfully", HttpStatus.OK);
    }


}




