package menu;

import pages.FirstPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SellerMenu implements ActionListener{

    private JPanel panel;
    private JFrame frame;
    private JLabel title;
    private JButton acar,vcars,ecar,vreq,logout;

    public void sellermenu(){

        panel = new JPanel();
        frame = new JFrame();

        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        //Seller Menu
        title = new JLabel("Menu");
        title.setBounds(150,20,80,25);
        panel.add(title);

        //Options
        acar= new JButton("Add Car");
        acar.setBounds(20,50,125,25);
        panel.add(acar);

        vcars= new JButton("View Cars");
        vcars.setBounds(20,90,125,25);
        panel.add(vcars);

        ecar= new JButton("Edit car");
        ecar.setBounds(20,130,125,25);
        panel.add(ecar);

        vreq= new JButton("View Requests");
        vreq.setBounds(20,170,125,25);
        panel.add(vreq);


        logout= new JButton("Log out");
        logout.setBounds(200,200,80,25);
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
