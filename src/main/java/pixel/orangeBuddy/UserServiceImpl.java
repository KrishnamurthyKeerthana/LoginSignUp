package pixel.orangeBuddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserSurveyRepository userSurveyRepository;

    public void updateSurveyStatus(String username, String email, boolean isSurveyFilled) {
        User user = userSurveyRepository.findByUserName(username);
        if (user != null && user.getEmail().equals(email)) {
            System.out.println(isSurveyFilled);
            user.setSurveyFilled(isSurveyFilled);
            System.out.println(user.isSurveyFilled());
            userSurveyRepository.save(user);
        }
    }
}
