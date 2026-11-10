package repository;

import entities.User;
import persistence.UserDao;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UserRepository;

/**
 * Implements user registration, login and password management.
 * @author Collins
 */
public class UserRepositoryImpl implements UserRepository {

    private final UserDao userDao;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * Creates a UserRepositoryImpl.
     * @param userDao user DAO
     */
    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Registers a new user.
     * @param user user details
     * @param password plain-text password
     * @return true if registration succeeds
     */
    @Override
    public boolean registerUser(User user, String password) {

        if (user == null || password == null || !isValidPassword(password)) {
            return false;
        }

        if (userDao.findUserByUsername(user.username()) != null) {
            return false;
        }

        String hashedPassword = passwordEncoder.encode(password);

        User newUser = new User(
                user.userId(),
                user.firstName(),
                user.lastName(),
                user.username(),
                user.email(),
                hashedPassword
        );

        return userDao.addUser(newUser);
    }

    /**
     * Logs in a user.
     * @param username user's username
     * @param password user's password
     * @return user if login succeeds, otherwise null
     */
    @Override
    public User login(String username, String password) {

        if (username == null || password == null) {
            return null;
        }

        User user = userDao.findUserByUsername(username);

        if (user == null) {
            return null;
        }

        if (passwordEncoder.matches(password, user.passwordHash())) {
            return user;
        }

        return null;
    }

    /**
     * Changes a user's password.
     * @param userId user's ID
     * @param oldPassword current password
     * @param newPassword new password
     * @return true if password changes successfully
     */
    @Override
    public boolean changePassword(int userId, String oldPassword, String newPassword) {

        if (oldPassword == null || newPassword == null) {
            return false;
        }

        User user = userDao.findUserByUsername(userId);

        if (user == null) {
            return false;
        }

        if (!passwordEncoder.matches(oldPassword, user.passwordHash())) {
            return false;
        }

        if (!isValidPassword(newPassword)) {
            return false;
        }

        String newPasswordHash = passwordEncoder.encode(newPassword);

        return userDao.updatePassword(userId, newPasswordHash);
    }

    /**
     * Checks whether a password meets the password policy.
     * @param password password to validate
     * @return true if password is valid
     */
    private boolean isValidPassword(String password) {

        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*");
    }
}