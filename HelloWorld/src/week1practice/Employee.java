/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1practice;

import java.text.DecimalFormat;

abstract class Employee extends Person {

    protected static DecimalFormat formatter = new DecimalFormat("$0.00");

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public abstract void issueRaise(double percentage);

    public abstract double calculateEarnings();

    public String toString() {
        return super.toString() + "\n\tEarnings: "
                + formatter.format(calculateEarnings());
    }
}
