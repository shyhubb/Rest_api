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

    public String changeRole(String email) {
        // Kiểm tra xem người dùng có tồn tại trong cơ sở dữ liệu không
        User user = adminRepository.findByEmail(email); // Bạn cần có phương thức này trong repository
        if (user == null) {
            return "Không tìm thấy người dùng có email: " + email;
        }
        // Cập nhật vai trò của người dùng thành ROLE_ADMIN
        user.setRole("ROLE_ADMIN");

        // Lưu người dùng với vai trò đã thay đổi vào cơ sở dữ liệu
        adminRepository.save(user);

        return "SET ROLE_ADMIN THÀNH CÔNG CHO: " + user.getEmail();
    }

    public String deleteUser(String email) {
        if (!adminRepository.existsByEmail(email))
            return "Khong tim thay user: " + email + " !"; // check nguoi dung co ton tai khong
        User user = adminRepository.findByEmail(email);
        if (!user.getRole().equals("ROLE_ADMIN")) {
            adminRepository.delete(user);
            return "Xoa user: " + user.getEmail() + " Thanh cong !";
        }
        return "Khong the xoa ADMIN he thong!";
    }

}
