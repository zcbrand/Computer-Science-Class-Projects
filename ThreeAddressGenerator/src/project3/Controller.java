package project3;/*
 * Name: project3.Controller.java
 * Author: Zachary Brandenburg
 * Date: 13-April-2019
 * Description: project3.Controller class
 */


import java.io.*;
import java.util.LinkedList;

public class Controller {

	private ExpressionTree expressionTree;
	private Node root;

	// Default Constructor
    public Controller() {

    }

	// Evaluates the postfix expression and returns the infix expression
	public String evaluate(String inputString) {
		
		expressionTree = new ExpressionTree();
		String[] postfixArray = tokenizer(inputString);
		LinkedList<String> cleanPostfixList = new LinkedList<String>();

		// For removing whitespace tokens
		for(int i = 0; i < postfixArray.length; i++) {
			if (!postfixArray[i].equals(" "))
				cleanPostfixList.add(postfixArray[i]);
		}

		root = expressionTree.constructTree(cleanPostfixList);
		
		return expressionTree.treeInfixWalk(root);
	}

	// Writes 3-Address Format Instructions to file
	public void threeAddressWriter(String inputString) {
		try (FileWriter fWriter = new FileWriter("ThreeAddressData.txt", true)) {
			fWriter.append(("\n" + inputString + "\n"));
			fWriter.append(expressionTree.threeAddressWalk(root));
			fWriter.append("\n\n:------------------------------:\n");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// Creates a new file for holding 3-Address Format Instructions
	public void creatNewAddressFile() {
		try (FileWriter fWriter = new FileWriter("ThreeAddressData.txt")) {
			fWriter.append(("Three Address Data\n"));
		} catch (IOException e) {
			System.out.println(e);
		}
	} 

	// Splits the input string into a stringarray
	private String[] tokenizer(String string) {
        return string.split("(?<=[^.0-9\\d])|(?=[^.0-9\\d])");
    }
}