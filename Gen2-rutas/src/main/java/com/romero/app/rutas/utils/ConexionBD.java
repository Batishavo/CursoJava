package com.romero.app.rutas.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static String url ="jdbc:oracle:thin:@localhost:1521:xe";
    private static String username = "SYSTEM";
    private static String password = "root";

    public static Connection getInstance(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url,username,password);
            return conn;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
