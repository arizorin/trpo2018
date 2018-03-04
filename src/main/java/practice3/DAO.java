package practice3;

import java.sql.*;
import java.util.ResourceBundle;

public class DAO {
    private static Connection connection;
    private static Statement statement;
    private String response = "";
    private String drivers;
    private String connectionURL;
    private String username;
    private String password;
    User user = new User();

    public DAO() {
        ResourceBundle bundle = ResourceBundle.getBundle("practice3.dbconnection");
        this.drivers = bundle.getString("jdbc.drivers");
        this.connectionURL = bundle.getString("jdbc.url");
        this.username = bundle.getString("jdbc.username");
        this.password = bundle.getString("jdbc.password");
        try {
            Class.forName(drivers);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void show(){
        try {
            Connection connection = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Connection Successful");
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users;");
            while (rs.next()) {
                response = response + "<TR><TD>";
                String login = rs.getString("login");
                String Password = rs.getString("password");
                response = response + Password + "</TD><TD>";
                response = response + login + "</TD>";
                System.out.println(login + " " + Password);
                response = response + "</TR>";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user){
        try {
            Connection connection = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Connection Successful");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (login, password, role)  VALUES ( ?, ?, ?)");
            System.out.println(user.toString());
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user){
        try {
            Connection connection = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Connection Successful");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users where login = ( ?)");
            System.out.println(user.toString());
            statement.setString(1, user.getLogin());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public String getResponse() {
        return response;
    }
}

