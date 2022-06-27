package PizzaProject.Service;

import PizzaProject.DAO.UserDAO;
import PizzaProject.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserService {
    UserDAO userDAO;
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public List<UserModel> getAllUsers() {
        return userDAO.findAllUsers();
    }

    public void registerUser(UserModel u) {
        userDAO.save(u);
    }
}
