import java.util.Scanner;

class Book {
    int bookId;
    String title;
    double price;
    String edition;
    boolean isIssued;
    int issuedToMIS;   

    Book(int bookId, String title, double price, String edition) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.edition = edition;
        this.isIssued = false;
        this.issuedToMIS = 0; 
    }

    void displayBook() {
        System.out.println(
            bookId + "\t" +
            title + "\t\t" +
            edition + "\t₹" +
            price + "\t\t" +
            (isIssued ? "Issued (MIS: " + issuedToMIS + ")" : "Available")
        );
    }
}

class Library {

    static int totalBooks = 0;
    static int issuedBooks = 0;

    Book[] books = new Book[10];

    void addBooks() {
        books[0] = new Book(1, "Java Programming", 450, "3rd");
        books[1] = new Book(2, "Data Structures", 550, "2nd");
        books[2] = new Book(3, "DBMS", 500, "4th");
        books[3] = new Book(4, "Operating Systems", 600, "3rd");
        books[4] = new Book(5, "Computer Networks", 480, "2nd");
        books[5] = new Book(6, "Python Basics", 350, "1st");
        books[6] = new Book(7, "Software Engineering", 520, "3rd");
        books[7] = new Book(8, "Web Development", 400, "2nd");
        books[8] = new Book(9, "AI Fundamentals", 700, "1st");
        books[9] = new Book(10, "Cloud Computing", 650, "1st");

        totalBooks = books.length;
    }

    void displayBooks() {
        System.out.println("\nID\tTitle\t\t\tEdition\tPrice\t\tStatus");
        System.out.println("----------------------------------------------------------------");
        for (Book b : books) {
            b.displayBook();
        }
    }


    void issueBook(int id, int mis) {
        for (Book b : books) {
            if (b.bookId == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    b.issuedToMIS = mis;
                    issuedBooks++;
                    System.out.println("Book issued to student MIS: " + mis);
                } else {
                    System.out.println("Book already issued to MIS: " + b.issuedToMIS);
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    
    void returnBook(int id, int mis) {
        for (Book b : books) {
            if (b.bookId == id) {
                if (b.isIssued && b.issuedToMIS == mis) {
                    b.isIssued = false;
                    b.issuedToMIS = 0;
                    issuedBooks--;
                    System.out.println("Book returned successfully.");
                } else if (!b.isIssued) {
                    System.out.println("Book was not issued.");
                } else {
                    System.out.println("This book was issued to another student.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void issuedPercentage() {
        double percent = ((double)issuedBooks / totalBooks) * 100;
        System.out.println("Percentage of issued books: " + percent + "%");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        lib.addBooks();

        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Issued Books Percentage");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    lib.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    System.out.print("Enter Student MIS: ");
                    int mis = sc.nextInt();
                    lib.issueBook(bid, mis);
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int rbid = sc.nextInt();
                    System.out.print("Enter Student MIS: ");
                    int rmis = sc.nextInt();
                    lib.returnBook(rbid, rmis);
                    break;

                case 4:
                    lib.issuedPercentage();
                    break;

                case 5:
                    System.out.println("Exiting Library System. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
