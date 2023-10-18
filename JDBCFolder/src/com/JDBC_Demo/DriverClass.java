package com.JDBC_Demo;

import java.util.Scanner;

public class DriverClass {

    static Scanner x =new Scanner(System.in);
    public static void main(String[] Ak) {
        do {
            System.out.print("Choose what operation you want to perform: \n" +
                    "1. Create a Employee_db Database...\n" +
                    "2. Create a Employee Table...\n" +
                    "3. Insert Records in Employee Table...\n" +
                    "4. Delete Employee Table...\n" +
                    "5. Delete Employee_db Database...");

            int choice = x.nextInt();

            switch (choice){
                case 1:
                    CreatingDB.main(Ak);
                    break;
                case 2:
                    CreatingTable.main(Ak);
                    break;
                case 3:
                    InsertingRecords.main(Ak);
                    break;
                case 4:
                    DeletingTable.main(Ak);
                    break;
                case 5:
                    DeletingDB.main(Ak);
                    break;
                default:
                    System.out.println("Invalid Choice...");
                    break;
            }
        }while (true);
    }
}
