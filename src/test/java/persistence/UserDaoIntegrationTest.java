package persistence;

import entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoIntegrationTest {

    private final Connector connector =
            new MySqlConnector("db_properties/database.properties");

    private final UserDao userDao = new UserDaoImpl(connector);

    @Test
    void findUserByUsernameReturnsNullWhenUserDoesNotExist() {

        User user = userDao.findUserByUsername(
                "nonexistent67"
        );

        assertNull(user);
    }
}