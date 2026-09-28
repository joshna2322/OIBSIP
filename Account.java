package atm;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String userId;
    private final String pin;
    private double balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public boolean authenticate(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount, "Cash withdrawal"));
        return true;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        transactions.add(new Transaction("DEPOSIT", amount, "Cash deposit"));
        return true;
    }

    public boolean transferTo(Account recipient, double amount) {
        if (recipient == null || recipient == this || amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        recipient.balance += amount;
        transactions.add(new Transaction("TRANSFER", amount,
                "To account " + recipient.userId));
        recipient.transactions.add(new Transaction("TRANSFER", amount,
                "From account " + userId));
        return true;
    }
}
