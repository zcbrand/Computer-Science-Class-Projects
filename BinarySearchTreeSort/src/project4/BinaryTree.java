/* Name: BinaryTree.java
 * Author: Zachary Brandenburg
 * Date: 28-April-2019
 * Purpose: Generic class for BinaryTree
 */

package project4;

public class BinaryTree<T extends Comparable<T>> {

    // Define object variables
    private Node root;
    private StringBuilder output = new StringBuilder();

    // Default Constructor
    public BinaryTree() {
        root = null;
        output.setLength(0);
    }

    public String getAscending() {
        traverseInOrder(root);
        return output.toString();
    }

    public String getDescending() {
        traversePostOrder(root);
        return output.toString();
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            for (int i = 0; i < node.count; i++)
                output.append(node.value).append(" ");
            traverseInOrder(node.right);
        }
    }

    private void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.right);
            for (int i = 0; i < node.count; i++)
                output.append(node.value).append(" ");
            traversePostOrder(node.left);
        }
    }

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, T value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = insertRecursive(current.right, value);
        } else if (value.equals(current.value)) {
            current.count++;
        }

        return current;
    }

    // Internal class defining a Node
    private class Node {
        private T value;
        private Node left;
        private Node right;
        private int count;

        Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.count = 1;
        }
    }

}
