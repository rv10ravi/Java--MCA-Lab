class Bookstore {
    public synchronized void sellBook(String bookName) {
        System.out.println("Selling book: " + bookName);

        // Generate bill
        double price = calculatePrice(bookName);

        // Apply discount
        applyDiscount(bookName);

        // Final price after discount
        price -= (price * calculateDiscount(bookName));

        System.out.println("Bill generated for " + bookName + ": " + price);
    }

    private double calculatePrice(String bookName) {
        double price = 0.0;

        if (bookName.equals("Book 1")) {
            price = 150;
        } else if (bookName.equals("Book 2")) {
            price = 200;
        } else if (bookName.equals("Book 3")) {
            price = 120;
        } else if (bookName.equals("Book 4")) {
            price = 180;
        } else if (bookName.equals("Book 5")) {
            price = 250;
        }

        return price;
    }

    private double calculateDiscount(String bookName) {
        double discount = 0.0;

        if (bookName.equals("Book 1")) {
            discount = 0.1;
        } else if (bookName.equals("Book 2")) {
            discount = 0.15;
        } else if (bookName.equals("Book 3")) {
            discount = 0.2;
        } else if (bookName.equals("Book 4")) {
            discount = 0.12;
        } else if (bookName.equals("Book 5")) {
            discount = 0.18;
        }

        return discount;
    }

    public void applyDiscount(String bookName) {
        double discount = 0.0;

        if (bookName.equals("Book 1")) {
            discount = 0.1;
        } else if (bookName.equals("Book 2")) {
            discount = 0.15;
        } else if (bookName.equals("Book 3")) {
            discount = 0.2;
        } else if (bookName.equals("Book 4")) {
            discount = 0.12;
        } else if (bookName.equals("Book 5")) {
            discount = 0.18;
        }

        System.out.println("Discount applied for " + bookName + ": " + discount * 100 + "%");
    }
}

class Customer implements Runnable {
    private String bookName;
    private Bookstore bookstore;

    public Customer(String bookName, Bookstore bookstore) {
        this.bookName = bookName;
        this.bookstore = bookstore;
    }

    @Override
    public void run() {
        bookstore.sellBook(bookName);
    }
}

public class Lab5 {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();

        // Create multiple customers
        Customer customer1 = new Customer("Book 1", bookstore);
        Customer customer2 = new Customer("Book 2", bookstore);
        Customer customer3 = new Customer("Book 3", bookstore);
        Customer customer4 = new Customer("Book 4", bookstore);
        Customer customer5 = new Customer("Book 5", bookstore);

        // Start customers in separate threads with priorities
        Thread thread1 = new Thread(customer1);
        Thread thread2 = new Thread(customer2);
        Thread thread3 = new Thread(customer3);
        Thread thread4 = new Thread(customer4);
        Thread thread5 = new Thread(customer5);

        // Set priorities
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.NORM_PRIORITY);
        thread4.setPriority(Thread.MIN_PRIORITY);
        thread5.setPriority(Thread.MIN_PRIORITY);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
