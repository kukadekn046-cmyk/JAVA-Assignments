import java.util.Scanner;

class ATM {
    float balance = 100;
    int PIN = 2006;
    Scanner sc = new Scanner(System.in); // ONE scanner for whole class

    public void checkpin() {
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin == PIN) {
            menu();
        } else {
            System.out.println("Enter a valid PIN");
        }
    }

    public void menu() {
        System.out.println("\n---- ATM MENU ----");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Available Balance: ₹" + balance);
                menu();
                break;

            case 2:
                System.out.print("Enter amount to withdraw: ");
                float withdraw = sc.nextFloat();
                if (withdraw > balance) {
                    System.out.println("Insufficient Balance");
                } else {
                    balance -= withdraw;
                    System.out.println("Withdraw Successful");
                }
                menu();
                break;

            case 3:
                System.out.print("Enter amount to deposit: ");
                float deposit = sc.nextFloat();
                balance += deposit;
                System.out.println("Amount Deposited Successfully");
                menu();
                break;

            case 4:
                System.out.print("Enter account number to transfer: ");
                long accountNumber = sc.nextLong();

                sc.nextLine(); // consume newline

                System.out.print("Enter name of account holder: ");
                String accountName = sc.nextLine();

                System.out.print("Enter amount to transfer: ");
                float transfer = sc.nextFloat();

                if (transfer > balance) {
                    System.out.println("Insufficient Balance to Transfer");
                } else {
                    balance -= transfer;
                    System.out.println("Transfer Successful to " + accountName);
                }
                menu();
                break;

            case 5:
                System.out.println("Thank you for using ATM!");
                return;

            default:
                System.out.println("Invalid Option");
                menu();
        }
    }
}

public class lab1 {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkpin();

        
    }
}
