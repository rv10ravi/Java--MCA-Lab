// Defining a Printable interface
interface Printable {
    void printDetails();
}

// Defining a generic class Book
class Book<T, U, V, W> implements Printable {
    private T bookId;
    private U title;
    private V available;
    private W price;

    public Book(T bookId, U title, V available, W price) {
        this.bookId = bookId;
        this.title = title;
        this.available = available;
        this.price = price;
    }

    public T getBookId() {
        return bookId;
    }

    public U getTitle() {
        return title;
    }

    public V getavailable() {
        return available;
    }

    public W getPrice() {
        return price;
    }

    @Override
    public void printDetails() {
        System.out.println(
                "Book ID: " + bookId + ", Title: " + title + ", Available: " + available + ", Price: " + price);
    }
}

// Defining a BookStore class using generics
class BookStore<T, U, V, W> {
    private Book<T, U, V, W> book;

    public BookStore(Book<T, U, V, W> book) {
        this.book = book;
    }

    public void displayBookDetails() {
        System.out.println("Bookstore Details:");
        book.printDetails();
    }
}

public class Lab6 {
    public static void main(String[] args) {
        // Creating instances of Book with different data types
        Book<Integer, String, Boolean, Double> book1 = new Book<>(1, "Atomic Habits", true, 299.99);
        Book<Integer, String, Boolean, Double> book2 = new Book<>(2, "Think Like a Monk", false, 399.99);

        // Creating instances of BookStore
        BookStore<Integer, String, Boolean, Double> store1 = new BookStore<>(book1);
        BookStore<Integer, String, Boolean, Double> store2 = new BookStore<>(book2);

        // Display book details using BookStore
        store1.displayBookDetails();
        store2.displayBookDetails();
    }
}
