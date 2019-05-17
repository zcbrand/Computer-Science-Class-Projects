/* Name: NumberFormatExpression.java
 * Author: Zachary Brandenburg
 * Date: 28-April-2019
 * Purpose: Define a NumberFormatExpression exception
 */

package project4;

public class NumberFormatExpression extends Exception {

	private static final long serialVersionUID = 7346818943001825148L;

	public NumberFormatExpression(String message) {
		super(message);
	}

}
