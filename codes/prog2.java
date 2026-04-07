import java.util.Scanner;

public class prog2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int sum=0;
        
        while(true){
            System.out.println("Enter num or 'x' to terminate:");
            String input=sc.next();

            if(input.equals("0")){
                break;
            }
int num = Integer.parseInt(input);
            sum+=num;
        }
        System.out.println("total sum = "+ sum);
                sc.close();

        }
    }
