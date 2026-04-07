import java.util.Scanner;

public class MyFirstJava{
   public static void main(String[] args) {
      System.out.println("Hello Java ");
      Scanner sc= new Scanner(System.in);  
      String name= sc.nextLine();
      System.out.println(name);
   }
}