    import java.io.IOException;
    import java.sql.*;

/**
 * Created by accbc_000 on 20.02.2017.
 */
public class Main {

    private static Connection con;
    private static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static String LOGIN = "root";
    private static String PASSWORD = "root";
    public static void main(String[] args) throws SQLException, IOException {
        con = DriverManager.getConnection(URL , LOGIN , PASSWORD);
        new Run_prog(con);

    }
}