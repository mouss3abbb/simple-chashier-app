package com.cashierapp.cashier;

public class Customer extends User{
    public void show(){
        System.out.printf("%s\t%s\t%s\t%s\n",getName(),getPhoneNumber(),getAddress(),getNotes());
    }

    public Customer(String name, String phoneNum, String address) {
        this.setName(name);
        this.setPhoneNumber(phoneNum);
        this.setAddress(address);
    }
    public Customer(String name, String phoneNum, String address, String notes) {
        this(name,phoneNum,address);
        this.setNotes(notes);
    }
}
