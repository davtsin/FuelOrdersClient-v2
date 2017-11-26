package com.fuelordersclient.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author denis
 */
public class PetrolDBConnection {

    private Connection conn;

    private final String dbms = "mysql";
    private final String dbName = "petrol";
    private final String userName = "root";
    private final String password = "nbuser";
    private final String serverName = "localhost";
    private final String portNumber = "3306";

    public PetrolDBConnection() {
    }

    public Connection getPetrolConnection() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);
        connectionProps.put("useUnicode", "true");
        connectionProps.put("characterEncoding", "UTF-8");

        String currentUrlString = null;

        try {

            currentUrlString = "jdbc:" + this.dbms + "://" + this.serverName
                + ":" + this.portNumber + "/";
            conn = DriverManager.getConnection(currentUrlString,
                connectionProps);
            conn.setCatalog(this.dbName);

        } catch (SQLException e) {
            System.out.println("Failed to get connection");
        }
        return conn;
    }
}
