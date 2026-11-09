package entities;

/// @param userId
/// @param firstName
/// @param lastName
/// @param username
/// @param email
/// @param passwordHash
public record User(
    int userId,
    String firstName,
    String lastName,
    String username,
    String email,
    String passwordHash){
}
