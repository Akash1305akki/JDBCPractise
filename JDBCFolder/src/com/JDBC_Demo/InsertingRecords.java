package com.JDBC_Demo;
import java.sql.*;
import java.util.Scanner;

public class InsertingRecords {

    static Scanner x = new Scanner(System.in);

    public static void main(String[] Ak) {
        // Define Connection Parameters
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Akash1305";
        String dbName = "Employee_db";

        try {
            // Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Use the specified database
            statement.execute("USE " + dbName);

            //Insert the records
            String insertSql = "INSERT INTO employee (first_name, last_name, salary) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);

            System.out.print("How many records you want to insert in employee table: ");
            int n = x.nextInt();

            for (int i=1;i<=n;i++){
                System.out.print("Enter f_name of employee_"+i+": ");
                String f_name = x.next();
                System.out.print("Enter l_name of employee_"+i+": ");
                String l_name = x.next();
                System.out.print("Enter salary of employee_"+i+": ");
                double sal = x.nextDouble();
                insertRecord(preparedStatement, f_name, l_name, sal);
            }

            //Close the resources
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully Inserted Employee Records...");
    }

    private static void insertRecord(PreparedStatement preparedStatement, String fname, String lname, double sal)
            throws SQLException {
        preparedStatement.setString(1, fname);
        preparedStatement.setString(2, lname);
        preparedStatement.setDouble(3, sal);
        preparedStatement.executeUpdate();
    }
}