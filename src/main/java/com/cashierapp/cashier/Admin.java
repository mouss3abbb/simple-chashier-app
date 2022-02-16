package com.cashierapp.cashier;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;

import static com.cashierapp.cashier.Main.inventory;
import static com.cashierapp.cashier.Main.transactions;

public class Admin {
    private String name,password = new String("1234");
    public void viewDashboard(){
        System.out.printf("\n%s\t%s\n",name,password);
    }

    public void editDashboard(String name,String oldPassword,String newPassword) throws Exception {
        this.name = ((name.equals(""))?this.name:name);
        if(!this.password.equals(oldPassword)){
            throw new Exception("Wrong password");
        }
        if(!newPassword.equals(""))this.password = newPassword;

    }
    public Admin(String name, @NotNull String password) throws Exception {
        this.name = name;
        if(!this.password.equals(password))
            throw new Exception("Wrong password");

    }
    public void addProduct(Product newProduct){
        boolean found = false;
        for(Product e : inventory){
            if(e.getName().equals(newProduct.getName())){
                e.setAmount(e.getAmount()+ newProduct.getAmount());
                found = true;
                break;
            }
        }
        if(!found)inventory.add(newProduct);
    }
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
        int index = inventory.indexOf(transaction.getProduct());
        inventory.get(index).setAmount(inventory.get(index).getAmount() - transaction.getProduct().getAmount());
    }
    public void showInventory(){
        System.out.println("Name\tType\tPurchase Price\t Selling Price\n");
        for(Product p : inventory){
            p.show();
        }
    }
    public void showTransactions(){
        for(Transaction t : transactions){
            t.show();
        }
    }
}
