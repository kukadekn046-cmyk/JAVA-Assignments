import java.util.Arrays;
import java.util.Scanner;
public class array {
    public static void main(String[] args) {
         Scanner sc= new Scanner(System.in);
        System.out.println("enter size of array");
       
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            
        }
         for(int num :arr){
            
            System.out.print(num +" ");
        }
        
    }
    
}
