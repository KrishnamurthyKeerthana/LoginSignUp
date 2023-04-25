package pixel.orangeBuddy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSurveyRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);

}
