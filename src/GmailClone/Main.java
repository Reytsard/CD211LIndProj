package GmailClone;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();

        JLabel label = new JLabel();
        label.setText("Gmail");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);



        frame.add(label);
    }
}
