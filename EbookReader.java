import java.io.*;
import java.util.ArrayList;

/**
 * @author Benjamin Acosta
 * @version 1.1
 * Dr. Nguyen
 * Data Structures and Algorithms Section 01
 * P2.33
 * The problem is to create a class that simulates an e-book reading system that allows users 
 * to buy, view, and read books. The system keeps track of purchased books and allows users 
 * to resume reading from where they left off. It loads and saves books from/to serialized files.
 * 
 * Algorithm for EbookReader:
 *  1. Initialize a list of available books and a list of purchased books.
 *  2. Load available books from hardcoded data.
 *  3. Load purchased books and the current reading book from serialized files.
 *  4. Allow users to buy books, ensuring they can't buy a book they've already purchased.
 *  5. Allow users to view available and purchased books.
 *  6. Allow users to start reading a book and resume reading a previously started book.
 *  7. Save purchased books and the current reading book to serialized files before exiting.
 * 
 * @param availableBooks List of available books to buy.
 * @param purchasedBooks List of books that the user has purchased.
 * @param currentReadingBook The book the user is currently reading.
 */
public class EbookReader {
    private ArrayList<Book> availableBooks;  // List of available books
    private ArrayList<Book> purchasedBooks;  // List of books the user has purchased
    private Book currentReadingBook;         // The book that is currently being read

    private static final String PURCHASED_BOOKS_FILE = "purchasedBooks.ser";
    private static final String CURRENT_READING_FILE = "currentReadingBook.ser";

    /**
     * Constructor for the EbookReader class. Initializes the lists for available and 
     * purchased books, and loads the saved data from files.
     */
    public EbookReader() {
        availableBooks = new ArrayList<>();
        purchasedBooks = new ArrayList<>();
        loadPurchasedBooks();
        loadCurrentReadingBook();
        loadAvailableBooks();
    }

    /**
     * Loads the list of available books. In this case, books are hardcoded.
     */
    private void loadAvailableBooks() {
        // Add available books to the list (hardcoded for simplicity)
        availableBooks.add(new Book("Northanger Abbey", "Austen, Jane", 1814, "Penguin", 18.2));
        availableBooks.add(new Book("War and Peace", "Tolstoy, Leo", 1865, "Penguin", 12.7));
        availableBooks.add(new Book("Anna Karenina", "Tolstoy, Leo", 1875, "Penguin", 13.5));
        availableBooks.add(new Book("Mrs. Dalloway", "Woolf, Virginia", 1925, "Harcourt Brace", 25));
        availableBooks.add(new Book("The Hours", "Cunningham, Michael", 1999, "Harcourt Brace", 12.35));
        availableBooks.add(new Book("Huckleberry Finn", "Twain, Mark", 1865, "Penguin", 5.76));
        availableBooks.add(new Book("Bleak House", "Dickens, Charles", 1870, "Random House", 5.75));
        availableBooks.add(new Book("Tom Sawyer", "Twain, Mark", 1862, "Random House", 7.75));
        availableBooks.add(new Book("A Room of One's Own", "Woolf, Virginia", 1922, "Penguin", 29));
        availableBooks.add(new Book("Harry Potter", "Rowling, J.K.", 2000, "Harcourt Brace", 19.95));
        availableBooks.add(new Book("One Hundred Years of Solitude", "Marquez", 1967, "Harper Perennial", 14.00));
        availableBooks.add(new Book("Hamlet, Prince of Denmark", "Shakespeare", 1603, "Signet Classics", 7.95));
        availableBooks.add(new Book("Lord of the Rings", "Tolkien, J.R.", 1937, "Penguin", 27.45));
    }

    /**
     * Loads the purchased books from a serialized file.
     */
    @SuppressWarnings("unchecked")
    private void loadPurchasedBooks() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PURCHASED_BOOKS_FILE))) {
            purchasedBooks = (ArrayList<Book>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            purchasedBooks = new ArrayList<>();
        }
    }

    /**
     * Loads the current book being read from a serialized file.
     */
    @SuppressWarnings("unchecked")
    private void loadCurrentReadingBook() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(CURRENT_READING_FILE))) {
            currentReadingBook = (Book) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            currentReadingBook = null;
        }
    }

    /**
     * Saves the list of purchased books to a serialized file.
     */
    private void savePurchasedBooks() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PURCHASED_BOOKS_FILE))) {
            out.writeObject(purchasedBooks);
        } catch (IOException e) {
            System.out.println("Error saving purchased books: " + e.getMessage());
        }
    }

    /**
     * Saves the current book being read to a serialized file.
     */
    private void saveCurrentReadingBook() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CURRENT_READING_FILE))) {
            out.writeObject(currentReadingBook);
        } catch (IOException e) {
            System.out.println("Error saving current reading book: " + e.getMessage());
        }
    }

    /**
     * Buys a book from the list of available books, provided it has not already been purchased.
     * 
     * @param bookIndex The index of the book to buy.
     */
    public void buyBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < availableBooks.size()) {
            Book book = availableBooks.get(bookIndex);
            if (!purchasedBooks.contains(book)) {
                purchasedBooks.add(book);
                System.out.println("You have successfully purchased: " + book.getTitle());
                savePurchasedBooks();
            } else {
                System.out.println("You already own this book.");
            }
        } else {
            System.out.println("Invalid book selection.");
        }
    }

    /**
     * Displays the list of available books.
     */
    public void displayAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (int i = 0; i < availableBooks.size(); i++) {
            Book book = availableBooks.get(i);
            System.out.printf("%d. %-30s %-20s %-10d %-20s $%.2f%n", i + 1, book.getTitle(), book.getAuthor(),
                    book.getYearWritten(), book.getEdition(), book.getPrice());
        }
    }

    /**
     * Displays the list of purchased books.
     */
    public void displayPurchasedBooks() {
        System.out.println("\nPurchased Books:");
        for (int i = 0; i < purchasedBooks.size(); i++) {
            Book book = purchasedBooks.get(i);
            System.out.printf("%d. %-30s %-20s %-10d %-20s $%.2f%n", i + 1, book.getTitle(), book.getAuthor(),
                    book.getYearWritten(), book.getEdition(), book.getPrice());
        }
    }

    /**
     * Starts reading a book from the purchased books list.
     * 
     * @param bookIndex The index of the book to start reading.
     */
    public void readBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < purchasedBooks.size()) {
            currentReadingBook = purchasedBooks.get(bookIndex);
            System.out.println("You are now reading: " + currentReadingBook.getTitle());
            saveCurrentReadingBook();
        } else {
            System.out.println("Invalid book selection.");
        }
    }

    /**
     * Resumes reading the last book that was opened.
     */
    public void resumeReading() {
        if (currentReadingBook != null) {
            System.out.println("Resuming reading: " + currentReadingBook.getTitle());
        } else {
            System.out.println("No book is currently being read.");
        }
    }

    /**
     * Returns the current book being read.
     * 
     * @return The current reading book.
     */
    public Book getCurrentReadingBook() {
        return currentReadingBook;
    }
}
