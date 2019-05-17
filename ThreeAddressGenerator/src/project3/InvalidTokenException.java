package project3;/*
 * Name: project3.InvalidTokenException.java
 * Author: Zachary Brandenburg
 * Date: 13-April-2019
 * Description: Exception for an invalit token
 */

public class InvalidTokenException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public InvalidTokenException(String message) {
        super(message);
    }

}