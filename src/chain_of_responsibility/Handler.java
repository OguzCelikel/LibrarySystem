package chain_of_responsibility;

import factory.Book;
import observer.User;


public abstract class Handler {
    protected Handler nextHandler;

    // Set the next handler in the chain
    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        return handler;
    }

    // Public getter for nextHandler
    public Handler getNextHandler() {
        return nextHandler;
    }

    // Abstract method to handle the request
    public abstract boolean handle(Book book, User user);
}
