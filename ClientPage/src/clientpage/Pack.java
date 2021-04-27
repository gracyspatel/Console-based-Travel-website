package clientpage;

import clientpage.Login.CS_login;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.*;

public class Pack 
{
    
    
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/tour";
   
   static final String USER = "root";
   static final String PASS = "1234";
   
   

public void createfile1()
    {
        try 
        {  
            File file = new File("temp.txt");  
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
   void display(String ab) throws Exception
    {
     Scanner s = new Scanner(System.in);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
         
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
            stmt = conn.createStatement();
            String sql;
            
            sql = "SELECT Tour_ID, Tour_Name, Place_From, Place_To,Duration_days,Fare,Description,pack_det FROM tour";
            ResultSet rs = stmt.executeQuery(sql);
            String a =ab;
            String a1,a2;
            
            if(a.equals("National") || a.equals("national") || a.equals("n"))
            {
                System.out.println();
                System.out.println("*\t\t\tNATIONAL PACKAGES\t\t\t*");
                System.out.println();
                for(int i=0;i<21;i++)
                {
                    System.out.print("*-*");
                }
                System.out.println("");
                System.out.println("");
                System.out.println("");
                a="n";
                a1="National";
                a2="national";
            }
            else if(a.equals("International") || a.equals("international") || a.equals("i"))
            {
                System.out.println();
                System.out.println("*\t\t\tINTERNATIONAL PACKAGES\t\t\t*");
                System.out.println();
                for(int i=0;i<21;i++)
                {
                    System.out.print("*-*");
                }
                System.out.println("");
                System.out.println("");
                System.out.println("");
                a="i";
                a1="International";
                a2="international";
            }
            else
            {
                System.out.println("wrong choice..");
                for(int i=0;i<21;i++)
                {
                    System.out.print("*-*");
                }
                a=null;
                a1=null;
                a2=null;
            }
            
            
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
                
                if((pack_det.compareTo(a)==0) || (pack_det.compareTo(a1)==0) || (pack_det.compareTo(a2)==0))
                {
                System.out.println("*\t\t"+name+"\t\t*");
                 System.out.println("Tour ID :  "+id);
                 System.out.println("From : " + placef);
                 System.out.println("To : " + placeT);
                 System.out.println("No of Days : " + durationd);
                 System.out.println("Charges : " + fare);
                 System.out.println(dis);
                 System.out.println(pack_det+ " Package " );
                 System.out.println("  ");   
                }
            }
             
            for(int i=0;i<21;i++)
            {
                System.out.print("*-*");
            }
            
            Cart c = new Cart();
            c.add_cart();
        }
        catch(SQLException se)
        {                  
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            for(int i=0;i<21;i++)
            {
                System.out.print("*-*");
            }
            System.out.println();
            System.out.println();
            System.out.println("Do you want to book!!(yes/no)");
            String ch = s.nextLine();
            
            int a=1;
            File myObj = new File("temp.txt");
            if (a==1)
            {
                if(myObj.length()==0)
                {
                    createfile1();
                    System.out.println("Login before booking !!");
                    CS_login cs = new CS_login();
                    cs.log_c();
                    
                    if(ch.equals("yes") || ch.equals("Yes"))
                    {
                        Book b = new Book();
                        b.booking();
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Thank you!!");
                    }
                }
                else
                {
                    if(ch.equals("yes") || ch.equals("Yes"))
                    {
                        Book b = new Book();
                        b.booking();
                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Thank you!!");
                    }
                }
            } 
            else 
            {
                System.out.println();
                System.out.println("Thank you!!");
            }
          
        }
     
    }
}