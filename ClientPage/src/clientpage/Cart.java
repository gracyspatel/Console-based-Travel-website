package clientpage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.util.Scanner;
     import java.io.*;  

public class Cart   //cart class
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/tour";
   
    static final String USER = "root";
    static final String PASS = "1234";
    void createfile()
    {
        try 
        {  
            File file = new File("Cart.txt");  
            if(!file.exists())
            {
                file.createNewFile();
            }   
        }
        catch (IOException e)
        {  
            e.printStackTrace();  
        }    
    }
    void display_cart() throws Exception  //display cart
    {
        Scanner sc = new Scanner(System.in);
      File f1 = new File("Cart.txt"); 
      FileReader fr=new FileReader(f1);        
      BufferedReader br=new BufferedReader(fr);
      String s=null;
      for(int i=0;i<21;i++)
        {
            System.out.print("*-*");
        }
      System.out.println("");
      System.out.println("*\t\t\tCART*");
      System.out.println("");
      for(int i=0;i<21;i++)
        {
            System.out.print("---");
        }
      System.out.println("");
      System.out.println("All the details are :");
      while((s=br.readLine())!=null)            
        {
          System.out.println(s);
        }
        fr.close();
        for(int i=0;i<21;i++)
        {
            System.out.print("*-*");
        }
        System.out.println("");
        System.out.println("Do you want to book any package??(yes/no)");
        String c = sc.nextLine();
        
        if( c.equals("yes") || c.equals("Yes") )
        {
            Book b = new Book();
            b.booking();
        }
    }
    void add_cart()   //cart add
    {
        Pack l = new Pack();
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        
        System.out.println("Do you want to add to the cart (yes or no)");
        String  a = sc.nextLine();
        System.out.println("");
        
        if(a.equals("Yes") || a.equals("yes"))
        {
            String ch="yes";
            int t=0;
            Cart c =new Cart();
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    java.sql.Connection conn = null;
                    java.sql.Statement stmt = null;
            
                    conn = DriverManager.getConnection(DB_URL,USER,PASS);
                    stmt = conn.createStatement();
                    String sql;
                    
                    c.createfile();
                    File f1 = new File("Cart.txt");  
                    FileWriter fw= new FileWriter(f1,true); 
                    BufferedWriter fr1 = new BufferedWriter(fw);  
                    
                    while(ch.equals("yes") ||ch.equals("Yes"))
                    {
                        System.out.println("Enter tour Package number:");
                        t=sc.nextInt();
                        
                        sql = "Select * from tour where Tour_ID="+t;
                        java.sql.ResultSet rs = stmt.executeQuery(sql);
                        
                        while(rs.next())
                        {               
                            
                        int id  = rs.getInt("Tour_ID");
                        String name = rs.getString("Tour_Name");
                        String placef = rs.getString("Place_From");
                        String placeT = rs.getString("Place_To");
                        int durationd = rs.getInt("Duration_days");
                        int fare = rs.getInt("Fare");
                        String dis = rs.getString("Description");
                        String pack_det = rs.getString("pack_det");
                             
                                            
                        String str=null;
                        str=Integer.toString(id);
                        fw.write(str);
                        fw.write("\n");
                        fw.write(name);
                        fw.write("\n");
                        fw.write(placef);
                        fw.write("\n");
                        fw.write(placeT);
                        str=Integer.toString(durationd);
                        fw.write("\n");
                        str=Integer.toString(fare);
                        fw.write("\n");
                        fw.write(str);
                        fw.write("\n");
                        fw.write(dis);
                        fw.write("\n");
                        fw.write(pack_det);
                        }
                        System.out.println("");
                        System.out.println("Package successfully added to the cart !!");
                        System.out.println("");
                        System.out.println("Do you want o add anything else to the cart??(yes/no)");
                        sc.nextLine();
                        ch=sc.nextLine();
                        System.out.println("");
                        if(ch.equals("no") ||ch.equals("No"))
                        {
                            break;
                        }
       
                    }
                    fw.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
        }       
    }
}