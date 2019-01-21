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
public class Employee {
    private Name name;
    private double monthlySalary;
    
    public Employee(){
        name = new Name("John", "Doe");
        monthlySalary = 4000;
    }
    
    public Employee(Name name, double monthlySalary){
        this.name = name;
        this.monthlySalary = monthlySalary;
    }
    
    public String toString(){
        return name + "\n\tMonthly Salary: " + monthlySalary;
    }
    
    public void display(){
        System.out.print("<<Employee>>" + this);
    }
} 
