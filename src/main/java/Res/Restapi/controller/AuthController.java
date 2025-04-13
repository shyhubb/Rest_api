package Res.Restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Res.Restapi.dto.*;
import Res.Restapi.model.User;
import Res.Restapi.service.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    // Endpoint đăng ký người dùng
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody User user) {
        String mess = userService.createAccount(user);
        if (mess.equals("Tạo tài khoản thành công!")) {
            return new ResponseEntity<>(new RegisterResponse(mess), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new RegisterResponse(mess), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginSystem(@RequestBody User user) {
        String mess = userService.login(user.getEmail(), user.getPassword());
        if (mess.equals("Đăng nhập thành công!")) {
            String token = authService.generateToken(user.getEmail(), user.getRole());
            return new ResponseEntity<>(new LoginResponse(user.getEmail(), mess, token), HttpStatus.OK);
        }
        return new ResponseEntity<>(new LoginResponse(user.getEmail(), mess, null), HttpStatus.BAD_REQUEST);
    }

}