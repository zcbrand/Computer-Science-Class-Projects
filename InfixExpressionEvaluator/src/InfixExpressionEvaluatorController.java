/* Name: InfixExpresionEvaluatorController.java
 * Author: Zachary Brandenburg
 * Date: 31-March-2019
 * Purpose: Provide controll logic for the view evaluating and solving the users infix expression
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class InfixExpressionEvaluatorController {
    
    // Initialize stacks and set of operators
    private Stack<Integer> operandStack = new Stack<>();
    private Stack<Character> operatorStack = new Stack<>();
    private Set<Character> operatorSet = new HashSet<>(Arrays.asList('+', '-', '*', '/', '(', ')'));

    public InfixExpressionEvaluatorController() {

    }

    public int evaluate(String input) {
        String[] tokenArray = tokenizer(input);
        return solveInfix(tokenArray);
    }

    // Checks the higher order precedence of two operators
    private boolean hasPrecedence(Character operandA, Character operandB) {
        if (operandB == '(' || operandB == ')')
            return false;
        if ((operandA == '*' || operandA == '/') && (operandB == '+' || operandB == '-'))
            return false;
        else
            return true;
    }

    // Performs a calculation throwing an arimatic if division by zero is detected
    private int performCalculation(char operator, int intB, int intA) throws ArithmeticException {

        switch (operator) {
            case '+':
                return intA + intB;
            case '-':
                return intA - intB;
            case '*':
                return intA * intB;
            case '/':
                if(intB == 0)
                    throw new ArithmeticException();
                return intA / intB;
        }
        return 0;
    }

    private int solveInfix(String[] stringArray) {

        for (String token : stringArray) {
            // If current token is an operand push it onto the operand stack
            if (!operatorSet.contains(token.charAt(0))) 
                operandStack.push(Integer.parseInt(token));
            
            // If current token is a left parenthesis push it onto the operator stack
            else if (token.equals("("))
                operatorStack.push(token.charAt(0));
            
            /* If current token is a right parenthisis
             * while top of the operator stack not a left parenthesis
             * pop two operands and an operator
             * perform the calculation
             * push the result onto the operand stack
             */
            else if (token.equals(")")) {
                while (!operatorStack.empty() && !operatorStack.peek().equals('(')) {
                    operandStack.push(performCalculation(operatorStack.pop(), 
                            operandStack.pop(), operandStack.pop()));
                }
                // Pop the opening parenthesis  
                operatorStack.pop();
            } 
            
            /* If the token is an opperator
             * While the operator stack is not empty and the operator at the top of the stack
             * has higher precedence pop two operands and perform the calculation push the 
             * result onto the operand stack
             */
            else if (operatorSet.contains(token.charAt(0))) {
                while (!operatorStack.isEmpty() && hasPrecedence(token.charAt(0), operatorStack.peek()))
                    operandStack.push(performCalculation(operatorStack.pop(),
                            operandStack.pop(), operandStack.pop()));
                // Push the current operator on the operators stack
                operatorStack.push(token.charAt(0));
            }
        }
        /* While the operator stack is not empty pop two operands and an operator 
         * perform the calculation push the result onto the operand stack
         */
        while (!operatorStack.empty())
            operandStack.push(performCalculation(operatorStack.pop(),
                    operandStack.pop(), operandStack.pop()));

        // Return the final result at the top of the stack
        return operandStack.pop();
    }

    /* Tokenize the input string using a reular expression
     * Positive Lookbehind (?<=[^.1-9\\d])
     * Positive Lookahead (?=[^.1-9\\d])
     */
    private String[] tokenizer(String string) {
        return string.split("(?<=[^.1-9\\d])|(?=[^.1-9\\d])");
    }
}