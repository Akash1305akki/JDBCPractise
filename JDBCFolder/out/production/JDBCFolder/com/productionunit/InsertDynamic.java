package com.productionunit;
import java.sql.*;
import java.util.Scanner;

public class InsertDynamic {

    static Scanner x = new Scanner(System.in);

    public static void main(String[] Ak) {

        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Akash1305";
        String dbName = "production_db";

        try {
            // Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Use the specified database
            statement.execute("USE " + dbName);

            //Insert the records
            String insertSql = "INSERT INTO product_table (pid, productName, brandName, price, quantity, rating, color) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);

            System.out.print("How many records you want to insert in product table: ");
            int n = x.nextInt();

            for (int i=1;i<=n;i++){
                System.out.print("Enter productID of product_"+i+": ");
                int p_id = x.nextInt();
                System.out.print("Enter productName of product_"+i+": ");
                String product_name = x.next();
                System.out.print("Enter brandName of product_"+i+": ");
                String brand_name = x.next();
                System.out.print("Enter price of product_"+i+": ");
                double price = x.nextDouble();
                System.out.print("Enter available quantity of product_"+i+": ");
                int quantity = x.nextInt();
                System.out.print("Enter customer rating of product_"+i+": ");
                int rating = x.nextInt();
                System.out.print("Enter available color of product_"+i+": ");
                String color = x.next();

                insertRecord(preparedStatement, p_id, product_name, brand_name, price, quantity, rating, color);
            }

            //Close the resources
            preparedStatement.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully Inserted Product Records...");
    }

    private static void insertRecord(PreparedStatement preparedStatement, int p_id, String product_name, String brand_name, double price, int quantity, int rating, String color) throws SQLException {

        preparedStatement.setInt(1, p_id);
        preparedStatement.setString(2, product_name);
        preparedStatement.setString(3, brand_name);
        preparedStatement.setDouble(4, price);
        preparedStatement.setInt(5, quantity);
        preparedStatement.setInt(6, rating);
        preparedStatement.setString(7, color);

        preparedStatement.executeUpdate();
    }


}