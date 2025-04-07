package Res.Restapi.repository;

import Res.Restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<User, String> {

}
