// Base class for books
class Book {
    private String title;
    private String author;
    private double price;

    // Default constructor
    public Book() {
        title = "";
        author = "";
        price = 0.0;
    }

    // Constructor with data members
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book information
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + String.format("%.2f", price));
    }
}

// Subclass for fiction books
class FictionBook extends Book {
    private String genre;

    // Constructor overloading
    public FictionBook() {
        super();
        genre = "";
    }

    public FictionBook(String title, String author, double price, String genre) {
        super(title, author, price);
        this.genre = genre;
    }

    // Method overloading
    public void displayInfo(boolean includeGenre) {
        super.displayInfo();
        if (includeGenre) {
            System.out.println("Genre: " + genre);
        }
    }
}

// Subclass for non-fiction books
class NonFictionBook extends Book {
    private String subject;

    // Constructor overloading
    public NonFictionBook() {
        super();
        subject = "";
    }

    public NonFictionBook(String title, String author, double price, String subject) {
        super(title, author, price);
        this.subject = subject;
    }

    // Method overloading
    public void displayInfo(boolean includeSubject) {
        super.displayInfo();
        if (includeSubject) {
            System.out.println("Subject: " + subject);
        }
    }
}

// Subclass for textbooks
class Textbook extends Book {
    private String subject;
    private String edition;

    // Constructor overloading
    public Textbook() {
        super();
        subject = "";
        edition = "";
    }

    public Textbook(String title, String author, double price, String subject, String edition) {
        super(title, author, price);
        this.subject = subject;
        this.edition = edition;
    }

    // Method to display textbook information with edition
    public void displayInfoWithEdition() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
    }
}

public class BookStore1 {
    public static void main(String[] args) {
        Book book1 = new Book("Atmoic Habits", "James Clear", 235.50);
        FictionBook fictionBook = new FictionBook("Pride and Prejudice", " Jane Austen", 250.99, "Classic");
        NonFictionBook nonFictionBook = new NonFictionBook("Sapiens", "Yuval Noah Harari", 540.99, "History");
        Textbook textbook = new Textbook("Introduction to Java", "John Smith", 790.99, "Computer Science",
                "2nd Edition");

        System.out.println("Book:");
        book1.displayInfo();

        System.out.println("\nFiction Book:");
        fictionBook.displayInfo(true);

        System.out.println("\nNon-Fiction Book:");
        nonFictionBook.displayInfo(true);

        System.out.println("\nTextbook:");
        textbook.displayInfoWithEdition();
    }
}
