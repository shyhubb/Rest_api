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

    public String chageRole(User user) {
        if (adminRepository.existsByEmail(user.getEmail()))
            return "Không tìm tháy người đùng có email: " + user.getEmail();
        user.setRole("ROLE_ADMIN");
        adminRepository.save(user);
        return "SET ROLE_ADMIN THÀNH CÔNG CHO: " + user.getEmail();
    }
}
