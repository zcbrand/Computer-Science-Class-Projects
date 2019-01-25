/* Filename: Employee.jave
 * Author: Zachary Brandenburg
 * Date: 23 January 2019
 * Purpose:
 */
package projectone;

public class Employee {
    // Declare class variables 
    private Name name;
    private double monthlySalary;
    
    // Default employee constructor
    public Employee() {
        name = new Name("John", "Doe");
        monthlySalary = 4_000;
    }
    
    /* Employee constructor acceptinf a Name calss and double consisting of a 
    *  monthly salary 
    */
    public Employee(Name name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }
    
    // Calculate an employees monthly salary and return as a double
    public double annualSalary() {
        return monthlySalary * 12;
    }
    
    // To string method
    public String toString() {
        return name + "\n\tMonthly Salary: " + monthlySalary;
    }
    
    public void display() {
        System.out.print("<<Employee>>" + this);
    }
}
