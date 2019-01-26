/* Filename: Employee.java
 * Author: Zachary Brandenburg
 * Date: 23 January 2019
 * Purpose:
 */
package projectone;

import java.text.DecimalFormat;

public class Employee {
    // Declare class variables 
    private Name name;
    private double monthlySalary;
    // Protected formatter for formatting dollar amounts
    protected static DecimalFormat formatter = new DecimalFormat("$0.00");
    
    // Default employee constructor
    public Employee() {
        name = new Name(" ", " ");
        monthlySalary = 0;
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
        return name + "\n\tMonthly Salary: " + formatter.format(monthlySalary);
    }
    
    public void display() {
        System.out.print("<<Employee>>" + this);
    }
}
