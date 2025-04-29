package chain_of_responsibility;

import factory.Book;
import observer.User;

import java.util.HashMap;
import java.util.Map;

public class UserLimitHandler extends Handler {
    private static final int MAX_BORROW_LIMIT = 3;
    private Map<User, Integer> userBorrowCount = new HashMap<>();

    @Override
    public boolean handle(Book book, User user) {
        int borrowedBooks = userBorrowCount.getOrDefault(user, 0);
        if (borrowedBooks < MAX_BORROW_LIMIT) {
            System.out.println("UserLimitHandler: User \"" + user + "\" can borrow the book.");
            userBorrowCount.put(user, borrowedBooks + 1);
            if (nextHandler != null) {
                return nextHandler.handle(book, user);
            }
            return true;
        } else {
            System.out.println("UserLimitHandler: User \"" + user + "\" has reached the borrow limit.");
            return false;
        }
    }

    public void returnBook(User user) {
        int borrowedBooks = userBorrowCount.getOrDefault(user, 0);
        if (borrowedBooks > 0) {
            userBorrowCount.put(user, borrowedBooks - 1);
        }
    }
}
