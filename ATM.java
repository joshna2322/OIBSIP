package atm;

import java.util.Scanner;

public class ATM {
    private final Bank bank;
    private final Scanner scanner;

    public ATM(Bank bank, Scanner scanner) {
        this.bank = bank;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("=================================");
        System.out.println("        WELCOME TO OIBSIP ATM");
        System.out.println("=================================");

        Account account = login();
        if (account == null) {
            System.out.println("Access denied. Goodbye!");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--------- MAIN MENU ---------");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> showHistory(account);
                case "2" -> withdraw(account);
                case "3" -> deposit(account);
                case "4" -> transfer(account);
                case "5" -> {
                    System.out.println("Thank you for using OIBSIP ATM. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private Account login() {
        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("\nEnter User ID: ");
            String userId = scanner.nextLine().trim();

            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine().trim();

            Account account = bank.findAccount(userId);
            if (account != null && account.authenticate(pin)) {
                System.out.println("Login successful.");
                return account;
            }

            System.out.println("Invalid credentials. Attempts left: " + (3 - attempt));
        }
        return null;
    }

    private void showHistory(Account account) {
        System.out.println("\n------ TRANSACTION HISTORY ------");
        if (account.getTransactions().isEmpty()) {
            System.out.println("No transactions in this session.");
        } else {
            for (Transaction transaction : account.getTransactions()) {
                System.out.println(transaction);
            }
        }
        System.out.printf("Current Balance: ₹%.2f%n", account.getBalance());
    }

    private void withdraw(Account account) {
        double amount = readAmount("Enter withdrawal amount: ₹");
        if (amount > account.getBalance()) {
            System.out.println("Insufficient Funds.");
            return;
        }
        if (account.withdraw(amount)) {
            System.out.printf("Withdrawal successful. Balance: ₹%.2f%n",
                    account.getBalance());
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void deposit(Account account) {
        double amount = readAmount("Enter deposit amount: ₹");
        if (account.deposit(amount)) {
            System.out.printf("Deposit successful. Balance: ₹%.2f%n",
                    account.getBalance());
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void transfer(Account account) {
        System.out.print("Enter recipient Account ID: ");
        String recipientId = scanner.nextLine().trim();

        Account recipient = bank.findAccount(recipientId);
        if (recipient == null) {
            System.out.println("Recipient account not found.");
            return;
        }
        if (recipient == account) {
            System.out.println("You cannot transfer to the same account.");
            return;
        }

        double amount = readAmount("Enter transfer amount: ₹");
        if (amount > account.getBalance()) {
            System.out.println("Insufficient Funds.");
            return;
        }

        if (account.transferTo(recipient, amount)) {
            System.out.printf("Transfer successful. Balance: ₹%.2f%n",
                    account.getBalance());
        } else {
            System.out.println("Invalid transfer amount.");
        }
    }

    private double readAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount > 0) return amount;
                System.out.println("Amount must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
