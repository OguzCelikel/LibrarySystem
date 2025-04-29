package observer;

public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("User \"" + name + "\" has been notified of a book status change!");
    }

    @Override
    public String toString() {
        return name;
    }
}