package com.JDBC_Demo;
import java.sql.*;

public class EstablishConnection {

    public static void main(String[] Ak) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
