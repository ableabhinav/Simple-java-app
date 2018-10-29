import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
//java -cp .:mysql-connector-java.jar Database
//javac -cp .:mysql-connector-java.jar *.java
// create database bookInventory;
// use bookInventory;
// create table books(id varchar (20), name varchar(20), author varchar(20), category varchar(20), publisher varchar(20), quantity int(10));
public class AddBook extends Frame implements ActionListener
{
     Button bback,baddb;
     Label lbnm,lbau,lbpub,lbcat,lbpr,lbqn;
     TextField tbnm,tbau,tbpub,tbcat,tbpr,tbqn;
     //Vector<Project> v;
      // Project f;
    // static D2 = BookInventory.D1;
    // static bookList2 = BookInventory.bookList
    String bnm;
    String bau;
    String bpub;
    String bcat;
    int bpr;
    int bqn;
    BookInventory f1;
     AddBook()
     {
        super("Book Info");
        lbnm=new Label("Name");
        lbnm.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbnm.setForeground(Color.GRAY);
        lbau=new Label("Author");
        lbau.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbau.setForeground(Color.GRAY);
        lbpub=new Label("Publication");
        lbpub.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbpub.setForeground(Color.GRAY);
        lbcat=new Label("Category");
        lbcat.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbcat.setForeground(Color.GRAY);
        lbpr=new Label("Price");
        lbpr.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbpr.setForeground(Color.GRAY);
        lbqn=new Label("Quantity");
        lbqn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbqn.setForeground(Color.GRAY);
        //tbnm,tbau,tbpub,tbcat,tbpr,tbqn;
        //v=new Vector<Project>();
       tbnm=new TextField(6);
       tbau=new TextField(8);
       tbpub=new TextField(6);
       tbcat=new TextField(8);
       tbpr=new TextField(6);
       tbqn=new TextField(8);
        
        
        bback=new Button("Back");
        baddb=new Button("Add");

        bback.addActionListener(this);
        baddb.addActionListener(this);

        setLayout(new GridLayout(7,2,10,10));
        //Label lbnm,lbau,lbpub,lbcat,lbpr,lbqn;
//tbnm,tbau,tbpub,tbcat,tbpr,tbqn;
         add(lbnm);
         add(tbnm);
         add(lbau);
         add(tbau);
         add(lbpub);
         add(tbpub);
         add(lbcat);
         add(tbcat);
         add(lbpr);
         add(tbpr);
         add(lbqn);
         add(tbqn);
         add(baddb);
         add(bback);

         setSize(350,350);
         setVisible(true);
     }

    AddBook(String nm,String au,String pub,String cat,int pr,int qn)
    {
        bnm=nm;
        bau=au;
        bpub=pub;
        bcat=cat;
        bpr=pr;
        bqn=qn;
    }
     public void actionPerformed(ActionEvent e)
     {
        Button b=(Button)e.getSource();
        if(b==baddb)
        {

              bnm=tbnm.getText();
              bau=tbau.getText();
              bpub=tbpub.getText();
              bcat=tbcat.getText();
              bpr=Integer.parseInt(tbpr.getText());
              bqn=Integer.parseInt(tbqn.getText());


            System.out.println(bnm+bau+bpub+bcat+bpr+bqn);
            BookInventory.getBookInfo(bnm,bau,bpub,bcat,bpr,bqn);

            this.dispose();
            
        }
        else if(b==bback)
        {
            // try
            // {
            //     D1.commit(bookList2);
            // }catch(Exception E){}   
            //     //f1=new BookInventory();
            this.dispose();
        }
    }
    // public static void getBookInfo(String bnm,String bau,String bpub,String bcat,int bpr,int bqn)
    // {
    //     Book B = new Book();
    //     B.setName(bnm);
    //     B.setAuthor(bau);
    //     B.setPub(bpub);
    //     B.setCategory(bcat);
    //     B.setPrice(bpr);
    //     B.setQuantity(bqn);

    //     Iterator it = bookList2.iterator();
        
    //     boolean flg = false;
    //     while(it.hasNext())
    //     {
    //         Book b1=(Book)it.next();

    //         if( b1.name.equals(B.getName())){
    //             b1.quantity +=B.getQuantity();
    //             flg = true;
    //         }
    //     }
    //     if(!flg)
    //         bookList2.add(B);
    // }
}