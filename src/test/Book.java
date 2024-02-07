package test;

public class Book {
    private String title;
    private String genre;
    private String author;
    private int year;
    private int quantity;

    private boolean onlyStaff;
    public Book(String title, String genre, String author, int year, int quantity, boolean onlyStaff) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
        this.onlyStaff = onlyStaff;
    }
//availability
    public String getTitle() {
        return this.title;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getYear() {
        return this.year;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setQuantity(int new_value) {
        this.quantity = new_value;
    }

    public boolean onlyStaff(){return this.onlyStaff;}
}
