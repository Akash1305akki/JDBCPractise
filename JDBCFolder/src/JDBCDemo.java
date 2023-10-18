//import java.sql.*;
//
//public class JDBCDemo {
//
//    public static void main(String[] args) {
//        // Define Connection Parameters
//        String url = "jdbc:mysql://localhost:3306/employee_db";
//        String username = "root";
//        String password = "Akash1305";
//        String dbName = "employee_db";
//
//        try {
//            // Establish Connection
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
//
//
//            String createDbSQL = "DROP DATABASE IF EXISTS " + dbName;
//            statement.execute(createDbSQL);
//
//            statement.execute("USE " + dbName);
//
//
//            // Create the database if it doesn't exist
//            String createDbSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
//            statement.execute(createDbSQL);
//
//            // Use the specified database
//            statement.execute("USE " + dbName);
////
//            // Create the table
//            String tableName = "EmployeeDemo";
//            String createTableSQL = "CREATE TABLE IF NOT EXISTS employee (" + tableName +
//                    "id INT AUTO_INCREMENT PRIMARY KEY," +
//                    "first_name VARCHAR(50)," +
//                    "last_name VARCHAR(50)," +
//                    "salary DECIMAL(10, 2)" +
//                    ")";
//            statement.execute(createTableSQL);
//
//            // Close the resources
//            statement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Successful...");
//    }
//}

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) {
        // Define Connection Parameters
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Akash1305";
        String dbName = "Employee_db";

        try {
            // Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Create the database if it doesn't exist
            String createDbSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
            statement.execute(createDbSQL);

            // Use the specified database
            statement.execute("USE " + dbName);

            // Create the table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employee (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(50)," +
                    "last_name VARCHAR(50)," +
                    "salary DECIMAL(10, 2)" +
                    ")";
            statement.execute(createTableSQL);

            // Close the resources
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Succesfful...");
    }
}

