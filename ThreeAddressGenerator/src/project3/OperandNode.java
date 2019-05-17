package project3;/*
 * Name: project3.OperandNode.java
 * Author: Zachary Brandenburg
 * Date: 13-April-2019
 * Description: An operand specific node that holds an operator
 */

import java.util.ArrayList;

/**
 * Name: <code>project3.OperandNode</code>
 * <p>
 * The <code>project3.OperandNode</code> class implementing the <code>project3.Node</code>
 * interface.
 * 
 * @author Zachary Brandenburg
 * @since 13-April-2019
 */
public class OperandNode implements Node {
    
    private Node leftNode;
    private Node rightNode;
    private String operand;

    /**
     * Creates the <code>project3.OperatorNode</code> that contains the arithmatic
     * <code>operator</code> and points to the left and right node
     * 
     * @param operand  an <code>Integer value</code>
     * @param leftNode  the left <code>project3.Node</code> set to <code>null</code>
     * @param rightNode the right <code>project3.Node</code> set to <code>null</code>
     */
    public OperandNode(String operand) {
        this.operand = operand;
        this.leftNode = null;
        this.rightNode = null;
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
    
    // Returns the operand
    @Override
    public String getValue() {
        return operand;
    }

    // Returns true if node is a leaf
    @Override
    public boolean isLeaf() {
        return (getLeftNode() == null && getRightNode() == null);
    }

    // Gets the instruction for the node
    @Override
    public int getInstructions(int currentRegistry, ArrayList<String> instructions) {
        return currentRegistry;
    }
}