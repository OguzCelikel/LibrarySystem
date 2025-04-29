import observer.User;
import singleton.LibrarySystem;
import factory.*;
public class Main {
    public static void main(String[] args) {
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
        System.out.println("Books in the library: \n" + library.getBooks());

        // Create users
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        library.addUser(user1);
        library.addUser(user2);
        System.out.println("Registed users in the library: \n"+library.getUsers());

        // Add users as observers to the book
        book1.addObserver(user1);
        book1.addObserver(user2);

        // Borrow and return books through the mediator
        System.out.println("\n=== Mediator Pattern Test ===");
        library.getMediator().borrowBook(book1, user1);
        library.getMediator().returnBook(book1, user1);
    }
}