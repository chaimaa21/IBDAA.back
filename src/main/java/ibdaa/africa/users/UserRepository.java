package ibdaa.africa.users;

import org.springframework.data.jpa.repository.JpaRepository;
import ibdaa.africa.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
