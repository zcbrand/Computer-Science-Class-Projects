/* Filename: Employee.jave
 * Author: Zachary Brandenburg
 * Date: 23 January 2019
 * Purpose:
 */
package projectone;

public class Employee {

    private Name name;
    private double monthlySalary;

    public Employee() {
        name = new Name("John", "Doe");
        monthlySalary = 4_000;
    }

    public Employee(Name name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public double annualSalary() {
        return monthlySalary * 12;
    }

    public String toString() {
        return name + "\n\tMonthly Salary: " + monthlySalary;
    }
}
