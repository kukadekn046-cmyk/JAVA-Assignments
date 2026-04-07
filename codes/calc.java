import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
       
        System.out.println("-------MENU--------");
        System.out.println("1. ADDITION");
        System.out.println("2. SUBTRACTION");
        System.out.println("3. DIVISION");
        System.out.println("4.MULTIPLICATION");
        System.out.print("ENTER YOUR CHOICE :");
        
        Scanner sc= new Scanner(System.in);
         int Choice= sc.nextInt();
        System.out.print("ENTER variable a :");
         int a= sc.nextInt();
       
        System.out.print("ENTER variable b :");

        
        int b= sc.nextInt();

        switch(Choice){

            case 1:
                 int sum=a+b;
                 System.out.println(sum);
                 break;
                 
            case 2:
                 int diffrance=a-b;
                 System.out.println(diffrance);
                 break;
            case 3:
                 int multiplication=a*b;
                 System.out.println(multiplication);
                 break;
            case 4:
                 int division=a/b;
                 System.out.println(division);
                 break;

                 default:
                    System.out.println("Invalid");
        }


  }
    
}
