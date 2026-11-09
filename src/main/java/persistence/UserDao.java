package persistence;

import entities.User;


public interface UserDao {

    /**
     * * Search for a user using their username
     * * @param username name of user to be added
    * @return matching username, or null if match not found
     * @author Beni
    */
    User findUserByUsername(String username);


    /// @param user
    /// @return true if user added successfully, else false
    /// @author Beni
    boolean addUser(User user);

    /** This method updates a stored password hash
    * @param userId ID number assigned to a user
    * @param passwordHash a user's hased password value
    * @return true if password update sucessful, false otherwise
     */
    boolean updatePassword(int userId, String passwordHash);
}