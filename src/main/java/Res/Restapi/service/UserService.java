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

}
