package model;
public class SavingsAccount extends Account {

    private static final long serialVersionUID = 1L;

    

    public SavingsAccount(String accountNumber,
                          double balance,
                          int pin,
                          Customer customer) {

        super(accountNumber, balance, pin, customer);
    }

    @Override
    public void withdraw(double amount) {

        if(amount<=getBalance()){

            setBalance(getBalance()-amount);

            System.out.println("Withdraw Successful");

        }

        else{

            System.out.println("Insufficient Balance");

        }

    }

}