package pages;

import jdk.incubator.jpackage.internal.PackagerException;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parse.ParseException;
import org.json.simple.parser.JSONParser;

public class Register implements ActionListener {
   private JButton back,register;
   private JFrame frame;
   private JPanel panel;
   private JTextField username,password,name,email,age;
   private JComboBox function;
   private JLabel title;

    public void menu() {
        panel = new JPanel();
        frame = new JFrame("Register");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        panel.setBackground(Color.lightGray);

        //Register
        title = new JLabel("Register",SwingConstants.CENTER);
        title.setBounds(80,10,200,40);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 18));
        panel.add(title);

        //Name
        JLabel label = new JLabel("Name");
        label.setBounds(40, 60, 80, 25);
        panel.add(label);

        name = new JTextField(40);
        name.setBounds(110,60, 165, 25);
        panel.add(name);

        //E-mail
        JLabel label2 = new JLabel("E-mail");
        label2.setBounds(40, 100, 80, 25 );
        panel.add(label2);

        email = new JTextField(40);
        email.setBounds(110, 100, 165, 25);
        panel.add(email);

        //Username
        JLabel label3 = new JLabel("Username");
        label3.setBounds(40, 140, 80, 25);
        panel.add(label3);

        username = new JTextField(40) ;
        username.setBounds(110, 140, 165, 25);
        panel.add(username);

        //Age
        JLabel label4 = new JLabel("Age");
        label4.setBounds(40, 180, 80, 25);
        panel.add(label4);

        age = new JTextField(40) ;
        age.setBounds(110, 180, 165, 25);
        panel.add(age);

        //password
        JLabel label5 = new JLabel("Password");
        label5.setBounds(40, 220, 80, 25);
        panel.add(label5);

        password = new JPasswordField(40);
        password.setBounds(110,220, 165, 25);
        panel.add(password);


        function = new JComboBox();
        function.addItem("Client");
        function.addItem("Seller");
        function.setBounds(110, 260, 80, 25);
        panel.add(function);

        //Register
        register = new JButton("Register");
        register.setBounds(140, 300, 100,25);
        panel.add(register);
        register.addActionListener(this);

        //Back
        back = new JButton("Back");
        back.setBounds(260, 300, 80,25);
        back.addActionListener(this);
        panel.add(back);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

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


    public void addUser(String username, String password, String TypeOfAccount){
        JSONObject data = new JSONObject();
        JSONParser parser = new JSONParser();
        Object p;
        JSONArray arrayToParse = new JSONArray();
        try{
            FileReader readFile = new FileReader("data.json");
            BufferedReader read = new BufferedReader(readFile);
                p = parser.parse(read);
                if(p instanceof JSONArray)
                {
                    arrayToParse =(JSONArray)p;
                }
        }catch(IOException e)
        {
            e.printStackTrace();
        }catch (PackagerException e){
            e.printStackTrace();
        }
        data.put("username", username);
        data.put("password", password);
        data.put("typeOfAccount", TypeOfAccount);
        arrayToParse.add(data);
        try{
            File file = new File("data.json");
            FileWriter fisier = new FileWriter(file.getAbsoluteFile());
            fisier.write(arrayToParse.toString());
            fisier.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
