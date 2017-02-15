package tech.ceece.hw_1_214;


public class Student {
    //Data fields
    private String name;
    private int studentID;
    private int write_ups;

    //Constructors
    public Student(){
        //Empty constructor
    }

    public Student(String name, int studentID, int write_ups){
        this.name=name;
        this.studentID=studentID;
        this.write_ups=write_ups;
    }

    //Mutator
    public void setName(String name){
        this.name=name;
    }

    public void setID(int studentID){
        this.studentID=studentID;
    }

    public void setWrite_ups(int write_ups){
        this.write_ups=write_ups;
    }

    //Accessors
    public String getName(){
        return name;
    }
    public int getID(){
        return studentID;
    }
    public int getWrite_ups(){
        return write_ups;
    }

    //Clone Method
    public Object clone(){
        Student student = new Student();
        student.setID(this.studentID);
        student.setName(this.name);
        student.setWrite_ups(this.write_ups);
        return student;
    }
}
