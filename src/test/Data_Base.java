package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Data_Base {

    public Connection connect_to_db(String dbname, String user_name,String pass){
        Connection conn = null;
        try{
        Class.forName("org.postgresql.Driver");
        conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user_name,pass);
        if(conn != null){
            System.out.println("Connection established");
        }
        else{
            System.out.println(("Connection failed"));
        }
    }catch (Exception e){
            System.out.println(e + "wrong");
        }
        return conn;
    }
    public void createTable(Connection conn, String table_name){
        Statement statement;
        try{
            String query = "create table "+ table_name + "(empid Serial,name varchar(32),grooup varchar(32),staff varchar(16),primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("User_table was added");
        }catch (Exception e){
            System.out.println(e + "something is wrong");
        }
    }

    public void insert_row(Connection conn, String table_name, String name, String grooup, String staff){
        Statement statement;
        try{
            String query = String.format("insert into %s(name,grooup,staff) values('%s','%s','%s');",table_name,name,grooup,staff);
            statement =conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data was added");
        }catch (Exception e){
            System.out.println(e + "Error");
        }
    }
    //******
    public void borrowed_table(Connection conn, String table_name){
        Statement statement;
        try{
            String query = "create table "+ table_name + "(empid Serial,name varchar(32),book varchar(32),primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("User_table was added");
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public void booking(Connection conn, String table_name, String name, String book){
        Statement statement;
        try{
            String query = String.format("insert into %s(name,book) values('%s','%s');",table_name,name,book);
            statement =conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data was added");
        }catch (Exception e){
            System.out.println(e + "Error");
        }
    }
}
