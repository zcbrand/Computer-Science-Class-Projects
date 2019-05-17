/* Name: View.java
 * Author: Zachary Brandenburg
 * Date: 28-April-2019
 * Purpose: Generates the UI for BinarySearchTreeSort.java
 */

package project4;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class View extends JFrame {

    private static final long serialVersionUID = 4612184346993203054L;

    public View() {
        initUI();
    }

    private void initUI() {

        // Initialize panels\
        JPanel root = new JPanel();
        JPanel originalListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel sortedListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel performSortPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel selectorPanel = new JPanel(new GridLayout(1, 2));
        JPanel sortOrderPanel = new JPanel(new GridLayout(2, 1));
        JPanel numericTypePanel = new JPanel(new GridLayout(2, 1));

        // Initialize Components
        JLabel originalListLabel = new JLabel("Original List");
        JLabel sortedListLabel = new JLabel("Sorted List");
        JTextField originalTextField = new JTextField(40);
        JTextField sortedTextField = new JTextField(40);
        JButton performSortButton = new JButton("Perform Sort");
        JRadioButton ascendingButton = new JRadioButton("Ascending", true);
        JRadioButton descendingButton = new JRadioButton("Descending");
        JRadioButton integerButton = new JRadioButton("Integer", true);
        JRadioButton fractionButton = new JRadioButton("Fraction");

        // Initialize button groups
        ButtonGroup sortOrderGroup = new ButtonGroup();
        ButtonGroup numericTypeGroup = new ButtonGroup();

        // Make sorted text field not editable
        sortedTextField.setEditable(false);

        // Add components to list panel
        originalListPanel.add(originalListLabel);
        originalListPanel.add(originalTextField);

        // Add components to sorted panel
        sortedListPanel.add(sortedListLabel);
        sortedListPanel.add(sortedTextField);

        // Add button to perform sort panel
        performSortPanel.add(performSortButton);

        // Add action command to radio buttons
        ascendingButton.setActionCommand("Ascending");
        descendingButton.setActionCommand("Descending");
        integerButton.setActionCommand("Integer");
        fractionButton.setActionCommand("Fraction");

        // Add radio buttons to button groups
        sortOrderGroup.add(ascendingButton);
        sortOrderGroup.add(descendingButton);
        numericTypeGroup.add(integerButton);
        numericTypeGroup.add(fractionButton);

        // Add radio buttons to their panels
        sortOrderPanel.add(ascendingButton);
        sortOrderPanel.add(descendingButton);
        numericTypePanel.add(integerButton);
        numericTypePanel.add(fractionButton);

        // Create borders for radio button group panels
        sortOrderPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Sort Order"));
        numericTypePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Numeric Type"));

        // Add radio button panels to selector panel
        selectorPanel.add(sortOrderPanel);
        selectorPanel.add(numericTypePanel);

        // Add all panels to root panel
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        root.add(originalListPanel);
        root.add(sortedListPanel);
        root.add(performSortPanel);
        root.add(selectorPanel);

        // Set action listener for perform sort button
        performSortButton.addActionListener(e -> {

            // Initialize variables
            String[] inputArray = originalTextField.getText().split(" ");
            String outputString = "";

            try {
                if (integerButton.isSelected()) {
                    BinaryTree<Integer> tree = new BinaryTree<>();

                    // Add all string in the input array if they are an Integer
                    // Throws NumberFormatExpressionError if an invalid input is detected
                    for (String s : inputArray) {
                        if (s.matches("[0-9]+")) {
                            tree.insert(Integer.parseInt(s));
                        } else {
                            throw new NumberFormatExpression("Invalid input: " + s);
                        }
                    }
                    // Detects selected sort order
                    if (ascendingButton.isSelected()) {
                        outputString = tree.getAscending();
                    } else {
                        outputString = tree.getDescending();
                    }
                }

                if (fractionButton.isSelected()) {
                    BinaryTree<Fraction> tree = new BinaryTree<>();

                    // Add all string in the input array if they are a Fraction
                    // Throws NumberFormatExpressionError if an invalid input is detected
                    for (String s : inputArray) {
                        if (s.matches("[0-9]+[/][0-9]+")) {
                            tree.insert(new Fraction(s));
                        } else {
                            throw new NumberFormatExpression("Invalid input: " + s);
                        }
                    }
                    // Detects selected sort order
                    if (ascendingButton.isSelected()) {
                        outputString = tree.getAscending();
                    } else {
                        outputString = tree.getDescending();
                    }
                }

                sortedTextField.setText(outputString);

            } catch (NumberFormatExpression ex) {
                messageDialog(ex.getMessage(), ex.getClass().getSimpleName());
            }
        });

        // Pack and set up frame
        add(root);
        pack();

        setTitle("Binary Search Tree Sort");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Pops a JOptionPane ErrorMessage for division by zero
    public void messageDialog(String message, String title) {
        JOptionPane.showMessageDialog(getContentPane(),
                message, title, JOptionPane.WARNING_MESSAGE);
    }

}
