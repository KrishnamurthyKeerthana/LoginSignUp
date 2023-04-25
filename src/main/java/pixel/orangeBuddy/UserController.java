package pixel.orangeBuddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if (isAuthenticated) {
            User user = userService.findByEmail(email);
            //int loginCount = user.getLoginCount();

//            if (loginCount >= 1) {
//                user.setSurveyFilled(true);
//            }
//
//            user.setLoginCount(loginCount + 1);
            userService.save(user);

            return ResponseEntity.ok("{login:successful, isSurveyFilled:" + user.isSurveyFilled() + " userName: " + user.getUserName() + "}" );
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
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


//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto) {
//        System.out.println(userDto.getEmail());
//        System.out.println(userDto.getPassword());
//        String email = userDto.getEmail();
//        String password = userDto.getPassword();
//        boolean isSurveyFilled = userService.isSurveyFilled(userDto.getEmail());
//        // Check if email and password are not null or empty
//        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email and password are required");
//        }
//
//        // Check if password meets the required length
//        if (password.length() < 8) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password must be at least 8 characters long");
//        }
//        if (userService.authenticate(userDto)) {
//            return ResponseEntity.ok("{login:successful, isSurveyFilled:" + isSurveyFilled + "}");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }


}




