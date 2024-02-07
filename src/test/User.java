package test;
import java.util.*;
public abstract class User {
    private int id;
    private String name;
    private int group;
    ArrayList<String> borrowed_books;


    public User(int id, String name, int group) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.borrowed_books = new ArrayList<String>();
    }

    public void add_book(String title) {
        this.borrowed_books.add(title);
    }

    public boolean delete_book(String title) {
        if (!this.borrowed_books.contains(title)) {
            return false;
        }
        this.borrowed_books.remove(title);
        return true;
    }

    public String getName() {
        return this.name;
    }

    public abstract boolean isStaff();
}