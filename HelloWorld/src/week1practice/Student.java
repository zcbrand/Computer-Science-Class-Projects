//Student.java
package week1practice;

public class Student extends Person {

    private double gpa;

    public Student(String firstName, String lastName, double gpa) {
        super(firstName, lastName);
        this.gpa = gpa;
    }

    public String toString() {
        return super.toString() + "\n\tGPA: " + gpa;
    }

    public void display() {
        System.out.println("<<Student>>" + this);
    }

}
