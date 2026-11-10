package repository;

import entities.User;

/**
 * Handles user registration, login and password management.
 * @author Collins
 */
public interface UserRepository {

    /**
     * Registers a new user.
     * @param user the user details
     * @param password the plain-text password to hash
     * @return true if registration succeeds
     */
    boolean registerUser(User user, String password);

    /**
     * Logs in a user.
     * @param username the user's username
     * @param password the user's password
     * @return the user if login succeeds, otherwise null
     */
    User login(String username, String password);

    /**
     * Changes a user's password.
     * @param userId the user's ID
     * @param oldPassword the current password
     * @param newPassword the new password
     * @return true if the password is changed successfully
     */
    boolean changePassword(int userId, String oldPassword, String newPassword);
}