/* Name: InfixExpresionEvaluator.java
 * Author: Zachary Brandenburg
 * Date: 31-March-2019
 * Purpose: A program that evaluates infix expressions of unsigned integers using two stacks.
 */

import java.awt.EventQueue;

public class InfixExpressionEvaluator {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            InfixExpressionEvaluatorController control = new InfixExpressionEvaluatorController();
            InfixExpressionEvaluatorView view = new InfixExpressionEvaluatorView(control);
            view.setVisible(true);
        });
    }
}