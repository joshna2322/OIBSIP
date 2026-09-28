# OIBSIP - Java Development - Task 3: ATM Interface

## Objective
A console-based ATM simulation built in Java using object-oriented programming.

## Features
- User ID and PIN authentication
- Maximum 3 incorrect login attempts
- Transaction History
- Withdraw with insufficient-funds validation
- Deposit
- Transfer between two accounts
- All transactions stored in an `ArrayList`
- Five distinct Java classes: `ATM`, `Account`, `Transaction`, `Bank`, `Main`
- Input validation and clear console messages

## Technology
- Java
- OOP
- ArrayList
- HashMap
- Scanner
- switch-case

## Demo Credentials
Account 1:
- User ID: `1001`
- PIN: `1234`
- Opening balance: ₹10000

Account 2:
- User ID: `1002`
- PIN: `5678`
- Opening balance: ₹7500

## Project Structure
```text
OIBSIP/
└── JavaDevelopment-Task3-ATMInterface/
    ├── src/
    │   ├── Main.java
    │   ├── ATM.java
    │   ├── Account.java
    │   ├── Transaction.java
    │   └── Bank.java
    └── README.md
```

## How to Run

Open a terminal inside the `src` folder:

```bash
javac -d . *.java
java atm.Main
```

If using an IDE such as Eclipse or IntelliJ IDEA, create a Java project, place the files in the `atm` package, and run `Main.java`.

## Suggested Demo
1. Login with `1001` / `1234`.
2. Show Transaction History.
3. Deposit ₹500.
4. Withdraw ₹1000.
5. Transfer ₹500 to account `1002`.
6. Show Transaction History again.
7. Try a withdrawal larger than the balance to demonstrate `Insufficient Funds`.
8. Quit.

## GitHub Folder
Use the required repository name:

`OIBSIP`

Use this project folder name:

`JavaDevelopment-Task3-ATMInterface`

Keep the source code and README inside that folder.
