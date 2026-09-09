import java.util.Scanner;

// Bank Account class
class BankAccount {

    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
            System.out.printf("Amount deposited: %.2f\n", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
            System.out.printf("Amount withdrawn: %.2f\n", amount);
        }
    }

    // Check balance
    public double checkBalance() {
        return balance;
    }
}

// ATM class
public class ATM {

    private BankAccount account;
    private Scanner sc;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    // Display ATM menu
    public void showMenu() {

        int choice;

        do {
            System.out.println("\n======================");
            System.out.println("       ATM MENU");
            System.out.println("======================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    // Check balance
    private void checkBalance() {
        System.out.printf(
                "Your current balance is: %.2f\n",
                account.checkBalance());
    }

    // Deposit
    private void deposit() {

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        account.deposit(amount);
    }

    // Withdraw
    private void withdraw() {

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        account.withdraw(amount);
    }

    // Main method
    public static void main(String[] args) {

        BankAccount account = new BankAccount(10000.00);

        ATM atm = new ATM(account);

        atm.showMenu();
    }
}