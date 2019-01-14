//TestInheritance.java
package week1practice;

public class TestInheritance {
    public static void main(String[] args){
        Person person = new Person("Zachary", "Brandenburg");
        Person student = new Student("John", "Smith", 3.16);
        Person employee = new Employee("Bill", "Brown", 75000);
        person.display();
        student.display();
        employee.display();
    }
}
