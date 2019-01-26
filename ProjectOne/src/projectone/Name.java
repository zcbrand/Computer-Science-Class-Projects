/* Filename: Name.java
 * Author: Zachary Brandenburg
 * Date: 15 January 2019
 * Purpose:
 */
package projectone;

public class Name {

    private String firstName, lastName;

    public Name() {
        firstName = " ";
        lastName = " ";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return "\n\tName: " + lastName + ", " + firstName;
    }
}
