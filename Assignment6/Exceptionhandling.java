package Assignment6;
import java.util.*;


class InsufficientLeaveException extends Exception {
    public InsufficientLeaveException(String message) {
        super(message);
    }
}


class LeaveRequest {
    String type;
    int days;
    boolean approved;

    LeaveRequest(String type, int days) {
        this.type = type;
        this.days = days;
        this.approved = false;
    }
}


class Employee {
    int id;
    String name;
    int casualLeaves;
    int earnedLeaves;

    LeaveRequest request;

    Employee(int id, String name, int casual, int earned) {
        this.id = id;
        this.name = name;
        this.casualLeaves = casual;
        this.earnedLeaves = earned;

        assert casual >= 0 && earned >= 0 : "Leave balance cannot be negative!";
    }

    
    void applyLeave(String type, int days) throws InsufficientLeaveException {
        if (type.equalsIgnoreCase("casual")) {
            if (days > casualLeaves) {
                throw new InsufficientLeaveException("Not enough casual leaves!");
            }
        } else if (type.equalsIgnoreCase("earned")) {
            if (days > earnedLeaves) {
                throw new InsufficientLeaveException("Not enough earned leaves!");
            }
        } else {
            throw new IllegalArgumentException("Invalid leave type!");
        }

        request = new LeaveRequest(type, days);
        System.out.println("Leave applied successfully!");
    }

    
    void approveLeave() {
        if (request == null) {
            System.out.println("No leave request found.");
            return;
        }

        if (request.type.equalsIgnoreCase("casual")) {
            casualLeaves -= request.days;
        } else {
            earnedLeaves -= request.days;
        }

        request.approved = true;
        System.out.println("Leave approved!");
    }

    
    void rejectLeave() {
        if (request == null) {
            System.out.println("No leave request found.");
            return;
        }

        request.approved = false;
        System.out.println("Leave rejected!");
    }

    
    void display() {
        System.out.println("\nEmployee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Casual Leaves: " + casualLeaves);
        System.out.println("Earned Leaves: " + earnedLeaves);
    }
}


public class Exceptionhandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee employee = new Employee(1, "Kedar", 10, 15);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Apply Leave");
            System.out.println("2. Approve Leave");
            System.out.println("3. Reject Leave");
            System.out.println("4. Display Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter leave type (casual/earned): ");
                        String type = sc.next();

                        System.out.print("Enter number of days: ");
                        int days = sc.nextInt();

                        employee.applyLeave(type, days);
                        break;

                    case 2:
                        employee.approveLeave();
                        break;

                    case 3:
                        employee.rejectLeave();
                        break;

                    case 4:
                        employee.display();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } 
            catch (InsufficientLeaveException e) {
                System.out.println("Error: " + e.getMessage());
            } 
            catch (Exception e) {
                System.out.println("General Error: " + e.getMessage());
            } 
            finally {
                System.out.println("Operation completed.\n");
            }
        }
    }
}