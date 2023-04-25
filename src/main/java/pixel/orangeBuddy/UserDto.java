package pixel.orangeBuddy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

    @JsonProperty("SUID")
    private String SUID;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    //private boolean isSurveyFilled;

    //private int loginCount;

    public UserDto(String SUID, String firstName, String lastName, String userName, String email, String password, boolean isSurveyFilled, int loginCount ) {
        this.SUID = SUID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        //this.isSurveyFilled = isSurveyFilled;
        //this.loginCount = loginCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSUID() {
        return SUID;
    }

    public void setSUID(String SUID) {
        this.SUID = SUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // public boolean isSurveyFilled() {
    //     return isSurveyFilled;
    // }

    // public void setSurveyFilled(boolean surveyFilled) {
    //     isSurveyFilled = surveyFilled;
    // }

    // public int getLoginCount() {
    //     return loginCount;
    // }

    // public void setLoginCount(int loginCount) {
    //     this.loginCount = loginCount;
    // }
}

