package chain_of_responsibility;

import factory.Book;
import observer.User;

public class NotificationHandler extends Handler {
    @Override
    public boolean handle(Book book, User user) {
        System.out.println("NotificationHandler: Notifying user \"" + user + "\" about the book \"" + book.getTitle() + "\".");
        if (nextHandler != null) {
            return nextHandler.handle(book, user);
        }
        return true;
    }
}
