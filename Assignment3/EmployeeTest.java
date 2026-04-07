import java.util.Scanner;

class Employee {

    int id;
    String name;
    double salary;
    double bonus;
    int rating;

    
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bonus = 0;   // default bonus
        this.rating = 1;  // default rating
    }

    double calculateTotalSalary() {
        return salary + (bonus * rating);
    }

    void updateBonus(double bonus) {
        this.bonus = bonus;
    }

    void updateRating(int rating) {
        if (rating >= 1 && rating <= 5)
            this.rating = rating;
        else
            System.out.println("Invalid Rating! Must be 1-5.");
    }

    void updateSalary(double salary) {
        if (salary > 0)
            this.salary = salary;
        else
            System.out.println("Salary must be positive!");
    }

    void display() {
        System.out.println("ID: " + id +
                ", Name: " + name +
                ", Salary: " + salary +
                ", Bonus: " + bonus +
                ", Rating: " + rating +
                ", Total Salary: " + calculateTotalSalary());
    }
}

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = {"Aadarsh", "Aryan","Akash", "kedar", "madhur", "pratik","pranjal","shubham","vaibhav","yogesh"};

        Employee[] emp = new Employee[10];

        for (int i = 0; i < 10; i++) {
            int id = 01 + i;
            double salary = 10000 ;
            emp[i] = new Employee(id, names[i], salary);
        }

        int choice;

        do {
            System.out.println("\n------Menu------");
            System.out.println("1. Display All Employees");
            System.out.println("2. Update Bonus");
            System.out.println("3. Update Rating");
            System.out.println("4. Update Salary");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Employee e : emp)
                        e.display();
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    int idBonus = sc.nextInt();
                    for (Employee e : emp) {
                        if (e.id == idBonus) {
                            System.out.print("Enter New Bonus: ");
                            e.updateBonus(sc.nextDouble());
                            System.out.println("Bonus Updated!");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    double idRating = sc.nextInt();
                    for (Employee e : emp) {
                        if (e.id == idRating) {
                            System.out.print("Enter New Rating (1-5): ");
                            e.updateRating(sc.nextInt());
                            System.out.println("Rating Updated!");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    int idSalary = sc.nextInt();
                    for (Employee e : emp) {
                        if (e.id == idSalary) {
                            System.out.print("Enter New Salary: ");
                            e.updateSalary(sc.nextDouble());
                            System.out.println("Salary Updated!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}