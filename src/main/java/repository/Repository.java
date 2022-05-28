package repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public  abstract class Repository {
    private String JdbURL = "jdbc:mysql://localhost:3306/online_school_db";
    private String username = "root";
    private String password = "root";
    private Connection connection = null;
    protected Statement statement = null;


    public Repository() {
        try {
            connection = DriverManager.getConnection(JdbURL, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("eroare conectare baza de date");
        }

    }

    public void executeStatement(String execute) {
        try {
            statement.execute(execute);
        } catch (SQLException exec) {
            System.out.println("Nu am reusit" + execute);
        }
    }


}


