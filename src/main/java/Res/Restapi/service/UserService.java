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

    // Method to create a new account
    public String createAccount(User user) {
        String email = user.getEmail().toLowerCase().trim(); // Chuyển email thành chữ thường và loại bỏ khoảng trắng
                                                             // đầu/cuối

        // Kiểm tra email không được để trống
        if (email.isEmpty()) {
            return "Email không được để trống!";
        }

        // Kiểm tra email không chứa dấu cách
        if (email.contains(" ")) {
            return "Không nhập dấu ' ' trong trường này!";
        }

        // Kiểm tra định dạng email có kết thúc bằng "@gmail.com"
        if (!email.endsWith("@gmail.com")) {
            return "Vui lòng nhập đúng định dạng email: example@gmail.com";
        }

        // Kiểm tra xem email đã tồn tại trong cơ sở dữ liệu chưa
        if (userRepository.existsByEmail(email)) {
            return "Email đã tồn tại!"; // Trả về thông báo lỗi nếu email đã tồn tại
        }

        // Mã hóa mật khẩu người dùng trước khi lưu vào cơ sở dữ liệu
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Lưu thông tin người dùng vào cơ sở dữ liệu
        userRepository.save(user);

        return "Tạo tài khoản thành công!"; // Trả về thông báo thành công
    }

    // Method to handle user login
    public String login(String email, String password) {
        // Check if email exists
        if (!userRepository.existsByEmail(email)) {
            return "Email không tồn tại trong hệ thống!";
        }

        // Find the user by email
        User user = userRepository.findByEmail(email);

        // If user is found, check if the password matches
        if (user != null) {
            // Compare the password entered by the user with the encoded password
            if (passwordEncoder.matches(password, user.getPassword())) {
                return "Đăng nhập thành công!"; // Return success message
            } else {
                return "Mật khẩu không chính xác!"; // Return error message for incorrect password
            }
        }

        // In case the user is not found (this should not happen because we checked
        // email existence earlier)
        return "Lỗi hệ thống, vui lòng thử lại!";
    }
}
