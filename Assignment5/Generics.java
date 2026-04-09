package Assignment5;

import java.util.*;


class Item {
    int id;
    String name;
    double price;

    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
    }
}

class Electronics extends Item {
    int warranty;

    public Electronics(int id, String name, double price, int warranty) {
        super(id, name, price);
        this.warranty = warranty;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Warranty: " + warranty + " years");
    }
}

class Groceries extends Item {
    String expiryDate;

    public Groceries(int id, String name, double price, String expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Expiry Date: " + expiryDate);
    }
}

class Clothing extends Item {
    String size;

    public Clothing(int id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Size: " + size);
    }
}

class Inventory<T extends Item> {
    private ArrayList<T> items = new ArrayList<>();

   
    public void addItem(T item) {
        items.add(item);
        System.out.println("Item added successfully!");
    }

   
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }
        for (T item : items) {
            item.display();
            System.out.println("----------------------");
        }
    }

   
    public T searchItem(int id) {
        for (T item : items) {
            if (item.id == id) {
                return item;
            }
        }
        return null;
    }

    public void updatePrice(int id, double newPrice) {
        T item = searchItem(id);
        if (item != null) {
            item.price = newPrice;
            System.out.println("Price updated successfully!");
        } else {
            System.out.println("Item not found!");
        }
    }
}

public class Generics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Inventory<Electronics> electronicsInventory = new Inventory<>();
        Inventory<Groceries> groceriesInventory = new Inventory<>();
        Inventory<Clothing> clothingInventory = new Inventory<>();

        int choice;

        do {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Electronics");
            System.out.println("2. Add Groceries");
            System.out.println("3. Add Clothing");
            System.out.println("4. Display All Items");
            System.out.println("5. Search Item");
            System.out.println("6. Update Price");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Price, Warranty: ");
                    int eId = sc.nextInt();
                    String eName = sc.next();
                    double ePrice = sc.nextDouble();
                    int warranty = sc.nextInt();
                    electronicsInventory.addItem(new Electronics(eId, eName, ePrice, warranty));
                    break;

                case 2:
                    System.out.print("Enter ID, Name, Price, Expiry Date: ");
                    int gId = sc.nextInt();
                    String gName = sc.next();
                    double gPrice = sc.nextDouble();
                    String expiry = sc.next();
                    groceriesInventory.addItem(new Groceries(gId, gName, gPrice, expiry));
                    break;

                case 3:
                    System.out.print("Enter ID, Name, Price, Size: ");
                    int cId = sc.nextInt();
                    String cName = sc.next();
                    double cPrice = sc.nextDouble();
                    String size = sc.next();
                    clothingInventory.addItem(new Clothing(cId, cName, cPrice, size));
                    break;

                case 4:
                    System.out.println("\n--- Electronics ---");
                    electronicsInventory.displayItems();

                    System.out.println("\n--- Groceries ---");
                    groceriesInventory.displayItems();

                    System.out.println("\n--- Clothing ---");
                    clothingInventory.displayItems();
                    break;

                case 5:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();

                    Item found = electronicsInventory.searchItem(searchId);
                    if (found == null)
                        found = groceriesInventory.searchItem(searchId);
                    if (found == null)
                        found = clothingInventory.searchItem(searchId);

                    if (found != null) {
                        found.display();
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;

                case 6:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    electronicsInventory.updatePrice(updateId, newPrice);
                    groceriesInventory.updatePrice(updateId, newPrice);
                    clothingInventory.updatePrice(updateId, newPrice);
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