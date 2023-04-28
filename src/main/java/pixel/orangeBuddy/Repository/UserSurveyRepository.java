package pixel.orangeBuddy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pixel.orangeBuddy.Entity.User;

public interface UserSurveyRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);

}
