/* Filename: Salesman.java
 * Author: Zachary Brandenburg
 * Date: 23 January 2019
 * Purpose:
 */
package projectone;

public class Salesman extends Employee {
    // Declare class instance variables
    private final double MAX_COMMISSION = 20_000; // Final for max allowable commision
    private double annualSales;
    
    /* Class constructor receiving Name class Monthly Salary double 
    *  and Annual Sales double
    */
    public Salesman(Name name, double monthlySalary, double annualSales) {
        super(name, monthlySalary);
        this.annualSales = annualSales;
    }
    // Method to calculate annual salary
    public double annualSalary() {
        return ((annualSales * .02) < MAX_COMMISSION) ? super.annualSalary()
                + (annualSales * .02) : super.annualSalary() + MAX_COMMISSION;
    }
    
    public String toString() {
        return super.toString() + "\n\tAnnual Sales: " + 
                formatter.format(annualSales) + "\n\tAnnual Salary: " +
                formatter.format(annualSalary());
    }
    
    public void display() {
        System.out.print("<<Salesman>>" + this);
    }
}
