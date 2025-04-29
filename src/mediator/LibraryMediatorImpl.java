package mediator;

import chain_of_responsibility.*;
import factory.Book;
import observer.User;

public class LibraryMediatorImpl implements LibraryMediator {
    private Handler chainOfResponsibility;

    public LibraryMediatorImpl() {
        // Build the chain of responsibility
        Handler stockHandler = new StockHandler();
        Handler userLimitHandler = new UserLimitHandler();
        Handler notificationHandler = new NotificationHandler();
        stockHandler.setNext(userLimitHandler).setNext(notificationHandler);
        this.chainOfResponsibility = stockHandler;
    }

    @Override
    public boolean borrowBook(Book book, User user) {
        System.out.println("\n[Mediator] User \"" + user + "\" is trying to borrow the book \"" + book.getTitle() + "\".");
        if (chainOfResponsibility.handle(book, user)) {
            book.setAvailable(false); // Update book availability
            return true;
        }
        return false;
    }

    @Override
    public void returnBook(Book book, User user) {
        System.out.println("\n[Mediator] User \"" + user + "\" is returning the book \"" + book.getTitle() + "\".");
        book.setAvailable(true); // Update book availability

        // Access the nextHandler safely using the getter method
        Handler userLimitHandler = chainOfResponsibility.getNextHandler();
        if (userLimitHandler instanceof UserLimitHandler) {
            ((UserLimitHandler) userLimitHandler).returnBook(user); // Update user borrow count
        }
    }
}