package project3;/*
 * Name: project3.OperatorNode.java
 * Author: Zachary Brandenburg
 * Date: 13-April-2019
 * Description: An operator specific node that holds an arimatic operator
 */

import java.util.ArrayList;

/**
 * Name: <code>project3.OperatorNode</code>
 * <p>
 * The <code>project3.OperatorNode</code> class implementing the <code>project3.Node</code>
 * interface.
 * 
 * @author Zachary Brandenburg
 * @since 13-April-2019
 */
public class OperatorNode implements Node {
    
    private Node leftNode; 
    private Node rightNode;
    private String operator;

    /**
     * Creates the <code>project3.OperatorNode</code> that contains the arithmatic
     * <code>operator</code> and points to the left and right node
     * 
     * @param operator  the arithmatic <code>operator</code>
     * @param leftNode  the left <code>project3.Node</code>
     * @param rightNode the right <code>project3.Node</code>
     */
    public OperatorNode(String operator, Node rightNode, Node leftNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.operator = operator;
    }

    
    // Returns the left node
    @Override
    public Node getLeftNode() {
        return leftNode;
    }

    // Sets the left node
    @Override
    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    // Returns the right node
    @Override
    public Node getRightNode() {
        return rightNode;
    }

    // Sets the right node
    @Override
    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
    
    // Returns the operator
    @Override
    public String getValue() {
        return operator;
    }

    // Returns true if node is a leaf
    @Override
    public boolean isLeaf() {
        return (getLeftNode() == null && getRightNode() == null);
    }

    @Override
    public int getInstructions(int currentRegistry, ArrayList<String> instructions) {
        String leftValue = String.valueOf(getLeftNode().getValue());
        String rightValue = String.valueOf(getRightNode().getValue());
        String operation = operatorString(getValue());

        if(getLeftNode() != null) {
            int registryBeforeValue = currentRegistry;
            int registryAfterValue = getLeftNode().getInstructions(currentRegistry, instructions);
            if(registryAfterValue != registryBeforeValue) {
                currentRegistry = registryAfterValue;
                leftValue = "R" + (registryAfterValue - 1);
            }
        }
        
        if(getRightNode() != null) {
            int registryBeforeValue = currentRegistry;
            int registryAfterValue = getRightNode().getInstructions(currentRegistry, instructions);
            if(registryAfterValue != registryBeforeValue) {
                currentRegistry = registryAfterValue;
                rightValue = "R" + (registryAfterValue - 1);
            }
        }

        
        instructions.add("\n" + operation + " R" + currentRegistry + ", " + leftValue + ", " + rightValue);

        return currentRegistry + 1;
    }

    private String operatorString(String string) {
        
        String operatorString = null;

        switch(string) {
            case "-" :
                operatorString = "SUB";
                break;
            case "+" :
                operatorString = "ADD";
                break;
            case "*" :
                operatorString = "MUL";
                break;
            case "/" :
                operatorString = "DIV";
                break;
        }

        return operatorString;
    }

    
}