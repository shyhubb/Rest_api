package Res.Restapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Res.Restapi.model.User;
import Res.Restapi.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository; // Tiêm AdminRepository

    public List<User> getAllUsers() {
        return adminRepository.findAll(); // Trả về danh sách người dùng
    }
}
