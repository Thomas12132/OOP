package test;

public class Staff extends User{
    public Staff(int id, String name, int group){
        super(id, name, group);
    }
    @Override
    public boolean isStaff(){
        return true;
    }
}
