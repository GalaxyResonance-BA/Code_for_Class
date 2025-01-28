import java.io.Serializable;

/**
 * @author Benjamin Acosta
 * @version 1.1
 * Dr. Nguyen
 * Data Structures and Algorithms Section 01
 * P2.33
 * The problem is to create a class that represents a book with attributes such as title, 
 * author, year written, edition, and price. The class provides methods to access and 
 * modify these attributes. It also overrides the equals() method to compare two books 
 * based on title and author, and the toString() method to represent the book as a string.
 * 
 * Algorithm for Book:
 *  1. Define private attributes for the book's title, author, year written, edition, and price.
 *  2. Create a constructor that initializes these attributes.
 *  3. Provide getter methods for each attribute.
 *  4. Override the equals() method to compare two books based on title and author.
 *  5. Override the toString() method to return a string representation of the book.
 * 
 * @param title The title of the book.
 * @param author The author of the book.
 * @param yearWritten The year the book was written.
 * @param edition The edition of the book.
 * @param price The price of the book.
 */
public class Book implements Serializable {
    private String title;         // Title of the book
    private String author;        // Author of the book
    private int yearWritten;      // Year the book was written
    private String edition;       // Edition of the book
    private double price;         // Price of the book

    /**
     * Constructor for the Book class that initializes all the attributes.
     *
     * @param title The title of the book.
     * @param author The author of the book.
     * @param yearWritten The year the book was written.
     * @param edition The edition of the book.
     * @param price The price of the book.
     */
    public Book(String title, String author, int yearWritten, String edition, double price) {
        this.title = title;
        this.author = author;
        this.yearWritten = yearWritten;
        this.edition = edition;
        this.price = price;
    }

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the year the book was written.
     *
     * @return The year the book was written.
     */
    public int getYearWritten() {
        return yearWritten;
    }

    /**
     * Gets the edition of the book.
     *
     * @return The edition of the book.
     */
    public String getEdition() {
        return edition;
    }

    /**
     * Gets the price of the book.
     *
     * @return The price of the book.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Checks if two books are equal based on their title and author.
     *
     * @param obj The object to compare to.
     * @return True if the books are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }

    /**
     * Returns a string representation of the book, including its title and author.
     *
     * @return A string representation of the book.
     */
    @Override
    public String toString() {
        return title + " by " + author;
    }
}
