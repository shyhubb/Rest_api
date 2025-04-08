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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/admin")
public class AdminCotroller {

    @Autowired
    private AdminService adminService;

    @GetMapping("/findAllUser")
    public List<User> findAllUser() {
        return adminService.getAllUsers();
    }

    @PostMapping("/setrole")
    public ResponseEntity<String> setRole(@RequestBody User user) {
        String messgae = adminService.chageRole(user);
        if (messgae.equals("Không tìm tháy người đùng có email: " + user.getEmail())) {
            return new ResponseEntity<>(messgae, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(messgae, HttpStatus.OK);
    }

}
