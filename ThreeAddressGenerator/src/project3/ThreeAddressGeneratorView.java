package project3;/*
 * Name: project3.ThreeAddressGeneratorView.java
 * Author: Zachary Brandenburg
 * Date: 13-April-2019
 * Description: The view for the app
 */

import javax.swing.*;
import java.awt.*;

public class ThreeAddressGeneratorView extends JFrame{

    private static final long serialVersionUID = 1L;

    private String inputFieldLabel = "Enter Postfix Expression";
    private String outputFieldLabel = "Infix Expression";
    private String buttonLabel = "Construct Tree";
    private String titleText = "Three Address Generator";

    
    public ThreeAddressGeneratorView(Controller control) {
        initializeUI(control);
    }

    // Initializes the user interfase
    private void initializeUI(Controller control) {

        // Initialize view layouts
        BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);

        // Initialize view components
        JTextField inputField = new JTextField(20);
        JTextField outputField = new JTextField(20);
        JLabel inputLabel = new JLabel(inputFieldLabel);
        JLabel outputLabel = new JLabel(outputFieldLabel);
        JButton evaluateButton = new JButton(buttonLabel);

        // Set up components for the expression input
        JPanel componentsExpressionRow = new JPanel();
        componentsExpressionRow.setLayout(flowLayout);
        componentsExpressionRow.add(inputLabel);
        componentsExpressionRow.add(inputField);

        // Set up button component
        JPanel componentsEvaluationRow = new JPanel();
        componentsEvaluationRow.setLayout(flowLayout);
        componentsEvaluationRow.add(evaluateButton);

        // Set up components for the result field
        JPanel componentsResultRow = new JPanel();
        componentsResultRow.setLayout(flowLayout);
        componentsResultRow.add(outputLabel);
        componentsResultRow.add(outputField);
        outputField.setEditable(false);

        // Add components to the frame
        setLayout(boxLayout);
        add(componentsExpressionRow);
        add(componentsEvaluationRow);
        add(componentsResultRow);

        // Action listener for the evaluate button catches ArimeticException for devide by zero
        evaluateButton.addActionListener(e -> {
            try {
                String inputString = inputField.getText().trim(); // Get user input from expression field
                String resultString = control.evaluate(inputString); // Process expression
                outputField.setText(resultString); // Set result field with result
                control.threeAddressWriter(inputString);
            } catch (InvalidTokenException ex) {
                messageDialog(ex.getMessage(), ex.getClass().getSimpleName());
            }
        });

        pack();

        setTitle(titleText);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // Pops a JOptionPane ErrorMessage for division by zero
    private void messageDialog(String message, String title) {
        JOptionPane.showMessageDialog(getContentPane(),
                message, title , JOptionPane.WARNING_MESSAGE);
    }
}