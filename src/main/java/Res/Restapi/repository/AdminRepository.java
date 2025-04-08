package Res.Restapi.repository;

import Res.Restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<User, String> {

    boolean existsByEmail(String email); // ham kiem tra xem email da ton tai chua
}
