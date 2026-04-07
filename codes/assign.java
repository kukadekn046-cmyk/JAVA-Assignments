import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;

// Base class
class Person {
    String name;
    int code;

    Person(String name, int code) {
        this.name = name;
        this.code = code;
    }
}

// Child class 1
class Account extends Person {
    double pay;

    Account(String name, int code, double pay) {
        super(name, code);
        this.pay = pay;
    }
}

// Child class 2
class Admin extends Person {
    int experience;

    Admin(String name, int code, int experience) {
        super(name, code);
        this.experience = experience;
    }
}

// Employee class (inherits Account)
class Employee extends Account {
    int experience;

    Employee(String name, int code, double pay, int experience) {
        super(name, code, pay);
        this.experience = experience;
    }

    void display() {
        System.out.println("Employee Details");
        System.out.println("----------------");
        System.out.println("Name       : " + name);
        System.out.println("Code       : " + code);
        System.out.println("Pay        : " + pay);
        System.out.println("Experience : " + experience + " years");
    }
}

// Main class
public class assign {
    public static void main(String[] args) {

        Employee emp = new Employee("Kedar", 101, 45000, 3);
        emp.display();

        System.out.println("\nDate and Time Information");
        System.out.println("-------------------------");

        LocalDateTime now = LocalDateTime.now();

        System.out.println("Current Date and Time : " + now);
        System.out.println("Current Year          : " + now.getYear());
        System.out.println("Month of the Year     : " + now.getMonth());
        System.out.println("Week Number of Year   : " + now.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear()));
        System.out.println("Day of the Week       : " + now.getDayOfWeek());
        System.out.println("Day of the Year       : " + now.getDayOfYear());
        System.out.println("Day of the Month      : " + now.getDayOfMonth());
    }
}
