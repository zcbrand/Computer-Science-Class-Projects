package project4;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Name: View.java
 * Author: Zachary Brandenburg
 * Date: 30 04 2019
 * Description: Builds the UserInterface for the application
 */
public class View extends JFrame {

    private DirectedGraph<String> directedGraph;

    public View() {
        initView();
    }

    private void initView() {

        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        InputsPanel inputsPanel = new InputsPanel();
        inputsPanel.setLayout(new BoxLayout(inputsPanel, BoxLayout.X_AXIS));
        RecompilationOrderPanel recompilationPanel = new RecompilationOrderPanel();

        root.add(inputsPanel);
        root.add(recompilationPanel);

        inputsPanel.getBuildGraphButton().addActionListener(e -> {

            LinkedList<String[]> tokenArray = new LinkedList<>();
            String tempString;
            directedGraph = new DirectedGraph<>();

            try {
                if (inputsPanel.getFileNameField().getText().isEmpty())
                    throw new NullPointerException("File name is empty!");

                try (BufferedReader br = new BufferedReader(new FileReader(inputsPanel.getFileNameField().getText()))) {
                    while ((tempString = br.readLine()) != null) {
                        String[] stringArray = tempString.split("\\s");
                        tokenArray.add(stringArray);
                    }
                }

                // Builds the directed graph from a ArrayList
                directedGraph.buildDirectedGraph(tokenArray);

                // Pop dialog showing graph has built
                JOptionPane.showMessageDialog(getContentPane(), "Graph Built Successfully", "Message",
                        JOptionPane.INFORMATION_MESSAGE);

                inputsPanel.getTopologicalOrderButton().setEnabled(true);

            } catch (NullPointerException | InvalidClassNameException ex) {
                messageDialog(ex.getMessage(), ex.getClass().getSimpleName());
            } catch (IOException ex) {
                messageDialog("File not found!", ex.getClass().getSimpleName());
            }

        });

        inputsPanel.getTopologicalOrderButton().addActionListener(e -> {
            try {
                recompilationPanel.setOutputText(directedGraph
                        .topologicalOrder(inputsPanel
                                .getClassNameField()
                                .getText()));
            } catch (CycleDetectedException | InvalidClassNameException ex) {
                messageDialog(ex.getMessage(), ex.getClass().getSimpleName());
            }

            inputsPanel.getTopologicalOrderButton().setEnabled(false);
        });

        add(root);
        pack();

        setTitle("Class Dependency Graph");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Pops a JOptionPane ErrorMessage
    private void messageDialog(String message, String title) {
        JOptionPane.showMessageDialog(getContentPane(),
                message, title, JOptionPane.WARNING_MESSAGE);
    }

    static class InputsPanel extends JPanel {

        private JTextField fileNameField;
        private JTextField classNameField;
        private JButton buildGraphButton;
        private JButton topologicalOrderButton;

        InputsPanel() {
            setBackground(Color.lightGray);
            setOpaque(true);
            setBorder(BorderFactory.createEtchedBorder());
            addComponents();
        }

        JTextField getFileNameField() {
            return fileNameField;
        }

        JTextField getClassNameField() {
            return classNameField;
        }

        JButton getBuildGraphButton() {
            return buildGraphButton;
        }

        JButton getTopologicalOrderButton() {
            return topologicalOrderButton;
        }

        private void addComponents() {
            JPanel labelPanel = new JPanel();
            JPanel textPanel = new JPanel();
            JPanel buttonPanel = new JPanel();

            JLabel fileNameLabel = new JLabel("Input file name:");
            JLabel classToRecompileLabel = new JLabel("Class to recompile:");
            fileNameField = new JTextField(20);
            classNameField = new JTextField(20);
            buildGraphButton = new JButton("Build Directed Graph");
            topologicalOrderButton = new JButton("Topological Order");

            topologicalOrderButton.setEnabled(false);

            setStyles(labelPanel);
            setStyles(textPanel);
            setStyles(buttonPanel);

            addComponents(labelPanel, fileNameLabel, classToRecompileLabel, 12);
            addComponents(textPanel, fileNameField, classNameField, 10);
            addComponents(buttonPanel, buildGraphButton, topologicalOrderButton, 8);

            add(Box.createRigidArea(new Dimension(20, 0)));
            add(labelPanel);
            add(Box.createRigidArea(new Dimension(20, 0)));
            add(textPanel);
            add(Box.createRigidArea(new Dimension(20, 0)));
            add(buttonPanel);
            add(Box.createRigidArea(new Dimension(20, 0)));
        }

        private void addComponents(Container container, JComponent comp1, JComponent comp2, int height) {
            comp1.setAlignmentX(Component.CENTER_ALIGNMENT);
            comp2.setAlignmentX(Component.CENTER_ALIGNMENT);

            container.add(Box.createRigidArea(new Dimension(0, height)));
            container.add(comp1);
            container.add(Box.createRigidArea(new Dimension(0, height)));
            container.add(comp2);
            container.add(Box.createRigidArea(new Dimension(0, height)));
        }

        private void setStyles(JPanel panel) {
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBackground(Color.lightGray);
            panel.setOpaque(true);
        }
    }

    static class RecompilationOrderPanel extends JPanel {

        private JLabel outputText = new JLabel("");

        RecompilationOrderPanel() {
            setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(), "Recompilation Order"));
            setPreferredSize(new Dimension(100, 200));
            addComponents();
        }

        private void addComponents() {
            outputText.setAlignmentX(Component.CENTER_ALIGNMENT);
            outputText.setAlignmentY(Component.TOP_ALIGNMENT);
            add(outputText);
        }

        void setOutputText(String outputText) {
            this.outputText.setText(outputText);
        }
    }
}
