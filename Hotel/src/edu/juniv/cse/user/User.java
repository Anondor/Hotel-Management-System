package edu.juniv.cse.user;

import edu.juniv.cse.auth.Auth;
import edu.juniv.cse.main.Conn;
import edu.juniv.cse.model.User_choice;
import edu.juniv.cse.model.Choice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class User implements ActionListener{

    JFrame f;
    JLabel id1,id2,id3,id4,id8,id5,id15,lab,lab1;
    JTextField t1,t2,t3,t4,t5;
    JButton b,b1;

    User(){
        f = new JFrame("User Information");
        f.setBackground(Color.white);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("edu/juniv/cse/icons/add_employee.jpg"));
        id15.setIcon(img);

        id8 = new JLabel("User details");
        id8.setBounds(320,30,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("User Id");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);

        id2 = new JLabel("First Name");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id3= new JLabel("Last Name");
        id3.setBounds(50,200,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);

        id4= new JLabel("Address");
        id4.setBounds(400,200,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);

        id5= new JLabel("Mobile");
        id5.setBounds(50,250,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id15.add(t5);

        lab=new JLabel();
        lab.setBounds(200,450,250,200);
        id15.add(lab);

        lab1=new JLabel("");
        lab1.setBounds(600,450,250,200);
        id15.add(lab1);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,550,150,40);

        id15.add(b);

        b1=new JButton("Cancel");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,550,150,40);

        id15.add(b1);

        b.addActionListener(this);
        b1.addActionListener(this);

        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
    }

    public void actionPerformed(ActionEvent ae){

        String id = t1.getText();
        String Fname = t2.getText();
        String Lname = t3.getText();
        String Address = t4.getText();
        String Phone = t5.getText();
        String mail= Auth.logmail;

        if(ae.getSource() == b){
            try{
                Conn cc = new Conn();
                String q;
                q = "insert into User values('"+id+"','"+mail+"','"+Fname+"','"+Lname+"','"+Address+"','"+Phone+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
               new User_choice();
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
            new Choice();
        }
    }
}