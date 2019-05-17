package project4;

import javax.swing.*;

/**
 * Name: ClassDependencyGraph.java
 * Author: Zachary Brandenburg
 * Date: 30 04 2019
 */
public class ClassDependencyGraph {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new View().setVisible(true));
    }
}
