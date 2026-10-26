package persistence;

import entities.User;

public interface UserDao {
    boolean addUser(User user);
    User findUserByUsername(String username);
    boolean updatePassword(int userId, String passwordHash);

}
