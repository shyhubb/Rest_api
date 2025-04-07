package Res.Restapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import Res.Restapi.model.User;
import Res.Restapi.repository.AdminRepository;

@Service
public class AdminService {
    private AdminRepository adminRepository;

    public List<User> findAllUser() {
        return adminRepository.findAll();
    }
}
