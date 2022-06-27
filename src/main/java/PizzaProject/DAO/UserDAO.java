package PizzaProject.DAO;

import PizzaProject.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<UserModel, Integer> {
    @Query("From UserModel")
    List<UserModel> findAllUsers();
}
