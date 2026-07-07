package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    


    private String accountNumber;
    private double balance;
    private int pin;
    private Customer customer;
    private ArrayList<Transaction> transactions;

    public Account(String accountNumber, double balance, int pin, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
        this.customer = customer;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit Successful");
    }

    public abstract void withdraw(double amount);

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}