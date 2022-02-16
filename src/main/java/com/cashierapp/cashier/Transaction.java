package com.cashierapp.cashier;

public class Transaction {
    private Customer customer;
    private Product product;

    public Transaction() {
    }

    public Transaction(Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
    }
    public void show(){
        System.out.print("-");
        this.customer.show();
        this.product.show();
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
