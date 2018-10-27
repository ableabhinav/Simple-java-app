import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
public class Project extends Frame implements ActionListener
{
     Button bexit,blogin;
     Label lum,lpw;
     TextField tum,tpw;
     //Vector<Project> v;
     static Project f;
    String um;
    String pw;
     BookInventory f1;
     Project()
     {
        super("Book Store Admin Page");
        lum=new Label("User Name");
        lum.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lum.setForeground(Color.GRAY);
        lpw=new Label("Password");
        lpw.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lpw.setForeground(Color.GRAY);

        //v=new Vector<Project>();
       tum=new TextField(6);
       tpw=new TextField(8);
       tpw.setEchoChar('*');
        
        
        bexit=new Button("Exit");
        blogin=new Button("Login");

        blogin.addActionListener(this);
        bexit.addActionListener(this);

        setLayout(new GridLayout(3,2,10,10));

         add(lum);
         add(tum);
         add(lpw);
         add(tpw);
         add(blogin);
         add(bexit);

         setSize(350,200);
         setVisible(true);
     }
    Project(String u,String p)
    {
        um=u;
        pw=p;
    }
     public void actionPerformed(ActionEvent e)
     {
        Button b=(Button)e.getSource();
        if(b==bexit)
            System.exit(0);
          else if(b==blogin)
          {
              String name="admin";
              String password="123";
              um=tum.getText();
              pw=tpw.getText();
              if(um.equals(name)&&pw.equals(password))
                {

                  f1=new BookInventory();
                  this.dispose();
                  
                }
              else
                JOptionPane.showMessageDialog(null,"Invalid UserName or Password");
          }
          else if(b==bexit)
          {
              System.exit(0);
          }
    }

    public static void main(String[]args)
    {
        f=new Project();
    }
}