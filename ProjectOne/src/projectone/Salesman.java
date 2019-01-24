/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectone;

public class Salesman extends Employee {

    private final double MAX_COMMISSION = 20_000;
    private double annualSales;

    public Salesman() {
        annualSales = 100_000;
    }

    public Salesman(Name name, double monthlySalary, double annualSales) {
        super(name, monthlySalary);
        this.annualSales = annualSales;
    }

    public double annualSalary() {
        return ((annualSales * .02) < MAX_COMMISSION) ? super.annualSalary()
                + (annualSales * .02) : super.annualSalary() + MAX_COMMISSION;
    }

    public void display() {
        System.out.print("<<Salesman>>" + this);
    }
}
