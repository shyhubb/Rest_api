package Res.Restapi.controller;

import Res.Restapi.model.User;
import Res.Restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint đăng ký người dùng
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String result = userService.createAccount(user);

        // Nếu kết quả trả về là "Email đã tồn tại", trả về mã HTTP 400 (Bad Request)
        if (result.equals("Email đã tồn tại!")) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        // Nếu tạo tài khoản thành công, trả về mã HTTP 201 (Created)
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
