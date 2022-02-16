package com.cashierapp.cashier;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Product> inventory = new ArrayList<>();
    public static ArrayList<Transaction> transactions = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        String name,password;
        System.out.println("Please enter your username and password separated by a new line: ");
        name = input.nextLine();
        password = input.nextLine();
        try {
            Admin admin = new Admin(name, password);
            System.out.printf("Welcome, %s\nHere are some options for you to do\n",name);
            boolean launch = true;
            while(launch) {
                System.out.println("""
                        1.Show Dashboard
                        2.Edit Dashboard
                        3.Show Inventory
                        4.Show Transactions
                        5.Add Product
                        6.Add Transaction
                        """);
                String choice = input.nextLine();
                if (choice.toLowerCase().startsWith("show dash") || choice.equals("1")) {
                    admin.viewDashboard();
                } else if (choice.toLowerCase().startsWith("edit dash") || choice.equals("2")) {
                    System.out.println("Enter new name, old password and new password and leave empty for any entry not changing: ");
                    String newName = input.nextLine();
                    String oldPassword = input.nextLine();
                    String newPassword = input.nextLine();
                    admin.editDashboard(newName, oldPassword, newPassword);
                } else if (choice.toLowerCase().startsWith("show inven") || choice.equals("3")) {
                    admin.showInventory();
                } else if (choice.toLowerCase().startsWith("show trans") || choice.equals("4")) {
                    admin.showTransactions();
                } else if (choice.toLowerCase().startsWith("add prod") || choice.equals("5")) {
                    System.out.println("Please enter these details about the product\n" +
                            "Name (in whole line), Type (in whole line), Purchase Price, Selling Price, Amount");
                    String prodName, prodType;
                    double purPrice, selPrice;
                    int amount;
                    prodName = input.nextLine();
                    prodType = input.nextLine();
                    purPrice = input.nextDouble();
                    selPrice = input.nextDouble();
                    amount = input.nextInt();
                    String desc;
                    System.out.println("Add a description or just type no: ");
                    desc = input.nextLine();
                    Product newProd;
                    if (desc.equals("no")) {
                        newProd = new Product(prodName, prodType, purPrice, selPrice, amount);
                    } else {
                        newProd = new Product(prodName, prodType, desc, purPrice, selPrice, amount);
                    }
                    admin.addProduct(newProd);
                } else if (choice.toLowerCase().startsWith("add trans") || choice.equals("6")) {
                    System.out.println("Enter customer details: ");
                    System.out.println("Name, Phone Number and Address each on new line");
                    Customer newCust;
                    String custName = input.nextLine(), phoneNum = input.nextLine(), custAdd = input.nextLine(), custNotes;
                    System.out.println("Add some notes about the customer or just type no: ");
                    custNotes = input.nextLine();
                    if (custNotes.equals("no")) {
                        newCust = new Customer(custName, phoneNum, custAdd);
                    } else {
                        newCust = new Customer(custName, phoneNum, custAdd, custNotes);
                    }
                    String prodName;
                    int amount;
                    System.out.println("Enter product name and amount sold");
                    Transaction transaction;
                    while(true) {
                        prodName = input.nextLine();
                        amount = input.nextInt();
                        Product product = new Product();
                        boolean found = false;
                        for (Product p : inventory) {
                            if (p.getName().toLowerCase().equals(prodName.toLowerCase())) {
                                product = new Product(p);
                                product.setAmount(amount);
                                found = true;
                                break;
                            }
                        }

                        if (found) {
                            transaction = new Transaction(newCust, product);
                            break;
                        }
                    }
                    admin.addTransaction(transaction);
                }else launch = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}