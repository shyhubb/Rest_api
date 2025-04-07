package Res.Restapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Res.Restapi.model.User;
import Res.Restapi.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/admin")
public class AdminCotroller {

    @Autowired
    private AdminService adminService;

    @GetMapping("/findAllUser")
    public List<User> findAllUser() {
        return adminService.findAllUser();
    }

}
