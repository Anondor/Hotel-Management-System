package edu.juniv.cse.view;

import edu.juniv.cse.auth.Auth;
import edu.juniv.cse.main.Conn;
import edu.juniv.cse.model.View_choice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class User_details implements ActionListener {
    private JFrame f;
    private JLabel id,id1;
    private JButton b1,b2;
    private JTextField t1;

    public User_details(){
        f=new JFrame("User details");
        f.setVisible(true);
        f.setSize(595,642);
        f.setLocation(450,200);
        f.setBackground(Color.white);
        f.setLayout(null);
        id=new JLabel();
        id.setBounds(0,0,595,642);
        id.setLayout(null);
        int i=20;
        id1 = new JLabel("User Id");
        id1.setBounds(100,i+30,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id.add(id1);
        t1=new JTextField();
        t1.setBounds(200,i+30,150,30);
        id.add(t1);


        i+=100;
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,i,100,30);
        b1.addActionListener(this);
        id.add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,i,100,30);
        b2.addActionListener(this);
        id.add(b2);
        f.add(id);
        f.setSize(900,700);
        f.setLocation(400,150);
        i+=30;

        try{
          String user_id=t1.getText();
            Conn con=new Conn();
            String q = "select * from user";
            ResultSet rs= con.s.executeQuery(q);
            while(rs.next()){


                String Idd=rs.getString("user_id");

                id = new JLabel(Idd);
                id.setBounds(100,i,100,30);
                f.add(id);
                i=i+35;
            } f.setVisible(true);

        }


        catch(Exception e){
            e.printStackTrace();
        }

    }
    public void actionPerformed(ActionEvent ae){


        if(ae.getSource()==b1){

           f.setVisible(false);

           new User_info();
            }




        if(ae.getSource()==b2){
            f.setVisible(false);
            new View_choice();
        }
    }

    public static void main(String[ ] arg){
        new User_details();
    }
}