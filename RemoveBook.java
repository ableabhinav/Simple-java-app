import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class RemoveBook extends Frame implements ActionListener
{
     Button bback,brmb;
     Label lbnm;
     TextField tbnm;
     //Vector<Project> v;
      //Project f;
    ArrayList<Book> bookList2; 
    String bnm;
    int bqn;
    BookInventory f1;
    // Database D;
    public RemoveBook()
     {
        super("Book Info");
        this.bookList2 = bookList2;
        // D = new Database();
        lbnm=new Label("Name");
        lbnm.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbnm.setForeground(Color.GRAY);
        
        //tbnm,tbau,tbpub,tbcat,tbpr,tbqn;
        //v=new Vector<Project>();
       tbnm=new TextField(6);
       
        
        
        bback=new Button("Back");
        brmb=new Button("Remove");

        bback.addActionListener(this);
        brmb.addActionListener(this);

        setLayout(new GridLayout(3,2,10,10));
        //Label lbnm,lbau,lbpub,lbcat,lbpr,lbqn;
//tbnm,tbau,tbpub,tbcat,tbpr,tbqn;
         add(lbnm);
         add(tbnm);
         add(brmb);
         add(bback);

         setSize(350,350);
         setVisible(true);
     }
    //  String bnm;
    // String bau;
    // String bpub;
    // String bcat;
    // int bpr;
    // int bqn;
    RemoveBook(String nm)
    {
        bnm=nm;
        
    }
     public void actionPerformed(ActionEvent e)
     {
        Button b=(Button)e.getSource();
        if(b==brmb)
        {
            
        }
        else if(b==bback)
        {
            try
            {
                f1=new BookInventory();
            }catch(Exception E){}
            this.dispose();
        }
    }
}