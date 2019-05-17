package project3;/*
 * Name: project3.Node.java
 * Author: Zachary Brandenburg
 * Date: 13-April-2019
 * Description: Interface for class type node
 */

import java.util.ArrayList;

public interface Node {
    public Node getLeftNode();
    public void setLeftNode(Node leftNode);
    public Node getRightNode();
    public void setRightNode(Node rightNode);
    public String getValue();
    public boolean isLeaf();
    public int getInstructions(int currentRegistry, ArrayList<String> instructions);
}