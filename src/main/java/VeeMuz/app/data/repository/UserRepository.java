package VeeMuz.app.data.repository;

import VeeMuz.app.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmailAddress(String email);
}
