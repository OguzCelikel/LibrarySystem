package factory;

import observer.Observable;

public abstract class Book extends Observable {
    private String title;
    private String genre;
    private boolean isAvailable; // with observable

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Update availability and notify observers
    public void setAvailable(boolean available) {
        this.isAvailable = available;
        System.out.println("Book \"" + title + "\" is now " + (available ? "available." : "unavailable."));
        // Notify all observers about the availability change
        notifyObservers();
    }

    @Override
    public String toString() {
        return title + " (" + genre + ")";
    }
}