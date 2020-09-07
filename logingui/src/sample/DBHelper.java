package sample;
import java.sql.*;
public class DBHelper {
    private Connection conn;
    private Statement statement;
    public DBHelper(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/javadb","root","");

            statement = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean login(String email, String password){
        try {
            ResultSet set=this.statement.executeQuery("SELECT * FROM users WHERE email LIKE" + "'" + email + "'" + "AND password LIKE" + "'" + password + "'");

            if(!set.next()){
                return false;
            }else{
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public String search(String email){
        try {
            ResultSet rs=this.statement.executeQuery("SELECT * FROM users WHERE email LIKE '"+ email +"'");
            return rs.getString("name");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "some error";
        }

    }
    public boolean register(String name, String email, String password)
    {
        try {
            this.statement.executeUpdate("INSERT INTO users (user_id,name,email,password) VALUES (null," + "'" +name + "'" +"," + "'" + email + "'" + "," + "'" + password + "'" +")");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }
}
