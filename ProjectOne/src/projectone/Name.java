/* Filename: Name.java
 * Author: Zachary Brandenburg
 * Date: 15 January 2019
 * Purpose: Class to store a name
 */
package projectone;

public class Name {
    
    // Declare class instance variables
    private String firstName, lastName;

    // Default name constructor
    public Name() {
        firstName = " ";
        lastName = " ";
    }

    // Class constructor
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // toString method
    public String toString() {
        return "\n\tName: " + lastName + ", " + firstName;
    }
}
