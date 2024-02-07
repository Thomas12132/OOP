package test;

import java.sql.*;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Library library = new Library();
        Data_Base db = new Data_Base();
        Connection conn = db.connect_to_db("Librarytask3","postgres","3490");
        db.borrowed_table(conn,"user_table1");



        System.out.println("Welcome to the Library!");
        while (true) {
            System.out.println("LIST OF INSTRUCTION:");
            System.out.println("If you want to add a new book to the library, please enter 1");
            System.out.println("If you want to add a new user to the library, please enter 2");
            System.out.println("If you want to borrow a new book, please enter 3");
            System.out.println("If you want to return the book, please enter 4");
            System.out.println("If you want to show all the books in the library, please enter 5");


            String action = in.next();
            String name;
            String book_title;
            switch (action) {
                case "1":
                    System.out.println("the title of the book:");
                    String title = in.next();
                    System.out.println("the genre of the book:");
                    String genre = in.next();
                    System.out.println("the author of the book:");
                    String author = in.next();
                    System.out.println("the year of the book(integer):");
                    int year = in.nextInt();
                    System.out.println("quantity(integer):");
                    int quantity = in.nextInt();
                    System.out.println("only for staff?(0 / 1)");
                    int onlyStaff = in.nextInt();
                    Book book = new Book(title, genre, author, year, quantity, (onlyStaff == 1));




                    library.setBook(book);
                    System.out.println("Added");
                    break;
                case "2":
                    System.out.println("the id of the user(integer):");
                    int id = in.nextInt();
                    System.out.println("the name of the user:");
                    name = in.next();
                    System.out.println("the group of the user(integer):");
                    int group = in.nextInt();
                    System.out.println("Stuff?(1 / 0)");
                    int isStuff = in.nextInt();
                    if (isStuff == 1) {
                        Staff stuff = new Staff(id, name, group);
                        library.setUser(stuff);
                    } else {
                        Student student = new Student(id, name, group);
                        library.setUser(student);
                    }
                    System.out.println("Added");
                    String group_1 = String.valueOf(group);
                    String Stuff = String.valueOf(isStuff);
                    db.insert_row(conn,"user_table2",name,group_1, Stuff);
                    break;
                case "3":
                    System.out.println("the name of the user:");
                    name = in.next();
                    System.out.println("the title of the book:");
                    book_title = in.next();
                    if (library.borrow(name, book_title) == true) {
                        System.out.println("successful");
                        db.booking(conn,"user_table2",name,book_title);
                    } else {
                        System.out.println("ERROR");
                    }
                    break;
                case "4":
                    System.out.println("the name of the user:");
                    name = in.next();
                    System.out.println("the name of the book:");
                    book_title = in.next();
                    if (library.return_book(name, book_title)) {
                        System.out.println("successful");
                    } else {
                        System.out.println("ERROR");
                    }
                    break;
                case "5":
                    ArrayList<Book> books = library.getBooks();
                    for (Book b : books) {
                        System.out.println("book \"" + b.getTitle() + "\" by \"" + b.getAuthor() + "\" genre:\"" + b.getGenre() + "\" year:\"" + b.getYear() + "\" quantity:\"" + b.getQuantity() + "\"" + "\" only for staff:\"" + b.onlyStaff() + "\"");
                    }
                    break;
                default:
                    System.out.println("INCORRECT INPUT");
                    break;
            }
        }
    }
}






