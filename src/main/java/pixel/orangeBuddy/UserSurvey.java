package pixel.orangeBuddy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSurvey {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("isSurveyFilled")
    private boolean isSurveyFilled;

    public UserSurvey() {}

    public UserSurvey(String userName, String email, boolean isSurveyFilled) {
        this.userName = userName;
        this.email = email;
        this.isSurveyFilled = isSurveyFilled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSurveyFilled() {
        return isSurveyFilled;
    }

    public void setSurveyFilled(boolean surveyFilled) {
        isSurveyFilled = surveyFilled;
    }
}
