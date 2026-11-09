package persistence;

import entities.User;


public interface UserDao {

    User findUserByUsername(String username);



    boolean updatePassword(int userId, String passwordHash);
}