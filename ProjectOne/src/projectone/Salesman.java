/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectone;

/**
 *
 * @author zcbra
 */
public class Salesman extends Employee{
    private double annualSales;
    
    public Salesman(){
        annualSales = 100000;
    }
    
    public Salesman(Name name, double monthlySalary, double annualSales){
        super(name, monthlySalary);
        this.annualSales = annualSales;
    }
    
    public void display(){
        System.out.print("<<Salesman>>" + this);
    }
}
