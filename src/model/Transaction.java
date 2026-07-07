package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
private static final long serialVersionUID = 1L;
    private int transactionId;
    private String transactionType;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(int transactionId, String transactionType, double amount, LocalDateTime dateTime) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}';
    }
}