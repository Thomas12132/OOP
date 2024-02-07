package test;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<Book>();
        users = new ArrayList<User>();
    }

    public boolean borrow(String name, String book_title) {
        User user = findByName(name);
        Book book = findByTitle(book_title);
        if (user == null || book == null) {
            return false;
        }
        if (book.getQuantity() == 0) {
            return false;
        }
        if ((book.onlyStaff() == true) && (user.isStaff() == false)) {
            return false;
        }
        user.add_book(book.getTitle());
        book.setQuantity(book.getQuantity() - 1);
        return true;
    }

    public boolean return_book(String name, String book_title) {
        User user = findByName(name);
        Book book = findByTitle(book_title);
        if (user == null || book == null) {
            return false;
        }
        if (user.delete_book(book.getTitle()) == false) {
            return false;
        }
        if ((book.onlyStaff() == true) && (user.isStaff() == false)) {
            return false;
        }
        book.setQuantity(book.getQuantity() + 1);
        return true;
    }

    private User findByName(String name) {

        for (int i = 0; i < this.users.size(); ++i) {
            if (this.users.get(i).getName().equals(name)) {
                return this.users.get(i);
            }
        }
        return null;
    }

    private Book findByTitle(String book_title) {
        for (int i = 0; i < this.books.size(); ++i) {
            if (this.books.get(i).getTitle().equals(book_title)) {
                return this.books.get(i);
            }
        }
        return null;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBook(Book book) {

        this.books.add(book);
    }

    public void setUser(User user) {
        this.users.add(user);
    }

}
