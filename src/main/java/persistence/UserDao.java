package persistence;

import entities.User;

/**
 * Defines database operations for user accounts.
 *
 * @author Collins
 */
public interface UserDao {

    /**
     * Adds a new user to the database.
     * @param user the user to add
     * @return true if the user was successfully added, otherwise false
     * @author collins
     */
    boolean addUser(User user);

    /**
     * Finds a user using their username.
     * @param username the username to search for
     * @return the matching user, or null if no user is found
     * @author collins
     */
    User findUserByUsername(String username);

    /**
     * Updates the stored password hash for a user.
     * @param userId t
     * @param passwordHash
     * @return true if the password was successfully updated, otherwise false
     * @author collins
     */
    boolean updatePassword(int userId, String passwordHash);
}