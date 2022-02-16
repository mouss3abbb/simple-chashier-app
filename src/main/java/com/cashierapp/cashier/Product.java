package com.cashierapp.cashier;

public class Product {
    private String name,type,description;
    private double purchasePrice,sellingPrice;
    private int amount;
    public void show(){
        System.out.printf("%s\t%s\t%s\t%f\t%f\t%d\n",name,type,description,purchasePrice,sellingPrice,amount);
    }
    public Product() {
    }
    public Product(Product p){
        this(p.name,p.type,p.description,p.purchasePrice,p.sellingPrice,p.amount);
    }
    public Product(String name, String type, double purchasePrice, double sellingPrice, int amount) {
        this.name = name;
        this.type = type;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.amount = amount;
    }

    public Product(String name, String type, String description, double purchasePrice, double sellingPrice, int amount) {
        this(name,type,purchasePrice,sellingPrice,amount);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
