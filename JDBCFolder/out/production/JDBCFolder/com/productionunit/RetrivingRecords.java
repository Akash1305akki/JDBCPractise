package com.productionunit;
import java.sql.*;
import java.util.Scanner;

public class RetrivingRecords {
    static Scanner x = new Scanner(System.in);

    public static void main(String[] Ak) {

        String jdbcURL = "jdbc:mysql://localhost:3306/production_db";
        String username = "root";
        String password = "Akash1305";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            String line="select * from product_table;";

            Statement statement = connection.createStatement();

//            statement.execute("use production_db;");

            ResultSet resultSet = statement.executeQuery(line);

            // Iterate through the ResultSet and retrieve data
            System.out.println(" Product_ID - Product_Name - Brand_Name - Price - Quantity - Rating - Color ");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String product = resultSet.getString(2);
                String brand = resultSet.getString(3);
                float price = resultSet.getFloat(4);
                int quantity = resultSet.getInt(5);
                int rating = resultSet.getInt(6);
                String color = resultSet.getString(7);
                System.out.println(id+" - "+product+" - "+brand+" - "+price+" - "+quantity+" - "+rating+" - "+color);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}