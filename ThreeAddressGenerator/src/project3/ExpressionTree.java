package project3;/*
 * Name: project3.ExpressionTree.java
 * Author: Zachary Brandenburg
 * Date: 13-April-2019
 * Description: Class that defines an expression tree
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class ExpressionTree {

    /**
     * Constructs an <code>project3.ExpressionTree</code>
     * @param postfixArray The <code>char</code> array
     * @return Returns the root <code>project3.Node</code>
     * @throws InvalidTokenException The <code>RuntimeException</code> thrown when an invalid token is procesed
     */
    public Node constructTree(LinkedList<String> postfixArray) throws InvalidTokenException {
        Node node = null;
        Stack<Node> expressionStack = new Stack<Node>();
        
        for(String string : postfixArray) {

            if(string.matches("-?\\d+")) {
                node = new OperandNode(string);
                expressionStack.push(node);
            } else if(string.matches("[+|\\-|*|/]")) { 
                node = new OperatorNode(string, expressionStack.pop(), expressionStack.pop());
                expressionStack.push(node);
            } else {
                throw new InvalidTokenException("Invalid token " + string);
            }
        }
        
        // Returns root of the expression tree
        node = expressionStack.peek();
        expressionStack.pop();
        return node;
    }

    // Recursive walk to generate infix expression
    public String treeInfixWalk(Node node) {
        if(node.isLeaf())
            return String.valueOf(node.getValue());
        return "( " + treeInfixWalk(node.getLeftNode()) + " " + node.getValue() 
            + " " + treeInfixWalk(node.getRightNode()) + " )";
    }

    // Builds the three address instr=uctions
    public String threeAddressWalk(Node node) {
        ArrayList<String> instructions = new ArrayList<>();
        String instruction = "";
        node.getInstructions(0, instructions);
        for(String s : instructions) {
            instruction += "    " + s;
        }
        return instruction;
    }
}