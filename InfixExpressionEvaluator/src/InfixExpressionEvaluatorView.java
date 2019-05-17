/* Name: InfixExpresionEvaluatorView.java
 * Author: Zachary Brandenburg
 * Date: 31-March-2019
 * Purpose: The GUI for Infix Expression Evaluator
 */

import javax.swing.*;
import java.awt.*;

public class InfixExpressionEvaluatorView extends JFrame {

    private static final long serialVersionUID = 1L;

    public InfixExpressionEvaluatorView(InfixExpressionEvaluatorController control) {
        initializeUI(control);
    }
    
    private void initializeUI(InfixExpressionEvaluatorController control) {
    
        // Initialize view layouts
        BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
    
        // Initialize view components
        JTextField infixExpressionField = new JTextField(20);
        JTextField resultField = new JTextField(20);
        JLabel infixExpressionLabel = new JLabel("Enter Infix Expression");
        JLabel resultLabel = new JLabel("Result");
        JButton evaluateButton = new JButton("Evaluate");
    
        // Set up components for the expression input
        JPanel componentsExpressionRow = new JPanel();
        componentsExpressionRow.setLayout(flowLayout);
        componentsExpressionRow.add(infixExpressionLabel);
        componentsExpressionRow.add(infixExpressionField);
    
        // Set up button component
        JPanel componentsEvaluationRow = new JPanel();
        componentsEvaluationRow.setLayout(flowLayout);
        componentsEvaluationRow.add(evaluateButton);
    
        // Set up components for the result field
        JPanel componentsResultRow = new JPanel();
        componentsResultRow.setLayout(flowLayout);
        componentsResultRow.add(resultLabel);
        componentsResultRow.add(resultField);
        resultField.setEditable(false);
    
        // Add components to the frame
        setLayout(boxLayout);
        add(componentsExpressionRow);
        add(componentsEvaluationRow);
        add(componentsResultRow);
    
        // Action listener for the evaluate button catches ArimeticException for devide by zero
        evaluateButton.addActionListener(e -> {
            try {
                String inputString = infixExpressionField.getText().trim(); // Get user input from expression field
                inputString = inputString.replaceAll("\\s+", ""); // Remove all whitespace
                String resultString = Integer.toString(control.evaluate(inputString)); // Process expression
                resultField.setText(resultString); // Set result field with result
            } catch (ArithmeticException ex) {
                divisionByZeroDialog();
            }
        });
    
        pack();
    
        setTitle("Infix Expression Evaluator");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    // Pops a JOptionPane ErrorMessage for division by zero
    private void divisionByZeroDialog() {
        JOptionPane.showMessageDialog(getContentPane(),
                "Can not divide by 0!", "ArithmeticException", JOptionPane.ERROR_MESSAGE);
    }
}
