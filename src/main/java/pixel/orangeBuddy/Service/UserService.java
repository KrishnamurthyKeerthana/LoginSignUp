package pixel.orangeBuddy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pixel.orangeBuddy.Entity.LoginDto;
import pixel.orangeBuddy.Entity.User;
import pixel.orangeBuddy.Entity.UserDto;
import pixel.orangeBuddy.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setSUID(userDto.getSUID());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setSurveyFilled(userDto.isSurveyFilled());
        return userRepository.save(user);
    }

    public boolean authenticate(LoginDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());

        if (user != null && user.getPassword().equals(userDto.getPassword())) {
            return true;
        }

        return false;
    }


    public boolean isSurveyFilled(String email) {
        return false;
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }


}



