package Res.Restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Res.Restapi.model.User;
import Res.Restapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Khởi tạo BCryptPasswordEncoder

    public String createAccount(User user) {
        // Kiểm tra xem email đã tồn tại trong cơ sở dữ liệu chưa
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email đã tồn tại!"; // Trả về thông báo lỗi nếu email đã tồn tại
        }

        // Mã hóa mật khẩu người dùng trước khi lưu vào cơ sở dữ liệu
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getCreatedAt();
        // Lưu thông tin người dùng vào cơ sở dữ liệu
        userRepository.save(user);

        return "Tạo tài khoản thành công!"; // Trả về thông báo thành công
    }
}
