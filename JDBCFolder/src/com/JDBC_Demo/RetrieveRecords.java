package com.JDBC_Demo;
import java.sql.*;
import java.util.Scanner;

public class RetrieveRecords {
    static Scanner x = new Scanner(System.in);

    public static void main(String[] Ak) {
        String jdbcURL = "jdbc:mysql://localhost:3306/Employee_db";
        String username = "root";
        String password = "Akash1305";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {

            StringBuilder sqlQuery = new StringBuilder();

            System.out.println("Enter your SQL query (terminate with ';' on a new line):");
            String line;
            while (x.hasNextLine()) {
                line = x.nextLine();
                if (line.endsWith(";")) {
                    sqlQuery.append(line);
                    break;
                } else {
                    sqlQuery.append(line).append(" ");
                }
            }

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery.toString())) {

                ResultSetMetaData rsmd = resultSet.getMetaData();
                int columnCount = rsmd.getColumnCount();

                boolean found = false;

                while (resultSet.next()) {
                    found = true;
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(resultSet.getString(i) + "\t");
                    }
                    System.out.println();
                }

                if (!found) {
                    System.out.println("No rows selected");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}