package model;

public class CurrentAccount extends Account {

    private static final long serialVersionUID = 1L;

   

    private double overdraftLimit;

    public CurrentAccount(String accountNumber,
                          double balance,
                          int pin,
                          Customer customer,
                          double overdraftLimit) {

        super(accountNumber,balance,pin,customer);

        this.overdraftLimit=overdraftLimit;

    }

    @Override
    public void withdraw(double amount) {

        if(amount<=getBalance()+overdraftLimit){

            setBalance(getBalance()-amount);

            System.out.println("Withdraw Successful");

        }

        else{

            System.out.println("Overdraft Limit Exceeded");

        }

    }

}