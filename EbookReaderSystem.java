import java.util.Scanner;

/**
 * @author Benjamin Acosta
 * @version 1.1
 * Dr. Nguyen
 * Data Structures and Algorithms Section 01
 * P2.33
 * The problem is to create a user interface that interacts with the EbookReader system.
 * This class provides options for users to browse available books, buy books, view purchased 
 * books, start reading books, and resume reading the last book.
 * 
 * Algorithm for EbookReaderSystem:
 *  1. Create an instance of EbookReader to interact with the e-book system.
 *  2. Display the main menu with options: view available books, buy a book, view purchased books, 
 *     read a book, resume reading, and exit.
 *  3. Continuously prompt the user to select an option from the menu.
 *  4. Perform the corresponding action based on the user's selection:
 *     - View available books.
 *     - Buy a book (if the user selects an available book).
 *     - View purchased books.
 *     - Start reading a purchased book.
 *     - Resume reading the last book.
 *  5. Exit the program with a goodbye message.
 * 
 * @param args Command-line arguments (not used in this program).
 */
public class EbookReaderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object for reading user input.
        EbookReader ebookReader = new EbookReader(); // Instance of the EbookReader class.

        while (true) {
            // Display the main menu.
            System.out.println("\nE-Book Reader System");
            System.out.println("1. View Available Books");
            System.out.println("2. Buy a Book");
            System.out.println("3. View Purchased Books");
            System.out.println("4. Read a Book");
            System.out.println("5. Resume Reading");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            // Read the user's menu choice.
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Display all available books.
                    ebookReader.displayAvailableBooks();
                    break;

                case 2:
                    // Display available books and allow the user to purchase one.
                    ebookReader.displayAvailableBooks();
                    System.out.print("Enter the number of the book you want to buy: ");
                    int bookToBuy = scanner.nextInt();
                    ebookReader.buyBook(bookToBuy - 1);  // Adjust index for 0-based array
                    break;

                case 3:
                    // Display the list of purchased books.
                    ebookReader.displayPurchasedBooks();
                    break;

                case 4:
                    // Display purchased books and allow the user to read one.
                    ebookReader.displayPurchasedBooks();
                    System.out.print("Enter the number of the book you want to read: ");
                    int bookToRead = scanner.nextInt();
                    ebookReader.readBook(bookToRead - 1);  // Adjust index for 0-based array
                    break;

                case 5:
                    // Display purchased books and allow the user to select one to resume reading.
                    ebookReader.displayPurchasedBooks();
                    System.out.print("Enter the number of the book you want to resume reading: ");
                    int bookToResume = scanner.nextInt();
                    ebookReader.readBook(bookToResume - 1);  // Adjust index for 0-based array
                    ebookReader.resumeReading();
                    break;

                case 6:
                    // Exit the program with a goodbye message.
                    System.out.println("Thank you for using the E-Book Reader System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    // Handle invalid menu options.
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
