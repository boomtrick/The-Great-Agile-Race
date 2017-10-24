package Views;

import javax.swing.*;

public class Dialogue {
    //Starts dialogue
    public void StartPopup(JFrame parent) {








        JButton button = new JButton();

        button.setText("Welcome to The Great Agile Race!");
        parent.add(button);
        parent.pack();
        parent.setVisible(true);




        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(parent,
                        "What is your name?", null);
            }
        });
















    }
}
