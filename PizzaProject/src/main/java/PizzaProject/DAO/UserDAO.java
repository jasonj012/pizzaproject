package PizzaProject.DAO;

import PizzaProject.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDAO extends JpaRepository<UserModel, Integer> {
    @Query("From UserModel where username = :username")
    UserModel findUserByUsername(@Param("username") String username);

    @Query("from UserModel where username= :username and password= :password")
    UserModel login(@Param("username")String username, @Param("password")String password);
    @Query("from UserModel where username=:username")
    UserModel getUserByUsername(@Param("username") String username);
    @Query("from UserModel where email=:email")
    UserModel getUserByEmail(@Param("email")String email);
    @Query("from UserModel where id= :id")
    UserModel getUserByID(@Param("id") int id);

    UserModel findByUsername(String name);

}
