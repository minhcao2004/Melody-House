/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=MelodyHouse;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "123";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, user, pass);
    }
}

