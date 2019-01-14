/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1practice;

public class Employee extends Person {

    private int salary;

    public Employee(String firstName, String lastName, int salary) {
        super(firstName, lastName);
        this.salary = salary;

    }

    public String toString() {
        return super.toString() + "\n\tSalary: " + salary;
    }

    public void display() {
        System.out.println("<<Employee>>" + this);
    }

}
