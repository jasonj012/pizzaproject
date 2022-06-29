package PizzaProject.Controller;

import PizzaProject.Model.UserModel;
import PizzaProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public List<UserModel> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("add")
    public void createUser(@RequestBody UserModel user){userService.createUser(user);}

    @GetMapping("{username}")
    public UserModel getUserByUserName(@PathVariable String username){
        return userService.getUserByUsername(username);
    }
    @PostMapping("login")
    public UserModel loginUser(@RequestBody Map<String, Object> dto){
        return userService.login(dto.get("username").toString(),dto.get("password").toString());
    }

    @GetMapping("user/{id}")
    public UserModel getUserInformation(@PathVariable("id") int id){
        return userService.getUserInformation(id);
    }

    @GetMapping("username/{name}")
    public UserModel getUserByName(@PathVariable("name") String name){
        return userService.getByUsername(name);
    }

}
