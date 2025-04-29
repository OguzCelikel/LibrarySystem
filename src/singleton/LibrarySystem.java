package singleton;

import java.util.ArrayList;
import java.util.List;
import mediator.LibraryMediator;
import mediator.LibraryMediatorImpl;
import factory.Book;
import observer.User;

public class LibrarySystem {
    // Singleton instance
    private static LibrarySystem instance;

    // Data structures to store books and users
    private List<Book> books;
    private List<User> users;
    private LibraryMediator mediator;

    // Private constructor to prevent instantiation
    private LibrarySystem() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        mediator = new LibraryMediatorImpl(); // Initialize the mediator
    }

    // Public method to get the Singleton instance
    public static LibrarySystem getInstance() {
        if (instance == null) {
            synchronized (LibrarySystem.class) {
                if (instance == null) {
                    instance = new LibrarySystem();
                    System.out.println("LibrarySystem instance created.");
                }
            }
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book);
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("Added user: " + user);
    }
  /*
    // Method to add books
    public void addBook(String bookTitle) {
        books.add(bookTitle);
        System.out.println("Added book: " + bookTitle);
    }

    // Method to add users
    public void addUser(String userName) {
        users.add(userName);
        System.out.println("Added user: " + userName);
    }



    // Method to display books
    public void displayBooks() {
        System.out.println("Books in the Library:");
        for (String book : books) {
            System.out.println("- " + book);
        }
    }

    // Method to display users
    public void displayUsers() {
        System.out.println("Users in the Library:");
        for (String user : users) {
            System.out.println("- " + user);
        }
    }

     */

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public LibraryMediator getMediator() {
        return mediator;
    }
}