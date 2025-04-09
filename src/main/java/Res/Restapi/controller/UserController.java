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

        switch (result) {
            case "Email đã tồn tại!":
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            case "Vui lòng nhập đúng định dạng email: example@gmail.com":
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            case "Email không được để trống!":
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            default:
                // Nếu kết quả trả về là thành công (tạo tài khoản thành công)
                return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
    }

}
