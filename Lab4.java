import java.util.ArrayList;
import java.util.List;

// Interface for basic book functionality
interface Book {
    void displayInfo();
}

// Interface for books with authors
interface Authored {
    void setAuthor(String author);

    void viewAuthor();
}

// Interface for managing book inventory
interface BookInventory {
    void addBook(Book book);

    void displayAllBooks();
}

// Book class implementing the Book and Authored interfaces
class BookImpl implements Book, Authored {
    private String title;
    private String author;

    public BookImpl(String title) {
        this.title = title;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void viewAuthor() {
        System.out.println("Author: " + author);
    }

    @Override
    public void displayInfo() {
        System.out.println("Title: " + title);
        viewAuthor();
    }
}

// BookInventoryManager class implementing the BookInventory interface
class BookInventoryManager implements BookInventory {
    private List<Book> books;

    public BookInventoryManager() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void displayAllBooks() {
        System.out.println("---- All Books in Inventory ----");
        for (Book book : books) {
            book.displayInfo();
            System.out.println("-----------------------------");
        }
    }
}

// class to demonstrate the usage
public class Lab4 {
    public static void main(String[] args) {
        BookInventoryManager inventoryManager = new BookInventoryManager();

        BookImpl book1 = new BookImpl("The Great Gatsby");
        book1.setAuthor("F. Scott Fitzgerald");

        BookImpl book2 = new BookImpl("To Kill a Mockingbird");
        book2.setAuthor("Harper Lee");

        inventoryManager.addBook(book1);
        inventoryManager.addBook(book2);

        inventoryManager.displayAllBooks();
    }
}