import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by accbc_000 on 23.02.2017.
 */
public interface UserI {

    public void create_User(String name,String departament,int age) throws SQLException;

    public ResultSet get_user(String name) throws SQLException;

    public ResultSet get_user(int id) throws SQLException;

    public String get_Name(int id) throws SQLException;

    public int get_id(String name) throws SQLException;

    public String get_departament(String name) throws SQLException;

    public String get_departament(int id) throws SQLException;

    public int get_age(String name) throws SQLException;

    public int get_age(int id) throws SQLException;





}
