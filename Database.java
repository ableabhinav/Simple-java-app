import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
class Book 
{
    
    public String name;
    public String author;
    public String publication;
    public String category;
    public int price;
    public int quantity;
    Book()
    {
        name = "";
        author = "";
        category = "";
        publication = "";
        quantity = 0;
        price = 0;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public void setPub(String publication)
    {
        this.publication = publication;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public String getName()
    {
        return this.name;
    }
    public String getAuthor()
    {
        return this.author;
    }
    public String getPub()
    {
        return this.publication;
    }
    public String getCategory()
    {
        return this.category;
    }
    public int getPrice()
    {
        return this.price;
    }
    public int getQuantity()
    {
        return this.quantity;
    }
}
public class Database
{  
	// public ArrayList<Book> bookListMain = new ArrayList<Book>(); //main booklist to store and retrieve, send this booklist  
	public Connection con;
    Database()throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("jdbc connected!!");  
        con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookInventory","root","alaska");            
    	// return con;        
    }

    public ArrayList<Book> retrieve()  
    {
    	ArrayList<Book> booklist = new ArrayList<>();
        System.out.println("Inside retrieve function");  
        try
        {
            Statement stmt=con.createStatement(); 
            ResultSet rs=stmt.executeQuery("select * from books");  
            while(rs.next())  
            {
               Book B = new Book();
               // B.setID(rs.getInt(1)) 
               B.setName(rs.getString(1));
               B.setAuthor(rs.getString(2));
               B.setCategory(rs.getString(3));
               B.setPub(rs.getString(4));
               B.setQuantity(rs.getInt(5));     
               B.setPrice(rs.getInt(6));
               booklist.add(B); 
            }  
              
        }
        catch(Exception e)
        { 
            System.out.println(e);
        }  
        return booklist;
    }
    public void commit(ArrayList<Book> bookList) throws Exception
    {
        System.out.println("Inside commit function");
        // Statement stmt2=con.createStatement();
        Statement stmt1=con.createStatement();
        int j = stmt1.executeUpdate("truncate books");
        //PreparedStatement stmt=con.prepareStatement("insert into books values(?,?,?,?,?,?)");  
        // Iterator it = bookList.iterator();
        int k = 0,s=0;
        for(int i=0; i<bookList.size(); i++)
        {   
            PreparedStatement stmt=con.prepareStatement("insert into books values(?,?,?,?,?,?)");  
            // stmt.setInt(1,it.id);//1 specifies the first parameter in the query              
            stmt.setString(1,bookList.get(i).getName());
            stmt.setString(2,bookList.get(i).getAuthor());
            stmt.setString(3,bookList.get(i).getCategory());
            stmt.setString(4,bookList.get(i).getPub());
            stmt.setInt(5,bookList.get(i).getQuantity());
            stmt.setInt(6,bookList.get(i).getPrice());
            s=stmt.executeUpdate();
            k++;
        }    
        System.out.println(" records inserted");  
        
        con.close();  
    }  
    /*public static void main(String[] args)throws Exception
    {
        Database D = new Database();
        ArrayList<Book> bk = D.retrieve();
        ListIterator<Book> it = bk.listIterator();
        while(it.hasNext())
        {
            Book b = it.next();
            System.out.println(b.getName());
        }
        D.commit(bk);
    }*/
    public static void main(String[]args) throws Exception
    {
    	Database D = new Database();
        ArrayList<Book> bookListMain = D.retrieve();
        BookInventory f1=new BookInventory(bookListMain,D);
 		    
        // f1.setDatabase(D);
    }
}  

class BookInventory extends Frame implements ActionListener
{
     //Project f;
     // static BookInventory f1;
    static Database D1;
    AddBook f2;
    RemoveBook f3;
    Button badd,bvw,brm,bexit;
    
    static ArrayList<Book> bookList2;

     // public void setDatabase(Database D1)
     // {
     //    this.D1 = D1;
     // }
  //   BookInventory() throws Exception 
  //   {
  //       super("Operations");
        
		// // Connection con = Database.connect();
  //       // bookList2=Database.retrieve();
  //       // this.D1 = D1;
  //       badd=new Button("Add Book");
  //       bvw=new Button("View Books");
  //       brm=new Button("Remove Book");
  //       bexit=new Button("Logout");
  //       badd.addActionListener(this);
  //       bvw.addActionListener(this);
  //       brm.addActionListener(this);
  //       bexit.addActionListener(this);
  //       setLayout(new GridLayout(4,1,10,10));

  //       add(badd);
  //       add(bvw);
  //       add(brm);
  //       add(bexit);
  //       setSize(300,250);
  //       setVisible(true);
  //   }
    BookInventory() throws Exception 
    {
        super("Operations");
     	// this.bookList2 = bookList2;   
		// Connection con = Database.connect();
        // bookList2=Database.retrieve();
        // this.D1 = D1;
        badd=new Button("Add Book");
        bvw=new Button("View Books");
        brm=new Button("Remove Book");
        bexit=new Button("Logout");
        badd.addActionListener(this);
        bvw.addActionListener(this);
        brm.addActionListener(this);
        bexit.addActionListener(this);
        setLayout(new GridLayout(4,1,10,10));

        add(badd);
        add(bvw);
        add(brm);
        add(bexit);
        setSize(300,250);
        setVisible(true);
    }
    BookInventory(ArrayList<Book> bookList2,Database D1) throws Exception 
    {
        super("Operations");
     	this.bookList2 = bookList2;   
		// Connection con = Database.connect();
        // bookList2=Database.retrieve();
        this.D1 = D1;
        badd=new Button("Add Book");
        bvw=new Button("View Books");
        brm=new Button("Remove Book");
        bexit=new Button("Logout");
        badd.addActionListener(this);
        bvw.addActionListener(this);
        brm.addActionListener(this);
        bexit.addActionListener(this);
        setLayout(new GridLayout(4,1,10,10));

        add(badd);
        add(bvw);
        add(brm);
        add(bexit);
        setSize(300,250);
        setVisible(true);
    }
    public static void getBookInfo(String bnm,String bau,String bpub,String bcat,int bpr,int bqn)
    {
        Book B = new Book();
        B.setName(bnm);
        B.setAuthor(bau);
        B.setPub(bpub);
        B.setCategory(bcat);
        B.setPrice(bpr);
        B.setQuantity(bqn);

        Iterator it = bookList2.iterator();
        
        boolean flg = false;
        while(it.hasNext())
        {
            Book b1=(Book)it.next();

            if( b1.name.equals(B.getName())){
                b1.quantity +=B.getQuantity();
                flg = true;
            }
        }
        if(!flg)
            bookList2.add(B);
        // try
        // {
        //     D1.commit(bookList2);
        // }catch(Exception E){}
        
    }
    public static void getBookInfoToRemove(String bnm,int bqn)
    {
        // Book B = new Book();
        // B.setName(bnm);
        // B.setAuthor(bau);
        // B.setPub(bpub);
        // B.setCategory(bcat);
        // B.setPrice(bpr);
        // B.setQuantity(bqn);

        Iterator it = bookList2.iterator();
        
         boolean flg = false;
        while(it.hasNext())
        {
            Book b1=(Book)it.next();

            if( b1.name.equals(bnm))
            {

                if(b1.getQuantity()>bqn)
                    b1.quantity -=bqn;
                else
                    JOptionPane.showMessageDialog(null,"Given quantity of book is not available");
                flg = true;
            }
        }
        if(!flg)
            JOptionPane.showMessageDialog(null,"Given book is not available");
        // if(!flg)
        //     bookList2.add(B);
        // try
        // {
        //     D1.commit(bookList2);
        // }catch(Exception E){}
        
    }
    public void actionPerformed(ActionEvent e1)
    {
        Button b=(Button)e1.getSource();
        
        if(b==brm)
        {
            f3=new RemoveBook();
            //this.dispose();
        }
        if(b==badd)
        {
            
             f2=new AddBook();
            //this.dispose();

        }
        if(b==bvw)
        {
 
           // bookList2[0].getName();
        	String str="";
        	for(int i=0; i<bookList2.size(); i++)
        		str+=bookList2.get(i).getName()+bookList2.get(i).getQuantity()+"\n";
            JOptionPane.showMessageDialog(null,str);

        }
        if(b==bexit)
        {
            try
        {
            D1.commit(bookList2);
        }catch(Exception E){}
            //f=new Project();
            this.dispose();
            
        }

    }
}
