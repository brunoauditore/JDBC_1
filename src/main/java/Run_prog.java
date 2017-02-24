
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/**
 * Created by accbc_000 on 23.02.2017.
 */
public class Run_prog {

    private Scanner scn;
    private User user;
    private String name;
    private String departament;
    private int age;
    private int id;
    private ResultSet resultSet;



    public Run_prog(Connection con) throws SQLException {
        scn = new Scanner(System.in);
        user = new User(con);
        Start();
    }

    public void Start() throws SQLException {

        System.out.println("Виберіть дію");
        System.out.println("1.Додати працівника");
        System.out.println("2.Взяти інфу по name");
        System.out.println("3.зяти інфу по id");
        System.out.println("4.Взяти id по name");
        System.out.println("5.Взяти name по id");
        System.out.println("6.Взяти departament по name");
        System.out.println("7.Взяти departament по id");
        System.out.println("8.Взяти age по name");
        System.out.println("9.Взяти age по id");

        switch (scn.nextInt()) {
            case 1:
                System.out.println("Введіть ім*я , департамент , вік");
                scn.next();
                name = scn.nextLine();
                System.out.println("-_-");
                departament = scn.nextLine();
                id = scn.nextInt();
                    user.create_User(name,departament,age);
                break;
            case 2:
                System.out.println("ведіть ім*я");
                scn.next();
                name = scn.nextLine();
               resultSet =  user.get_user(name);
               while (resultSet.next()) {
                   System.out.println("id: " + resultSet.getInt(1) + " name: " + resultSet.getString(2)
                   + " departament: " + resultSet.getString(3) + " age: " + resultSet.getInt(4));
               }
                break;
            case 3:
                System.out.println("Введіть id");
                id = scn.nextInt();
                resultSet = user.get_user(id);
                do  {
                    System.out.println("id: " + resultSet.getInt(1) + " name: " + resultSet.getString(2)
                            + " departament: " + resultSet.getString(3) + " age: " + resultSet.getInt(4));
                } while (resultSet.next());
                break;
            case 4:
                System.out.println("Введіть ім*я");
                name = scn.nextLine();
                System.out.println(user.get_id(name));
                break;
            case 5:
                System.out.println("Введіть id");
                id = scn.nextInt();
                System.out.println(user.get_Name(id));
                break;
            case 6:
                System.out.println("Введіть ім*я");
                name = scn.nextLine();
                System.out.println(user.get_departament(name));
                break;
            case 7:
                System.out.println("Введіть id");
                id = scn.nextInt();
                System.out.println(user.get_departament(id));
                break;
            case 8:
                System.out.println("Введіть ім*я");
                name = scn.nextLine();
               System.out.println(user.get_age(name));
                break;
            case 9:
                System.out.println("Введіть id");
                id = scn.nextInt();
                System.out.println(user.get_age(id));
                break;
        }
    }
}
