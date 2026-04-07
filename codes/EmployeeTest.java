
import java.util.Scanner;

class Employee {

    int id;
    String name;
    double salary;
    double bonus;
    int rating;

    // Default Constructor
    Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.salary = 10000.00;
        this.bonus = 0;
        this.rating = 1;
    }

    // Constructor Overloading (salary only)
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bonus = 0;
        this.rating = 1;
    }

    // Constructor Overloading (salary and bonus)
    Employee(int id, String name, double salary, double bonus) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        this.rating = 1;
    }

    // Method to calculate total salary
    double calculateTotalSalary() {
        return salary + (bonus * rating);
    }

    // Method Overloading - update bonus only
    void update(double bonus) {
        this.bonus = bonus;
    }

    // Method Overloading - update rating only
    void update(int rating) {
        this.rating = rating;
    }

    // Method Overloading - update both
    void update(double bonus, int rating) {
        this.bonus = bonus;
        this.rating = rating;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name +", Salary: " + salary +", Bonus: " + bonus +", Rating: " + rating +", Total Salary: " + calculateTotalSalary());
    }
}

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee[] emp = new Employee[10];

        // Creating 10 employee records
        for (int i = 0; i < 10; i++) {

            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary (Enter 0 for default): ");
            double salary = sc.nextDouble();

            System.out.print("Enter Bonus (Enter 0 if none): ");
            double bonus = sc.nextDouble();

            if (salary == 0 && bonus == 0)
                emp[i] = new Employee(id, name);
            else if (bonus == 0)
                emp[i] = new Employee(id, name, salary);
            else
                emp[i] = new Employee(id, name, salary, bonus);
        }

        // Display Before Update
        System.out.println("\n------ BEFORE UPDATE ------");
        for (int i = 0; i < 10; i++) {
            emp[i].display();
        }

        // Update Section
        System.out.print("\nEnter Employee ID to update: ");
        int searchId = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            if (emp[i].id == searchId) {

                System.out.println("1. Update Bonus");
                System.out.println("2. Update Rating");
                System.out.println("3. Update Both");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter new Bonus: ");
                        double newBonus = sc.nextDouble();
                        emp[i].update(newBonus);
                        break;

                    case 2:
                        System.out.print("Enter new Rating: ");
                        int newRating = sc.nextInt();
                        emp[i].update(newRating);
                        break;

                    case 3:
                        System.out.print("Enter new Bonus: ");
                        double b = sc.nextDouble();
                        System.out.print("Enter new Rating: ");
                        int r = sc.nextInt();
                        emp[i].update(b, r);
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
            }
        }

        // Display After Update
        System.out.println("\n------ AFTER UPDATE ------");
        for (int i = 0; i < 10; i++) {
            emp[i].display();
        }

        sc.close();
    }
}
