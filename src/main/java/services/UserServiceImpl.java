package services;

import entities.User;
import repository.UserRepository;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user, String password) {

        if (user == null || password == null) {
            return null;
        }

        boolean registered = userRepository.registerUser(user, password);

        if (registered) {
            return user;
        }

        return null;
    }

    @Override
    public User login(String username, String password) {

        if (username == null || password == null) {
            return null;
        }

        return userRepository.login(username, password);
    }

    @Override
    public boolean changePassword(int userId, String oldPassword, String newPassword) {

        if (userId <= 0 || oldPassword == null || newPassword == null) {
            return false;
        }

        return userRepository.changePassword(userId, oldPassword, newPassword);
    }
}