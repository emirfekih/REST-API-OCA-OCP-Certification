package tn.insat.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.insat.model.security.User;

/**
 * Created by stephan on 20.03.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
