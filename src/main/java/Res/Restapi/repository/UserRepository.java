package Res.Restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Res.Restapi.model.User;

public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByEmail(String email); // ham kiem tra xem email da ton tai chua
}
