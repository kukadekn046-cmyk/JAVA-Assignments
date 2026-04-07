class Book {
    // Instance variables
    String title;
    double price;
    int edition;
    boolean isIssued;

    // Class variables
    static int totalBooks = 0;
    static int issuedBooks = 0;

    // Constructor
    Book(String title, double price, int edition) {
        this.title = title;
        this.price = price;
        this.edition = edition;
        this.isIssued = false;
        totalBooks++;
    }

    // Issue book
    void issueBook() {
        if (!isIssued) {
            isIssued = true;
            issuedBooks++;
            System.out.println(title + " issued successfully.");
        } else {
            System.out.println(title + " is already issued.");
        }
    }

    // Return book
    void returnBook() {
        if (isIssued) {
            isIssued = false;
            issuedBooks--;
            System.out.println(title + " returned successfully.");
        } else {
            System.out.println(title + " was not issued.");
        }
    }

    // Display book details
    void displayBook() {
        System.out.println("Title: " + title +
                ", Price: ₹" + price +
                ", Edition: " + edition +
                ", Issued: " + isIssued);
    }

    // Percentage of issued books
    static void issuedPercentage() {
        double percent = ((double) issuedBooks / totalBooks) * 100;
        System.out.println("Percentage of books issued: " + percent + "%");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {

        // Creating 10 books
        Book b1 = new Book("Java Programming", 450, 3);
        Book b2 = new Book("Data Structures", 550, 2);
        Book b3 = new Book("Operating Systems", 600, 4);
        Book b4 = new Book("DBMS", 500, 3);
        Book b5 = new Book("Computer Networks", 480, 2);
        Book b6 = new Book("Python Basics", 350, 1);
        Book b7 = new Book("AI Fundamentals", 700, 1);
        Book b8 = new Book("Software Engineering", 520, 3);
        Book b9 = new Book("Web Development", 400, 2);
        Book b10 = new Book("Cloud Computing", 650, 1);

        // Issue books
        b1.issueBook();
        b3.issueBook();
        b5.issueBook();
        b7.issueBook();

        // Return a book
        b3.returnBook();

        // Display issued percentage
        Book.issuedPercentage();
    }
}
