package com.productionunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletingTable {

    public static void main(String[] Ak) {
        // Define Connection Parameters
        String url = "jdbc:mysql://localhost:3306/production_db";
        String username = "root";
        String password = "Akash1305";
        String tableName = "product_table";

        try {
            // Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Use the specified database
            statement.execute("USE production_db");

            // Delete the database if it doesn't exist
            String createDbSQL = "DROP TABLE " + tableName;
            statement.execute(createDbSQL);

            // Close the resources
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully Deleted Table...");
    }
}