package service;

import java.time.LocalDateTime;
import java.util.HashMap;

import model.Account;
import model.Transaction;
import util.FileUtil;

public class BankService {

    private HashMap<String, Account> accounts;

    private int customerCounter = 101;
    private int accountCounter = 1001;
    private int transactionCounter = 1;

    public BankService() {

        accounts = FileUtil.loadAccounts();

        if (!accounts.isEmpty()) {

            customerCounter = accounts.size() + 101;
            accountCounter = accounts.size() + 1001;

            for (Account account : accounts.values()) {

                transactionCounter += account.getTransactions().size();

            }

        }

    }

    public int generateCustomerId() {

        return customerCounter++;

    }

    public String generateAccountNumber() {

        return "ACC" + accountCounter++;

    }

    public boolean verifyPin(String accountNumber, int pin) {

        Account account = accounts.get(accountNumber);

        if (account == null) {

            System.out.println("Account Not Found.");
            return false;

        }

        if (account.getPin() == pin) {

            return true;

        }

        System.out.println("Invalid PIN.");
        return false;

    }

    public void createAccount(Account account) {

        accounts.put(account.getAccountNumber(), account);

        FileUtil.saveAccounts(accounts);

        System.out.println("==================================");
        System.out.println("Account Created Successfully.");
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("==================================");

    }

    public void deposit(String accountNumber, double amount) {

        Account account = accounts.get(accountNumber);

        if (account != null) {

            account.deposit(amount);

            Transaction transaction = new Transaction(
                    transactionCounter++,
                    "Deposit",
                    amount,
                    LocalDateTime.now());

            account.addTransaction(transaction);

            FileUtil.saveAccounts(accounts);

        } else {

            System.out.println("Account Not Found.");

        }

    }

    public void withdraw(String accountNumber, double amount) {

        Account account = accounts.get(accountNumber);

        if (account != null) {

            account.withdraw(amount);

            Transaction transaction = new Transaction(
                    transactionCounter++,
                    "Withdraw",
                    amount,
                    LocalDateTime.now());

            account.addTransaction(transaction);

            FileUtil.saveAccounts(accounts);

        } else {

            System.out.println("Account Not Found.");

        }

    }

    public void transferMoney(String fromAccount,
                              String toAccount,
                              double amount) {

        Account sender = accounts.get(fromAccount);
        Account receiver = accounts.get(toAccount);

        if (sender == null) {

            System.out.println("Sender Account Not Found.");
            return;

        }

        if (receiver == null) {

            System.out.println("Receiver Account Not Found.");
            return;

        }

        if (sender.getBalance() < amount) {

            System.out.println("Insufficient Balance.");
            return;

        }

        sender.withdraw(amount);

        receiver.deposit(amount);

        sender.addTransaction(new Transaction(
                transactionCounter++,
                "Transfer To " + toAccount,
                amount,
                LocalDateTime.now()));

        receiver.addTransaction(new Transaction(
                transactionCounter++,
                "Received From " + fromAccount,
                amount,
                LocalDateTime.now()));

        FileUtil.saveAccounts(accounts);

        System.out.println("Transfer Successful.");

    }

    public void checkBalance(String accountNumber) {

        Account account = accounts.get(accountNumber);

        if (account != null) {

            System.out.println("----------------------------------");
            System.out.println("Current Balance : ₹" + account.getBalance());
            System.out.println("----------------------------------");

        } else {

            System.out.println("Account Not Found.");

        }

    }

    public void displayAccounts() {

        if (accounts.isEmpty()) {

            System.out.println("No Accounts Found.");
            return;

        }

        System.out.println("\n========= ACCOUNT DETAILS =========");

        for (Account account : accounts.values()) {

            System.out.println(account);
            System.out.println("----------------------------------");

        }

    }

    public void displayTransactionHistory(String accountNumber) {

        Account account = accounts.get(accountNumber);

        if (account == null) {

            System.out.println("Account Not Found.");
            return;

        }

        if (account.getTransactions().isEmpty()) {

            System.out.println("No Transactions Found.");
            return;

        }

        System.out.println("\n===== Transaction History =====");

        for (Transaction transaction : account.getTransactions()) {

            System.out.println(transaction);

        }

    }

    public void deleteAccount(String accountNumber) {

        if (accounts.remove(accountNumber) != null) {

            FileUtil.saveAccounts(accounts);

            System.out.println("Account Deleted Successfully.");

        } else {

            System.out.println("Account Not Found.");

        }

    }

}