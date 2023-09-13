package GmailClone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private JButton button;
    MyFrame(){

        button = new JButton();
        button.setBounds(200,200,100,100);

        this.setTitle("Gmail Clone");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
