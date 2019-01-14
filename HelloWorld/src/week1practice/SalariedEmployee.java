// SalariedEmployee.java
package week1practice;

public class SalariedEmployee extends Employee {
    private double salary;
    public SalariedEmployee(String firstName, String lastName, double salary){
        super(firstName, lastName);
        this.salary = salary;
    }
    public void issueRaise(double percentage){
        salary += salary * percentage;
    }
    public double calculateEarnings(){
        return salary;
    }
    public void display(){
        System.out.println("<<Salaried Employee>>" + this + " per year");
    }
}
