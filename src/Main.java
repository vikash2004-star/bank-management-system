import java.util.Scanner;

import model.CurrentAccount;
import model.Customer;
import model.SavingsAccount;
import service.BankService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankService();

        while (true) {

            System.out.println("\n========== BANK MANAGEMENT SYSTEM ==========");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer Money");
            System.out.println("6. Check Balance");
            System.out.println("7. Display All Accounts");
            System.out.println("8. Delete Account");
            System.out.println("9. View Transaction History");
            System.out.println("10. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    int customerId = bankService.generateCustomerId();
                    String accountNumber = bankService.generateAccountNumber();

                    System.out.println("Customer ID : " + customerId);
                    System.out.println("Account Number : " + accountNumber);

                    System.out.print("Name : ");
                    String name = sc.nextLine();

                    System.out.print("Phone : ");
                    String phone = sc.nextLine();

                    System.out.print("Email : ");
                    String email = sc.nextLine();

                    System.out.print("Address : ");
                    String address = sc.nextLine();

                    System.out.print("Initial Balance : ");
                    double balance = sc.nextDouble();

                    System.out.print("PIN : ");
                    int pin = sc.nextInt();

                    Customer customer = new Customer(
                            customerId,
                            name,
                            phone,
                            email,
                            address);

                    SavingsAccount savings = new SavingsAccount(
                            accountNumber,
                            balance,
                            pin,
                            customer);

                    bankService.createAccount(savings);

                    break;

                case 2:

                    int customerId2 = bankService.generateCustomerId();
                    String accountNumber2 = bankService.generateAccountNumber();

                    System.out.println("Customer ID : " + customerId2);
                    System.out.println("Account Number : " + accountNumber2);

                    System.out.print("Name : ");
                    String name2 = sc.nextLine();

                    System.out.print("Phone : ");
                    String phone2 = sc.nextLine();

                    System.out.print("Email : ");
                    String email2 = sc.nextLine();

                    System.out.print("Address : ");
                    String address2 = sc.nextLine();

                    System.out.print("Initial Balance : ");
                    double balance2 = sc.nextDouble();

                    System.out.print("PIN : ");
                    int pin2 = sc.nextInt();

                    System.out.print("Overdraft Limit : ");
                    double limit = sc.nextDouble();

                    Customer customer2 = new Customer(
                            customerId2,
                            name2,
                            phone2,
                            email2,
                            address2);

                    CurrentAccount current = new CurrentAccount(
                            accountNumber2,
                            balance2,
                            pin2,
                            customer2,
                            limit);

                    bankService.createAccount(current);

                    break;

                case 3:

                    System.out.print("Account Number : ");
                    String depositAccount = sc.nextLine();

                    System.out.print("Amount : ");
                    double amount = sc.nextDouble();

                    bankService.deposit(depositAccount, amount);

                    break;

                case 4:

                    System.out.print("Account Number : ");
                    String withdrawAccount = sc.nextLine();

                    System.out.print("Enter PIN : ");
                    int enteredPin = sc.nextInt();

                    System.out.print("Amount : ");
                    double withdrawAmount = sc.nextDouble();

                    if (bankService.verifyPin(withdrawAccount, enteredPin)) {

                        bankService.withdraw(withdrawAccount, withdrawAmount);

                    }

                    break;

                case 5:

                    System.out.print("From Account : ");
                    String from = sc.nextLine();

                    System.out.print("Enter PIN : ");
                    int pin1 = sc.nextInt();
                    sc.nextLine();

                    if (!bankService.verifyPin(from, pin1)) {
                        break;
                    }

                    System.out.print("To Account : ");
                    String to = sc.nextLine();

                    System.out.print("Amount : ");
                    double transferAmount = sc.nextDouble();

                    bankService.transferMoney(from, to, transferAmount);

                    break;

                case 6:

                    System.out.print("Account Number : ");
                    String balanceAccount = sc.nextLine();

                    bankService.checkBalance(balanceAccount);

                    break;

                case 7:

                    bankService.displayAccounts();

                    break;

                case 8:

                    System.out.print("Account Number : ");
                    String deleteAccount = sc.nextLine();

                    bankService.deleteAccount(deleteAccount);

                    break;

                case 9:

                    System.out.print("Account Number : ");
                    String historyAccount = sc.nextLine();

                    bankService.displayTransactionHistory(historyAccount);

                    break;

                case 10:

                    System.out.println("Thank You...");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}