# Bank Management System

A console-based **Bank Management System** developed using **Core Java** and **Object-Oriented Programming (OOP)** principles. The application allows users to manage bank accounts, perform transactions, and securely store account information using Java Serialization.



Features

- Create Savings Account
- Create Current Account
- Automatic Customer ID Generation
- Automatic Account Number Generation
- Deposit Money
- Withdraw Money
- Transfer Money Between Accounts
- PIN Verification for Secure Transactions
- Check Account Balance
- Display All Accounts
- Delete Account
- View Transaction History
- Persistent Data Storage using File Handling (Serialization)

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Collections Framework
  - HashMap
  - ArrayList
- Java Serialization
- File Handling
- LocalDateTime API
- VS Code

---

## 📚 OOP Concepts Implemented

- Encapsulation
- Inheritance
- Abstraction
- Runtime Polymorphism
- Association
- Composition

---

## 📂 Project Structure

```
BankManagementSystem
│
├── src
│   ├── model
│   │   ├── Customer.java
│   │   ├── Account.java
│   │   ├── SavingsAccount.java
│   │   ├── CurrentAccount.java
│   │   └── Transaction.java
│   │
│   ├── service
│   │   └── BankService.java
│   │
│   ├── util
│   │   └── FileUtil.java
│   │
│   ├── exception
│   │
│   └── Main.java
│
├── accounts.dat
└── README.md
```

---

## 🚀 How to Run

1. Clone the repository

```bash
git clone https://github.com/vikash2004-star/bank-management-system.git
```

2. Open the project in **VS Code** or any Java IDE.

3. Compile and run `Main.java`.

4. Use the console menu to perform banking operations.

---

## 📋 Menu Options

```
1. Create Savings Account
2. Create Current Account
3. Deposit
4. Withdraw
5. Transfer Money
6. Check Balance
7. Display All Accounts
8. Delete Account
9. View Transaction History
10. Exit
```

---

## 💾 File Handling

The project uses **Java Serialization** to store account data.

- Account information is automatically saved to `accounts.dat`.
- Data remains available even after closing and reopening the application.

---

## Security

- PIN Verification before Withdrawal
- PIN Verification before Money Transfer

---

## Learning Outcomes

This project helped in understanding:

- Core Java
- Object-Oriented Programming
- Collections Framework
- File Handling
- Serialization & Deserialization
- Menu-Driven Applications
- Real-world Object Modeling


GitHub: https://github.com/vikash2004-star

