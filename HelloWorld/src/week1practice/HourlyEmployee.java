// HourlyEmployee.java
package week1practice;

public class HourlyEmployee extends Employee {

    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, double wage,
            double hours) {
        super(firstName, lastName);
        this.wage = wage;
        this.hours = hours;
    }

    public void issueRaise(double percentage) {
        wage += wage * percentage;
    }

    public double calculateEarnings() {
        return (hours <= 40) ? hours * wage
                : 40 * wage + 1.5 * wage * (hours - 40);
    }

    public void display() {
        System.out.println("<<Hourly Employee>>" + this + " per year");
    }
}
