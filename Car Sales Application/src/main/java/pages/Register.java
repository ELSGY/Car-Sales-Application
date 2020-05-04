package pages;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.util.Iterator;


public class Register implements ActionListener {
   private JButton back,register;
   private JFrame frame;
   private JPanel panel;
   private JTextField username,password,name,email,age;
   private JComboBox function;

    public void menu() {
        panel = new JPanel();
        frame = new JFrame("Register");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        panel.setBackground(Color.lightGray);

        //Name
        JLabel label = new JLabel("Name");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        name = new JTextField(40);
        name.setBounds(80,20, 165, 25);
        panel.add(name);

        //E-mail
        JLabel label2 = new JLabel("E-mail");
        label2.setBounds(10, 60, 80, 25 );
        panel.add(label2);

        email = new JTextField(40);
        email.setBounds(80, 60, 165, 25);
        panel.add(email);

        //Username
        JLabel label3 = new JLabel("Username");
        label3.setBounds(10, 100, 80, 25);
        panel.add(label3);

        username = new JTextField(40) ;
        username.setBounds(80, 100, 165, 25);
        panel.add(username);

        //Age
        JLabel label4 = new JLabel("Age");
        label4.setBounds(10, 140, 80, 25);
        panel.add(label4);

        age = new JTextField(40) ;
        age.setBounds(80, 140, 165, 25);
        panel.add(age);

        //password
        JLabel label5 = new JLabel("Password");
        label5.setBounds(10, 180, 80, 25);
        panel.add(label5);

        password = new JPasswordField(40);
        password.setBounds(80,180, 165, 25);
        panel.add(password);

        //Client/Seller
        //JLabel label6 = new JLabel("Function");
        //label6.setBounds(10, 220, 80, 25);
        //panel.add(label6);


        function = new JComboBox();
        function.addItem("Client");
        function.addItem("Seller");
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
        register.addActionListener(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Actiuni pentru butonul Register
        if(e.getSource()==register)
        {

            JSONObject obj = new JSONObject();
            obj.put("name",name.getText());
            obj.put("email",email.getText());
            obj.put("username",username.getText());
            obj.put("age",age.getText());
            obj.put("password",password.getText());
            obj.put("function",(String)function.getSelectedItem());

            JSONArray list = new JSONArray();
            list.put(obj);

            try{
                File fis=new File("src/main/java/data/data.json");
                FileWriter fw=new FileWriter(fis,true);
                fw.write(list.toString());
                fw.flush();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }


        //Actiuni pentru butonul Back
        if(e.getSource()==back)
        {
            frame.setVisible(false);
            FirstPage bfp = new FirstPage();
            bfp.startProgram();
        }

    }
}
