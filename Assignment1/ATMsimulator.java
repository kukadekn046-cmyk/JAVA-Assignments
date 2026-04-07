package Assignment1;
import java.util.Scanner;

public class ATMsimulator {

    // Operation constants
    static final int CHECK_BALANCE = 1;
    static final int DEPOSIT = 2;
    static final int WITHDRAW = 4;
    static final int TRANSFER = 8;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance;
        int userType = 0;
        int choice;
        char repeat;

        System.out.print("Enter initial balance: ");
        balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Invalid balance!");
            return;
        }

        System.out.println("\nSelect User Type:");
        System.out.println("1. Basic");
        System.out.println("2. Standard");
        System.out.println("3. Premium");
        System.out.print("Enter choice: ");
        int typeChoice = sc.nextInt();

        switch (typeChoice) {
            case 1:
                userType = CHECK_BALANCE | DEPOSIT;
                break;
            case 2:
                userType = CHECK_BALANCE | DEPOSIT | WITHDRAW;
                break;
            case 3:
                userType = CHECK_BALANCE | DEPOSIT | WITHDRAW | TRANSFER;
                break;
            default:
                System.out.println("Invalid user type!");
                return;
        }

        do {
            System.out.println("\n---- ATM MENU ----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if ((userType & CHECK_BALANCE) != 0)
                        System.out.println("Current Balance: ₹" + balance);
                    else
                        System.out.println("Operation not allowed!");
                    break;

                case 2:
                    if ((userType & DEPOSIT) != 0) {
                        System.out.print("Enter deposit amount: ");
                        double dep = sc.nextDouble();
                        if (dep > 0) {
                            balance += dep;
                            System.out.println("Deposit successful.");
                        } else {
                            System.out.println("Invalid amount!");
                        }
                    } else {
                        System.out.println("Operation not allowed!");
                    }
                    break;

                case 3:
                    if ((userType & WITHDRAW) != 0) {
                        System.out.print("Enter withdraw amount: ");
                        double wd = sc.nextDouble();
                        if (wd > 0 && wd <= balance) {
                            balance -= wd;
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Invalid or insufficient balance!");
                        }
                    } else {
                        System.out.println("Operation not allowed!");
                    }
                    break;

                case 4:
                    if ((userType & TRANSFER) != 0) {
                        System.out.print("Enter transfer amount: ");
                        double tf = sc.nextDouble();
                        if (tf > 0 && tf <= balance) {
                            balance -= tf;
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Invalid or insufficient balance!");
                        }
                    } else {
                        System.out.println("Operation not allowed!");
                    }
                    break;

                default:
                    System.out.println("Invalid option!");
            }

            System.out.print("\nDo you want to continue? (y/n): ");
            repeat = sc.next().charAt(0);

        } while (repeat == 'y' || repeat == 'Y');

        System.out.println("Thank you for using ATM!");
        sc.close();
    }
}
