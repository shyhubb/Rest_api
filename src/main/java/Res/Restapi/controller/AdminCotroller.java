package Res.Restapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Res.Restapi.model.User;
import Res.Restapi.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/admin")
public class AdminCotroller {

    @Autowired
    private AdminService adminService;

    @GetMapping("/findAllUser")
    public List<User> findAllUser() {
        return adminService.getAllUsers();
    }

    @PostMapping("/setrole/{email}")
    public ResponseEntity<String> setRole(@PathVariable String email) {
        // Gọi phương thức service để thay đổi vai trò
        String message = adminService.changeRole(email);

        // Kiểm tra kết quả trả về từ service để quyết định mã HTTP
        if (message.equals("Không tìm thấy người dùng có email: " + email)) {
            // Trả về BAD_REQUEST nếu không tìm thấy người dùng
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        // Trả về OK nếu thay đổi thành công
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/deleteuser/{email}")
    public ResponseEntity<String> deleteUSer(@PathVariable String email) {
        String mess = adminService.deleteUser(email);
        if (mess.equals("Xoa user: " + email + " Thanh cong !"))
            return new ResponseEntity<>(mess, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(mess, HttpStatus.OK);
    }

}
