package pages;

import menu.ClientMenu;
import menu.SellerMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstPage implements ActionListener {

    private JLabel title,label,label2;
    private JTextField username,password;
    private JButton login,register,clear;
    private JCheckBox checkseller,checkclient;
    private ClientMenu client;
    private SellerMenu seller;
    private JPanel panel;
    private JFrame frame;

    //Error
    private JFrame error;
    private JPanel perror;
    private JLabel message;

    public void startProgram (){

        panel=new JPanel();
        frame=new JFrame();

        frame.setSize(360,270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);


        //pages.FirstPage title
        title = new JLabel("Login");
        title.setBounds(150,20,80,25);
        panel.add(title);

        //UserName
        label= new JLabel("Username");
        label.setBounds(20,50,80,25);
        panel.add(label);

        username=new JTextField(20);
        username.setBounds(100,50,165,25);
        panel.add(username);

        //Password
        label2= new JLabel("Password");
        label2.setBounds(20,80,80,25);
        panel.add(label2);

        password=new JPasswordField(20);
        password.setBounds(100,80,165,25);
        panel.add(password);

        //Extras
        login= new JButton("Log in");
        login.setBounds(100,150,70,25);
        panel.add(login);
        login.addActionListener(this);

        clear= new JButton("Clear");
        clear.setBounds(182,150,80,25);
        panel.add(clear);
        clear.addActionListener(this);

        register= new JButton("Create an account");
        register.setBounds(100,185,162,25);
        panel.add(register);

        //Checkboxes
        checkclient=new JCheckBox("Client");
        checkclient.setBounds(96,110,60,25);
        panel.add(checkclient);

        checkseller=new JCheckBox("Seller");
        checkseller.setBounds(160,110,60,25);
        panel.add(checkseller);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String user = username.getText();
        String pass = password.getText();

        if(user.equals("admin") && pass.equals("admin") && checkclient.isSelected() && !checkseller.isSelected()){
            frame.setVisible(false);
            ClientMenu client=new ClientMenu();
            client.clientmenu();

        }
        else if(user.equals("admin") && pass.equals("admin") && !checkclient.isSelected() && checkseller.isSelected()){
            frame.setVisible(false);
            SellerMenu client=new SellerMenu();
            client.sellermenu();

        }
       else if((user!=null && pass!=null && checkclient.isSelected() && !checkseller.isSelected()) || (user!=null && pass!=null && !checkclient.isSelected() && checkseller.isSelected()))
        {
            error=new JFrame();
            perror=new JPanel();

            error.setSize(150,150);
            error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            error.add(perror);
            perror.setLayout(null);

            message = new JLabel("Invalid");
            message.setBounds(45,33,80,25);
            perror.add(message);

            error.setVisible(true);
        }


    }
}
