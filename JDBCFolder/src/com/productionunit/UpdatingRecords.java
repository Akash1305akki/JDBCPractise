package com.productionunit;

import java.sql.*;
import java.util.Scanner;

public class UpdatingRecords {

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

            // Use the specified database
            statement.execute("USE " + dbName);

            System.out.print("Which Product you want to update: ");
            int pid = x.nextInt();
            System.out.print("Which Column you want to update: ");
            String col = x.next();

            //update query...
            String updateSql = "";

            if (col.equals("productName")){
                System.out.print("Enter new productName: ");
                String val = x.next();
                updateSql = "UPDATE "+ tableName +
                        " SET "+ col + " = "+ val +
                        " WHERE pid = "+ pid;
            } else if (col.equals("brandName")) {
                System.out.print("Enter new brandName: ");
                String val = x.next();
                updateSql = "UPDATE "+ tableName +
                        " SET "+ col + " = "+ val +
                        " WHERE pid = "+ pid;
            } else if (col.equals("price")) {
                System.out.print("Enter new price: ");
                double val = x.nextDouble();
                updateSql = "UPDATE "+ tableName +
                        " SET "+ col + " = "+ val +
                        " WHERE pid = "+ pid;
            } else if (col.equals("quantity")) {
                System.out.print("Enter new available quantity: ");
                int val = x.nextInt();
                updateSql = "UPDATE "+ tableName +
                        " SET "+ col + " = "+ val +
                        " WHERE pid = "+ pid;
            } else if (col.equals("rating")) {
                System.out.print("Enter new rating: ");
                int val = x.nextInt();
                updateSql = "UPDATE "+ tableName +
                        " SET "+ col + " = "+ val +
                        " WHERE pid = "+ pid;
            } else if (col.equals("color")) {
                System.out.print("Enter new available color: ");
                String val = x.next();
                updateSql = "UPDATE "+ tableName +
                        " SET "+ col + " = "+ val +
                        " WHERE pid = "+ pid;
            }

            statement.execute(updateSql);

            //Close the resources
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully Updated Product Records...");

    }
}