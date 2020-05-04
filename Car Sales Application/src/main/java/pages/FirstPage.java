package pages;

import menu.ClientMenu;
import menu.SellerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstPage implements ActionListener {

    private JLabel title,label,label2;
    private JTextField username,password;
    private JButton login,reg,clear;
    private JCheckBox checkseller,checkclient;
    private ClientMenu client;
    private SellerMenu seller;
    private Register register;
    private JPanel panel;
    private JFrame frame;

    public void startProgram (){

        panel=new JPanel();
        frame=new JFrame();

        frame.setSize(360,270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.lightGray);


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

        reg= new JButton("Create an account");
        reg.setBounds(100,185,162,25);
        panel.add(reg);
        reg.addActionListener(this);

        //Checkboxes
        checkclient=new JCheckBox("Client");
        checkclient.setBounds(96,110,60,25);
        panel.add(checkclient);
        checkclient.setBackground(Color.lightGray);

        checkseller=new JCheckBox("Seller");
        checkseller.setBounds(160,110,60,25);
        panel.add(checkseller);
        checkseller.setBackground(Color.lightGray);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String user = username.getText();
        String pass = password.getText();

    //Citire date din fisier .json



    //Actiuni pentru butonul Log In
    if(e.getSource()==login) {
        if (user.equals("admin") && pass.equals("admin") && checkclient.isSelected() && !checkseller.isSelected()) {
        frame.setVisible(false);
        ClientMenu client = new ClientMenu();
        client.menu();

        }
        if (user.equals("admin") && pass.equals("admin") && !checkclient.isSelected() && checkseller.isSelected()) {
        frame.setVisible(false);
        SellerMenu client = new SellerMenu();
        client.sellermenu();

        }
        if (( checkclient.isSelected() && checkseller.isSelected())){

        JOptionPane.showMessageDialog(frame,"Invalid");
        }

    }
    //Actiuni pentru butonul Create an account
    if(e.getSource()==reg){
        frame.setVisible(false);
        register=new Register();
        register.menu();

    }
    //Actiuni pentru butonul Clear
    if(e.getSource()==clear){
        password.setText(null);
        username.setText(null);
        checkclient.setSelected(false);
        checkseller.setSelected(false);
    }

    }



}
