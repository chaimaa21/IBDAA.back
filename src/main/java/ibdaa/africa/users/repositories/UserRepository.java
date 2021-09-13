package ibdaa.africa.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ibdaa.africa.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}