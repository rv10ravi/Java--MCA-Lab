import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}

public class Lab7 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Atomic", "Makeum", 400.99));
        books.add(new Book("Power", "Ravindra", 650.99));
        books.add(new Book("Mental_Health", "Jain", 720.99));
        books.add(new Book("Sapiens", "Ravi", 720.99));
        books.add(new Book("Time", "Anuiket", 720.99));

        // Sorting books by title using Lambda expression
        books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));

        // Filtering books by author using Lambda expression
        List<Book> filteredBooks = new ArrayList<>();
        books.forEach(book -> {
            if (book.getAuthor().equals("Jain")) {
                filteredBooks.add(book);
            }
        });

        // Calculating the total price of books using Lambda expression
        double totalPrice = books.stream()
                .mapToDouble(Book::getPrice)
                .sum();

        // Printing the sorted books
        System.out.println("Sorted Books:");
        books.forEach(book -> System.out.println(book.getTitle()));

        // Printing the filtered books
        System.out.println("\nFiltered Books:");
        filteredBooks.forEach(book -> System.out.println(book.getTitle()));

        // Printing the total price of books
        System.out.println("\nTotal Price: " + totalPrice);
    }
}
