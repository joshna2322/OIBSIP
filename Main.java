package atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Demo accounts for the internship project.
        bank.addAccount(new Account("1001", "1234", 10000.00));
        bank.addAccount(new Account("1002", "5678", 7500.00));

        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(bank, scanner);
        atm.start();
        scanner.close();
    }
}
