 import java.util.Scanner;

public class prog3 {


    
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num;
        int largest=Integer.MIN_VALUE;
        
        while(true){
            System.out.println("Enter num or '0' to terminate:");
            num =sc.nextInt();
           
            if(num==0){
                break;
            }
            if(num>largest){
                largest=num;

            }
             
        }
        if (largest==Integer.MIN_VALUE) {
            System.out.println("no min value is entered:");
        }
        else{
            System.out.println("largest value "+largest);
        }
            
        
        
                sc.close();

        }
    }
 
