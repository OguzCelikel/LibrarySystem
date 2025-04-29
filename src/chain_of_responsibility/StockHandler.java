package chain_of_responsibility;

import factory.Book;
import observer.User;

public class StockHandler extends Handler {
    @Override
    public boolean handle(Book book, User user) {
        if (book.isAvailable()) {
            System.out.println("StockHandler: Book \"" + book.getTitle() + "\" is available.");
            if (nextHandler != null) {
                return nextHandler.handle(book, user);
            }
            return true;
        } else {
            System.out.println("StockHandler: Book \"" + book.getTitle() + "\" is not available.");
            return false;
        }
    }
}
