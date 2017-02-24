import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User implements UserI {

    private Connection con;
    private PreparedStatement preparedStatement;
    private final String S_create_User = "insert into working (name,departament,age) values(?,?,?)";
    private final String S_get_user_id = "select * from working where id = ?";
    private final String S_get_user_name = "select * from working where name = ?";
    private final String S_get_Name = "select name from working where id = ?";
    private final String S_get_id = "select  id from  working where name = ?";
    private final String S_get_departament = " select departament from working where ? = ?";
    private final String S_get_age = "select age from working where ? = ?";
    private ResultSet resultSet;


    public User(Connection connection) {
        con = connection;
    }

    public void create_User(String name, String departament, int age) throws SQLException {
        preparedStatement = con.prepareStatement(S_create_User);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,departament);
        preparedStatement.setInt(3,age);
    }

    public ResultSet get_user(String name) throws SQLException {
        preparedStatement = con.prepareStatement(S_get_user_name);
        preparedStatement.setString(1,name);
        resultSet =  preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet;
        } else
            return null;
    }

    public ResultSet get_user(int id) throws SQLException {

        preparedStatement = con.prepareStatement(S_get_user_id);
        preparedStatement.setInt(1,id);
        resultSet =  preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet;
        } else
            return null;
    }

    public String get_Name(int id) throws SQLException {
        preparedStatement = con.prepareStatement(S_get_Name);
        preparedStatement.setInt(1,id);
        resultSet =  preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString(1);
        } else
        return null;
    }

    public int get_id(String name) throws SQLException {
        preparedStatement = con.prepareStatement(S_get_id);
        preparedStatement.setString(1,name);
        resultSet =  preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getInt(1);
        } else
            return 0;
    }

    public String get_departament(String name) throws SQLException {
        preparedStatement = con.prepareStatement(S_get_departament);
        preparedStatement.setString(1,"departamnet");
        preparedStatement.setString(2,name);
        resultSet =  preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString(1);
        } else
            return null;
    }

    public String get_departament(int id) throws SQLException {
        preparedStatement = con.prepareStatement(S_get_departament);
        preparedStatement.setString(1, "departament");
        preparedStatement.setInt(2, id);
        resultSet =  preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getString(1);
        } else
            return null;
    }

    public int get_age(String name) throws SQLException {
        preparedStatement = con.prepareStatement(S_get_age);
        preparedStatement.setString(1,"age");
        preparedStatement.setString(2,name);
        resultSet =  preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getInt(1);
        } else
            return 0;
    }

    public int get_age(int id) throws SQLException {
        preparedStatement = con.prepareStatement(S_get_age);
        preparedStatement.setString(1,"age");
        preparedStatement.setInt(2,id);
        resultSet =  preparedStatement.executeQuery();
        if(resultSet.next()){
            return resultSet.getInt(1);
        } else
            return 0;
    }
}
