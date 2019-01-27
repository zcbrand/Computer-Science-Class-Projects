/* Filename: Executive.java
 * Author: Zachary Brandenburg
 * Date: 23 January 2019
 * Purpose: Executive class extends Employee class adding a stock price, stock 
 * target, and bonus. Overrides annualSalary, toString, and display methods
 */
package projectone;

public class Executive extends Employee {
    
    // Declare class instance variables
    private final double STOCK_TARGET = 50;
    private final double BONUS = 30_000;
    private double stockPrice;

    // Class constructor
    public Executive(String name, double monthlySalary, double stockPrice) {
        super(name, monthlySalary);
        this.stockPrice = (stockPrice > 0) ? stockPrice : 0;
    }

    // Calculate an employees monthly salary and return as a double
    public double annualSalary() {
        return (stockPrice > STOCK_TARGET) ? super.annualSalary() + BONUS
                : super.annualSalary();
    }

    // toString method
    public String toString() {
        return super.toString() + "\n\tStock Price: "
                + formatter.format(stockPrice);
    }
    
    // prints out toString method with employee type identifier
    public void display() {
        System.out.print("\n<<Executive>>" + this);
    }
}
