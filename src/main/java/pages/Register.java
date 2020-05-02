package pages;

import pages.FirstPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register implements ActionListener {
   private JButton back;
   private JButton register;
   private  JFrame frame;
    public void register() {
        JPanel panel = new JPanel();
        frame = new JFrame("Register");
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

        //password
        JLabel label5 = new JLabel("Password");
        label5.setBounds(10, 180, 80, 25);
        panel.add(label5);

        JPasswordField password = new JPasswordField(40);
        password.setBounds(80,180, 165, 25);
        panel.add(password);

        //Client/Seller
        JLabel label6 = new JLabel("Function");
        label6.setBounds(10, 220, 80, 25);
        panel.add(label6);

        String fun[] = {"","Client", "Seller"};

        JComboBox function = new JComboBox(fun);
        function.setBounds(80, 220, 80, 25);
        panel.add(function);

        //Back
        back = new JButton("Back");
        back.setBounds(150, 260, 80,25);
        back.addActionListener(this);
        panel.add(back);

        //Register
        register = new JButton("Register");
        register.setBounds(240, 260, 100,25);
        panel.add(register);

        panel.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(back.isSelected())
        {
            frame.setVisible(false);
            FirstPage backfp = new FirstPage();
            backfp.startProgram();
        }
    }
}
