/* Filename: InsufficientFundsException.java
 * Author: Zachary Brandenburg
 * Date: 10 February 2019
 * Purpose: Defines an exception that is used for insufficient funds to manipulate acount values
 */
package projecttwo;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message){
        super(message);
    }
}
