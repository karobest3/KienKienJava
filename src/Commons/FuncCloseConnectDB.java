package Commons;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

public class FuncCloseConnectDB {
    public static void closeConnectDB(Connection connect, Statement stmt, ResultSet rs) {
        try {
            connect.close();
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void closeConnectDBNoResult(Connection connect, Statement stmt) {
        try {
            connect.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
