package menu;

import javax.swing.*;

public class Register {
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Register");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        //Name
        JLabel label = new JLabel("Name");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        JTextField name = new JTextField(40);
        name.setBounds(80,20, 165, 25);
        panel.add(name);

        //E-mail
        JLabel label2 = new JLabel("E-mail");
        label2.setBounds(10, 60, 80, 25 );
        panel.add(label2);

        JTextField email = new JTextField(40);
        email.setBounds(80, 60, 165, 25);
        panel.add(email);

        //Username
        JLabel label3 = new JLabel("Username");
        label3.setBounds(10, 100, 80, 25);
        panel.add(label3);

        JTextField user = new JTextField(40) ;
        user.setBounds(80, 100, 165, 25);
        panel.add(user);

        //Age
        JLabel label4 = new JLabel("Age");
        label4.setBounds(10, 140, 80, 25);
        panel.add(label4);

        JTextField age = new JTextField(40) ;
        age.setBounds(80, 140, 165, 25);
        panel.add(age);

        panel.setLayout(null);
        frame.setVisible(true);
    }
}
