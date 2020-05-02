package menu;

import pages.FirstPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientMenu implements ActionListener {

    private JPanel panel;
    private JFrame frame;
    private JLabel title;
    private JButton vcars,fapp,logout;

    public void clientmenu() {

        panel = new JPanel();
        frame = new JFrame();

        frame.setSize(350, 225);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        //Client Menu
        title = new JLabel("Menu");
        title.setBounds(150,20,80,25);
        panel.add(title);

        //Options
        vcars= new JButton("Available cars");
        vcars.setBounds(20,50,135,25);
        panel.add(vcars);

        fapp= new JButton("Fill the application");
        fapp.setBounds(20,90,135,25);
        panel.add(fapp);

        logout= new JButton("Log out");
        logout.setBounds(200,120,80,25);
        panel.add(logout);
        logout.addActionListener(this);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(logout.isSelected()){
            frame.setVisible(false);
            FirstPage back=new FirstPage();
            back.startProgram();
        }

    }
}
