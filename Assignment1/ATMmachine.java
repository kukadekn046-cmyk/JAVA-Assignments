package Assignment1;


import java.util.Scanner;

import ATM;

class ATM {
    float Balance=100;
    int PIN=2006;
    Scanner sc = new Scanner(System.in);

   public void checkpin(){
    System.out.println("Enter your Pin:");
    Scanner sc=new Scanner(System.in);
    int Enteredpin=sc.nextInt();//stored input pin in Enteredpin
    if(Enteredpin==PIN){
        menu();
    }
    else{
        System.out.println("Enter a Valid pin");
    }
   }
      
    public void menu(){
        System.out.println("-------ATM MENU---------");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
        System.out.println("Enter your Choice :");
      
        int choice=sc.nextInt();

      switch(choice){
        case 1:
        System.out.println("Available Balance:"+Balance);
        menu();
        break;
       
        case 2:
        System.out.println("Enter Amount To withdraw;");
        int amount=sc.nextInt();
        if(amount>Balance){
            System.out.println("Insufficient Balance");
               }
               else{
                Balance =Balance-amount;
                System.out.println("Withdraw Successful");
               }
               menu();
               break;
        case 3:
        System.out.println("Enter Amount to Deposit:");
        
        int Deposit=sc.nextInt();
        Balance =Balance +Deposit;
        System.out.println("Amount Deposited Successfully");
        menu();
        break;

        case 4:
            System.out.println("Enter account number to transfer:");
            double accountNumber=sc.nextDouble();
            System.out.println("Enter name of account holder:");
            String accountname= sc.nextLine();
            System.out.println("Enter Amount to Transfer:");
            int transfer=sc.nextInt();

            if(transfer>Balance){
                System.out.println("Insufficient Balance to Transfer");
              }
               else{
                    Balance =Balance-transfer;
                    System.out.println("Transfer Successful");
                   }
                   menu();
                    break;
        
        case 5:
               return;
        
         default:
                 System.out.println("Invalid Option");
      }
        
}
}

public class ATMmachine {
 public static void main(String[] args) {
    ATM Obj = new ATM();
    Obj.checkpin();
    System.out.println("thank you for using ATM..!");
    
 }
}

        
