package Views;

import javax.swing.*;

public class Dialogue {

    public Dialogue(){

    }
    public void welcomeMessage(JFrame frame) {
        JOptionPane.showMessageDialog(frame,
                "Welcome to The Great Agile Race!",
                "",
                JOptionPane.PLAIN_MESSAGE);
    }
}
