package test;
import java.util.*;
class Student extends User{
    public Student(int id, String name, int group){
        super(id, name, group);
    }
    @Override
    public boolean isStaff(){
        return false;
    }
}