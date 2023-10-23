package com.productionunit;

import java.sql.*;
import java.util.Scanner;

public class UpdateDynamic {

    static Scanner x = new Scanner(System.in);

    public static void main(String[] Ak) {

        // Define Connection Parameters
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Akash1305";
        String dbName = "production_db";
        String tableName = "product_table";

        try {
            // Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ?"+
                            " SET ? = ?" +
                            " WHERE pid = ?");

            // Use the specified database
            statement.execute("USE " + dbName);

            System.out.print("Which Product you want to update: ");
            int pid = x.nextInt();
            System.out.print("Which Column you want to update: ");
            String col = x.next();

            if (col.equals("productName")){
                System.out.print("Enter new productName: ");
                String val = x.next();
                preparedStatement.setString(1,tableName);
                preparedStatement.setString(2,col);
                preparedStatement.setString(3,val);
                preparedStatement.setInt(4,pid);
            } else if (col.equals("brandName")) {
                System.out.print("Enter new brandName: ");
                String val = x.next();
                preparedStatement.setString(1,tableName);
                preparedStatement.setString(2,col);
                preparedStatement.setString(3,val);
                preparedStatement.setInt(4,pid);
            } else if (col.equals("price")) {
                System.out.print("Enter new price: ");
                double val = x.nextDouble();
                preparedStatement.setString(1,tableName);
                preparedStatement.setString(2,col);
                preparedStatement.setDouble(3,val);
                preparedStatement.setInt(4,pid);
            } else if (col.equals("quantity")) {
                System.out.print("Enter new available quantity: ");
                int val = x.nextInt();
                preparedStatement.setString(1,tableName);
                preparedStatement.setString(2,col);
                preparedStatement.setInt(3,val);
                preparedStatement.setInt(4,pid);
            } else if (col.equals("rating")) {
                System.out.print("Enter new rating: ");
                int val = x.nextInt();
                preparedStatement.setString(1,tableName);
                preparedStatement.setString(2,col);
                preparedStatement.setInt(3,val);
                preparedStatement.setInt(4,pid);
            } else if (col.equals("color")) {
                System.out.print("Enter new available color: ");
                String val = x.next();
                preparedStatement.setString(1,tableName);
                preparedStatement.setString(2,col);
                preparedStatement.setString(3,val);
                preparedStatement.setInt(4,pid);
            }

            preparedStatement.executeUpdate();

            //Close the resources
            preparedStatement.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully Updated Product Records...");

    }
}