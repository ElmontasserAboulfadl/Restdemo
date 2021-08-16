package com.example.Restdemo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {


    Properties props = new Properties();
    static Connection conn;

    public DatabaseConnection() {

    }

    public static Connection getConnection() throws SQLException {
        //String url = "jdbc:postgresql://localhost:5432/postgres";
        String url = "jdbc:postgresql://localhost:5432/HibernateTraining";
        Properties props = new Properties();
        //props.setProperty("user","hibernateTrainer");
        //props.setProperty("password","eseHibernateTrainer2020");


        props.setProperty("user","postgres");
        props.setProperty("password","esePOstgres2020");

        props.setProperty("ssl","require");
        conn = DriverManager.getConnection(url, props);
        return conn;
    }

    public void  finalize() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
