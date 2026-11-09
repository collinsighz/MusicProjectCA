package entities;

/**
 * this records represents a sample User in the database
 *
 * @param userId
 * @param firstName
 * @param lastName
 * @param username
 * @param email
 * @param passwordHash
 * @author Beni
 */

public record User(
        int userId,
        String firstName,
        String lastName,
        String username,
        String email,
        String passwordHash) {
}
