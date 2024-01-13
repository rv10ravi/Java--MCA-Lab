import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Price: " + price;
    }
}

class BookstoreGUI extends JFrame {
    private List<Book> books;

    private JTextField titleField;
    private JTextField authorField;
    private JTextField priceField;
    private JTextArea displayArea;

    public BookstoreGUI() {
        super("Bookstore Application");

        books = new ArrayList<>();

        setLayout(new FlowLayout());

        titleField = new JTextField(20);
        authorField = new JTextField(20);
        priceField = new JTextField(10);
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        JButton addButton = new JButton("Add Book");
        JButton displayButton = new JButton("Display Books");
        JButton exitButton = new JButton("Exit");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBooks();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(new JLabel("Title: "));
        add(titleField);
        add(new JLabel("Author: "));
        add(authorField);
        add(new JLabel("Price: "));
        add(priceField);
        add(addButton);
        add(displayButton);
        add(exitButton);
        add(new JScrollPane(displayArea));

        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        double price = Double.parseDouble(priceField.getText());

        Book newBook = new Book(title, author, price);
        books.add(newBook);

        titleField.setText("");
        authorField.setText("");
        priceField.setText("");

        JOptionPane.showMessageDialog(this, "Book added successfully!");
    }

    private void displayBooks() {
        displayArea.setText("");
        if (books.isEmpty()) {
            displayArea.setText("No books available.");
        } else {
            for (Book book : books) {
                displayArea.append(book.toString() + "\n");
            }
        }
    }
}

public class Lab9 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BookstoreGUI();
            }
        });
    }
}
