package project3;/*
 * Name: project3.ThreeAddressGeneratorApp.java
 * Author: Zachary Brandenburg
 * Date: 13-April-2019
 * Description: This program accepts an arithmetic expression of unsigned
 * integers in postfix notation and builds the arithmetic expression tree
 * that represents that expression. From that tree, the corresponding
 * fully parenthesized infix expression is displayed and a file is
 * generated that contains the three address format instructions.
 */

import java.awt.EventQueue;

/** Name: <code>project3.ThreeAddressGeneratorApp.java</code>
 * <p>
 * Purpose: This program accepts an arithmetic expression of unsigned
 * integers in postfix notation and builds the arithmetic expression tree
 * that represents that expression. From that tree, the corresponding
 * fully parenthesized infix expression is displayed and a file is
 * generated that contains the three address format instructions.
 *
 * @author Zachary Brandenburg
 * @since 9-April-2019
 */
public class ThreeAddressGeneratorApp {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Controller controller = new Controller();
            controller.creatNewAddressFile();
            ThreeAddressGeneratorView view = new ThreeAddressGeneratorView(controller);
            view.setVisible(true);
        });
    }
}