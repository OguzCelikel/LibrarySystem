package mediator;

import factory.Book;
import observer.User;

public interface LibraryMediator {
    boolean borrowBook(Book book, User user);
    void returnBook(Book book, User user);
}
