package persistence;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connector {
    Connection getConnection();
    void freeConnection();
}
