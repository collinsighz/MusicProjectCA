package entities;

/**
 * Represents a User in the database
 *
 * @param userId
 * @param firstName
 * @param lastName
 * @param username
 * @param email
 * @param passwordHash
 * @Author Collins
 */

public record User(
        int userId,
        String firstName,
        String lastName,
        String username,
        String email,
        String passwordHash) {
}
