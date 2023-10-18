package com.productionunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatingTable {

    public static void main(String[] Ak) {
        // Define Connection Parameters
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Akash1305";
        String table_name = "production";

        try {
            // Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Create the database if it doesn't exist
            statement.execute("USE production_db");
            String createDbSQL = "CREATE TABLE IF NOT EXISTS product_table (\n" +
                    "    pid INT PRIMARY KEY,\n" +
                    "    productName VARCHAR(20) NOT NULL,\n" +
                    "    brandName VARCHAR(20) NOT NULL,\n" +
                    "    price FLOAT NOT NULL,\n" +
                    "    quantity INT NOT NULL,\n" +
                    "    rating INT NOT NULL,\n" +
                    "    color VARCHAR(20) NOT NULL\n" +
                    ")";
            statement.execute(createDbSQL);

            // Close the resources
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully Created Table...");
    }
}
