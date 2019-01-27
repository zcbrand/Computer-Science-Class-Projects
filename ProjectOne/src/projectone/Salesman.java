/* Filename: Salesman.java
 * Author: Zachary Brandenburg
 * Date: 23 January 2019
 * Purpose: Salesman class extends Employee class adding a max comission and
 * annual sales. Overrides annualSalary, toString, and display methods
 */
package projectone;

public class Salesman extends Employee {

    // Declare class instance variables
    private final double MAX_COMMISSION = 20_000; // Final for max allowable commision
    private double annualSales;

    // Class constructor
    public Salesman(String name, double monthlySalary, double annualSales) {
        super(name, monthlySalary);
        this.annualSales = annualSales;
    }

    // Calculate an employees monthly salary and return as a double
    public double annualSalary() {
        return ((annualSales * .02) < MAX_COMMISSION) ? super.annualSalary()
                + (annualSales * .02) : super.annualSalary() + MAX_COMMISSION;
    }

    // toString method
    public String toString() {
        return super.toString() + "\n\tAnnual Sales: "
                + formatter.format(annualSales);
    }

    // prints out toString method with employee type identifier
    public void display() {
        System.out.print("\n<<Salesman>>" + this);
    }
}
