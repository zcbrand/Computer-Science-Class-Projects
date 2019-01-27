/* Filename: Eecutive.java
 * Author: Zachary Brandenburg
 * Date: 23 January 2019
 * Purpose:
 */
package projectone;

public class Executive extends Employee {

    private final double STOCK_TARGET = 50;
    private final double BONUS = 30_000;
    private double stockPrice;

    public Executive(String name, double monthlySalary, double stockPrice) {
        super(name, monthlySalary);
        this.stockPrice = (stockPrice > 0) ? stockPrice : 0;
    }

    public double annualSalary() {
        return (stockPrice > STOCK_TARGET) ? super.annualSalary() + BONUS
                : super.annualSalary();
    }

    public String toString() {
        return super.toString() + "\n\tStock Price: "
                + formatter.format(stockPrice);
    }

    public void display() {
        System.out.print("\n<<Executive>>" + this);
    }
}
