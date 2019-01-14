//TestInheritance.java
package week1practice;

public class TestAbstraction {
public static void main(String[] args)  {
      Employee employees [] = new Employee [3];
      employees[0] = new SalariedEmployee("Julia", "Kitar", 50600);
      employees[1] = new HourlyEmployee("Bob", "Jones", 25, 47);
      employees[2] = new HourlyEmployee("Silvia", "Rime", 17.5,28);
      raiseAllPayments(employees, 0.11);
      displayAllEmployees(employees);
   }
   public static void raiseAllPayments(
         Employee[] employees, double percentage) {
      for (int i = 0; i < employees.length; i++)	 
      	 employees[i].issueRaise(percentage);
   }
   public static void displayAllEmployees(Employee[] employees) {
      for (int i = 0; i < employees.length; i++)
         employees[i].display();
   }
}
