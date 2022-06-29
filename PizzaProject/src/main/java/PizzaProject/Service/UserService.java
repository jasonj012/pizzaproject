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

    public List<UserModel> getAllUser(){
        return userDAO.findAll();
    }
    public void registerUser(UserModel u) {
        userDAO.save(u);
    }
    public void createUser(UserModel user){
        String username=user.getUsername();
        UserModel temp=userDAO.getUserByUsername(username);
        UserModel temp2=userDAO.getUserByEmail(user.getEmail());
        user.setRole(UserModel.Role.User);
        if (temp==null&&temp2==null) {
            userDAO.save(user);
        }
    }
    public UserModel login(String username, String password){
        UserModel user = userDAO.login(username, password);

        if (user!=null) {
            return user;
        }else {
            return new UserModel();
        }
    }
    public UserModel getUserByUsername(String username){
        return userDAO.findUserByUsername(username);
    }

    public UserModel getUserInformation(int id) {
        UserDAO user= (UserDAO) userDAO.getUserByID(id);
        if (user!=null){
            return (UserModel) user;
        }else{
            return null;
        }
    }

    public String changePassword(int id, String s) {
        UserModel user=userDAO.getUserByID(id);
        if (user!=null&&!user.getPassword().equals(s)){
            user.setPassword(s);
            userDAO.save(user);
            return "Password changed successfully";
        }else {
            return "could not change password";
        }
    }

    public String changeUserInfo(UserModel user) {
        UserModel temp=userDAO.getUserByID(user.getUserID());
        UserModel emailCheck=userDAO.getUserByEmail(user.getEmail());
        UserModel usernameCheck=userDAO.getUserByUsername(user.getUsername());
        if (temp!=null){
            System.out.println("step1");
            if (usernameCheck!=null&&usernameCheck.getUserID()!=temp.getUserID()) {
                return "User info cannot be updated because username already exists!";
            }else if(emailCheck!=null&&emailCheck.getUserID()!=temp.getUserID()){
                return "User info cannot be updated because the Email already exists for an account. If you own this email, try changing the password.";
            }else if (temp.getUserID()==user.getUserID()){
                userDAO.save(user);
                return "User info successfully updated!";
            }
        }else{
            return "Could not update the user. Please fill out the form correctly";
        }
        return "unknown error";
    }
    public UserModel getByUsername(String name) {
        return userDAO.findByUsername(name);
    }

}
