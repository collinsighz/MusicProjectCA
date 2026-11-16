package services;

import entities.User;

public interface UserService {

    User registerUser(User user, String password);

    User login(String username, String password);

    boolean changePassword(int userId, String oldPassword, String newPassword);
}