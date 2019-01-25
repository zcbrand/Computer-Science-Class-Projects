/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectone;

public class Executive extends Employee{
    private final double STOCK_TARGET = 50;
    private final double BONUS = 30_000;
    private double stockPrice;
    
    public Executive(Name name, double monthlySalary, double stockPrice) {
        super(name, monthlySalary);
        this.stockPrice = stockPrice;
    }
    
    public double annualSalary() {
        return (stockPrice > STOCK_TARGET) ? super.annualSalary() + BONUS : 
                super.annualSalary();
    }
    
    public void display() {
        System.out.print("<<Executive>>" + this + "\n\tStock Price: " + stockPrice);
    }
}
