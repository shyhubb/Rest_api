package Res.Restapi.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Res.Restapi.model.User;
import Res.Restapi.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String createAccount(User user) {
        // check xem da co email trong db hay chua
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email da ton tai!";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword())); // ma hoa mat khau
        userRepository.save(user);
        return "Tao tai khoan thanh cong!";
    }
}
