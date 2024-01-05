public class Lab3BookStore {
    // Outer class properties
    private String name;
    private String location;

    // Constructor for the outer class
    public Lab3BookStore(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Nested class representing a Book
    public class Book {
        // Inner class properties
        private String title;
        private String author;
        private int price;

        // Constructor for the inner class
        public Book(String title, String author, int price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        // Display book information
        public void displayBookInfo() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Price: " + price);
        }
    }

    // Nested class representing Book Inventory using StringBuffer
    public class BookInventory {
        private StringBuffer inventory;

        // Constructor for the inner class
        public BookInventory() {
            inventory = new StringBuffer();
        }

        // Add a book to the inventory
        public void addBookToInventory(Book book) {
            inventory.append("Title: ").append(book.title).append("\n");
            inventory.append("Author: ").append(book.author).append("\n");
            inventory.append("Price: ").append(book.price).append("\n\n");
        }

        // Display the book inventory
        public void displayInventory() {
            System.out.println("Book Inventory for " + name + " at " + location + ":\n" + inventory.toString());
        }
    }

    // Nested class representing a Book Order
    public class BookOrder {
        private Book book;
        private int quantity;

        // Constructor for the inner class
        public BookOrder(Book book, int quantity) {
            this.book = book;
            this.quantity = quantity;
        }

        // Display book order information
        public void displayOrderInfo() {
            System.out.println("Order for " + quantity + " copies of the book:");
            book.displayBookInfo();
        }
    }

    // Main method to demonstrate the bookstore functionality
    public static void main(String[] args) {
        // Create a Bookstore
        Lab3BookStore myBookstore = new Lab3BookStore("Awesome Books", "123 Main Street");

        // Create books and add them to the inventory
        Lab3BookStore.Book book1 = myBookstore.new Book("The Catcher in the Rye", "J.D. Salinger", 699);
        Lab3BookStore.Book book2 = myBookstore.new Book("To Kill a Mockingbird", "Harper Lee", 499);

        // Add books to the inventory
        Lab3BookStore.BookInventory inventory = myBookstore.new BookInventory();
        inventory.addBookToInventory(book1);
        inventory.addBookToInventory(book2);

        // Create a book order
        Lab3BookStore.BookOrder order = myBookstore.new BookOrder(book1, 3);

        // Display book information, inventory, and order
        System.out.println("Book Information:");
        book1.displayBookInfo();
        System.out.println("\n");
        book2.displayBookInfo();
        System.out.println("\n");

        inventory.displayInventory();

        System.out.println("Book Order Information:");
        order.displayOrderInfo();
    }
}
