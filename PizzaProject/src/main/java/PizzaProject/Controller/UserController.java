package PizzaProject.Controller;

import PizzaProject.Model.UserModel;
import PizzaProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("users")
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping
    public void registerUser(@RequestBody UserModel u) {
    userService.registerUser(u);
    }
}
