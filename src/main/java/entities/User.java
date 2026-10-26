package entities;

public record User(
        int userId,
        String firstName,
        String lastName,
        String username,
        String email,
        String passwordHash) {
}
