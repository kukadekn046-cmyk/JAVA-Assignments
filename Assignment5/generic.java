import java.util.*;

// ================= BASE CLASS =================
abstract class Item {
    private int id;
    private String name;
    private double price;

    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract void display();
}

// ================= ELECTRONICS =================
class Electronics extends Item {
    private String brand;

    public Electronics(int id, String name, double price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    @Override
    public void display() {
        System.out.println("Electronics -> ID: " + getId() + ", Name: " + getName() +", Brand: " + brand + ", Price: " + getPrice());
    }
}

// ================= GROCERIES =================
class Groceries extends Item {
    private String expiryDate;

    public Groceries(int id, String name, double price, String expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public void display() {
        System.out.println("Grocery -> ID: " + getId() +", Name: " + getName() +", Expiry: " + expiryDate +", Price: " + getPrice());
    }
}

// ================= CLOTHING =================
class Clothing extends Item {
    private String size;

    public Clothing(int id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("Clothing -> ID: " + getId() +", Name: " + getName() +", Size: " + size +", Price: " + getPrice());
    }
}

// ================= GENERIC INVENTORY =================
class Inventory<T extends Item> {
    private List<T> items = new ArrayList<>();

    // Add item
    public void addItem(T item) {
        items.add(item);
        System.out.println("Item added successfully!");
    }

    // Remove item by ID
    public void removeItem(int id) {
        boolean removed = items.removeIf(item -> item.getId() == id);
        if (removed)
            System.out.println("Item removed successfully!");
        else
            System.out.println("Item not found!");
    }

    // Search item
    public void searchItem(int id) {
        for (T item : items) {
            if (item.getId() == id) {
                item.display();
                return;
            }
        }
        System.out.println("Item not found!");
    }

    // Display all
    public void displayAll() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }
        for (T item : items) {
            item.display();
        }
    }
}

// ================= MAIN CLASS =================
public class generic {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Inventory<Electronics> electronicsInventory = new Inventory<>();
        Inventory<Groceries> groceryInventory = new Inventory<>();
        Inventory<Clothing> clothingInventory = new Inventory<>();

        int choice;

        do {
            System.out.println("\n===== INVENTORY MENU =====");
            System.out.println("1. Add Electronics");
            System.out.println("2. Add Grocery");
            System.out.println("3. Add Clothing");
            System.out.println("4. Display All");
            System.out.println("5. Search Item");
            System.out.println("6. Remove Item");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int eid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String ename = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double eprice = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Brand: ");
                    String brand = sc.nextLine();

                    electronicsInventory.addItem(
                            new Electronics(eid, ename, eprice, brand));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int gid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String gname = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double gprice = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Expiry Date: ");
                    String expiry = sc.nextLine();

                    groceryInventory.addItem(
                            new Groceries(gid, gname, gprice, expiry));
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double cprice = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Size: ");
                    String size = sc.nextLine();

                    clothingInventory.addItem(
                            new Clothing(cid, cname, cprice, size));
                    break;

                case 4:
                    System.out.println("\n--- Electronics ---");
                    electronicsInventory.displayAll();

                    System.out.println("\n--- Groceries ---");
                    groceryInventory.displayAll();

                    System.out.println("\n--- Clothing ---");
                    clothingInventory.displayAll();
                    break;

                case 5:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();

                    electronicsInventory.searchItem(sid);
                    groceryInventory.searchItem(sid);
                    clothingInventory.searchItem(sid);
                    break;

                case 6:
                    System.out.print("Enter ID to remove: ");
                    int rid = sc.nextInt();

                    electronicsInventory.removeItem(rid);
                    groceryInventory.removeItem(rid);
                    clothingInventory.removeItem(rid);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}