import chain_of_responsibility.Handler;
import chain_of_responsibility.NotificationHandler;
import chain_of_responsibility.StockHandler;
import chain_of_responsibility.UserLimitHandler;
import observer.User;
import singleton.LibrarySystem;
import factory.*;
public class Main {
    public static void main(String[] args) {
        /*
        // Get the Singleton instance
        LibrarySystem library = LibrarySystem.getInstance();

        // Add books
        library.addBook("The Catcher in the Rye");
        library.addBook("To Kill a Mockingbird");

        // Add users
        library.addUser("Alice");
        library.addUser("Bob");

        // Display books and users
        library.displayBooks();
        library.displayUsers();

        // Verify Singleton behavior
        LibrarySystem anotherLibrary = LibrarySystem.getInstance();
        System.out.println("Are both instances the same? " + (library == anotherLibrary));



        LibrarySystem library = LibrarySystem.getInstance();

        // Factory Method
        BookFactory fictionFactory = new BookFactory() {
            @Override
            public Book createBook(String title) {
                return new FictionBook(title);
            }
        };

        BookFactory scienceFactory = new BookFactory() {
            @Override
            public Book createBook(String title) {
                return new ScienceBook(title);
            }
        };
        BookFactory historyFactory = new BookFactory() {
            @Override
            public Book createBook(String title) {
                return new HistoryBook(title);
            }
        };

        */

        /*
        // Create books
        Book book1 = fictionFactory.createBook("The Great Gatsby");
        //Book book2 = scienceFactory.createBook("A Brief History of Time");
        //Book book3 = historyFactory.createBook("Sapiens");

        // Add books to library
        library.addBook(book1.toString());
        //library.addBook(book2.toString());
        //library.addBook(book3.toString());

        // Display books in the library
        library.displayBooks();

        // Create users
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        // Add users as observers to the book
        book1.addObserver(user1);
        book1.addObserver(user2);


        // Change book availability and notify observers
        System.out.println("\nBorrowing the book...");
        book1.setAvailable(false);

        System.out.println("\nReturning the book...");
        book1.setAvailable(true);

         */



        /*
        // Singleton instance
        LibrarySystem library = LibrarySystem.getInstance();

        // Factory Method
        BookFactory fictionFactory = new BookFactory() {
            @Override
            public Book createBook(String title) {
                return new FictionBook(title);
            }
        };

        // Create books
        Book book1 = fictionFactory.createBook("The Great Gatsby");
        library.addBook(book1.toString());

        // Create users
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        // Add users as observers to the book
        book1.addObserver(user1);
        book1.addObserver(user2);

        // Build the chain of responsibility
        Handler stockHandler = new StockHandler();
        Handler userLimitHandler = new UserLimitHandler();
        Handler notificationHandler = new NotificationHandler();

        stockHandler.setNext(userLimitHandler).setNext(notificationHandler);

        // Simulate borrowing process
        System.out.println("\nBorrowing process for Alice:");
        if (stockHandler.handle(book1, user1)) {
            book1.setAvailable(false); // Update book availability
        }

        // Simulate returning process
        System.out.println("\nReturning process for Alice:");
        book1.setAvailable(true); // Update book availability
        ((UserLimitHandler) userLimitHandler).returnBook(user1); // Update user borrow count

         */

        // Get the Singleton instance
        LibrarySystem library = LibrarySystem.getInstance();

        // Factory Method
        BookFactory fictionFactory = new BookFactory() {
            @Override
            public Book createBook(String title) {
                return new FictionBook(title);
            }
        };

        // Create books
        Book book1 = fictionFactory.createBook("The Great Gatsby");
        library.addBook(book1);

        // Create users
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        library.addUser(user1);
        library.addUser(user2);

        // Add users as observers to the book
        book1.addObserver(user1);
        book1.addObserver(user2);

        // Borrow and return books through the mediator
        System.out.println("\n=== Mediator Pattern Test ===");
        library.getMediator().borrowBook(book1, user1);
        library.getMediator().returnBook(book1, user1);
    }
}