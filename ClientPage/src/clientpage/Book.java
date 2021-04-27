package clientpage;
import clientpage.Login.CS_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Date;

public class Book
{
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/tour";
   
   static final String USER = "root";
   static final String PASS = "1234";
   void credit()
   {
       for(int i=0;i<21;i++)
        {
            System.out.print("*-*");
        }
        System.out.println("");
       System.out.println("");
        System.out.println("Enter you Credit details");
       Scanner s = new Scanner(System.in);
       System.out.println(""); 
       try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
            
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
            stmt = conn.createStatement();
            String sql;
            
            sql = "SELECT * FROM Credit";
            ResultSet rs = stmt.executeQuery(sql);
      
             
            System.out.println("Enter Credit Card No:");
            int Credit_no =s.nextInt();
            s.nextLine();
            System.out.println("Enter NAME:");
            String name =s.nextLine();
            System.out.println("Enter your ipin:");
            String ipin = s.nextLine();
            
            java.sql.PreparedStatement p1 = conn.prepareStatement("insert into Credit(Credit_No,Name) values(?,?)");

            p1.setInt(1,Credit_no);
            p1.setString(2, name);
            
            int i = p1.executeUpdate();
            if(i!=0)
            {
                System.out.println("");
                System.out.println("");
                System.out.println("Booking done  successfully");
                }
            else
            {
                System.out.println("failed to book");
            }
        }
        catch(SQLException se)
        {                  
                //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally
        {
        } 
   }
   String real_date()
   {
       Date date = new Date();
       //System.out.println(date.toString());
       String dt = date.toString();
       return dt;
   }
   int getamt(int p)
   {
       int amt=0;
       int count =0;
       try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
           
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
            stmt = conn.createStatement();
            String sql;
            
            sql = "SELECT Fare FROM tour";
            ResultSet rs = stmt.executeQuery(sql);
      
             while(rs.next())
            {
                count++;
                amt  = rs.getInt("Fare");
                if(p==count)
                {
                    break;
                }
               // System.out.println("Fare : " + amt);
                //System.out.println("  ");
            }
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
            return amt;
        }   
   }
   String get_pname(int p)
   {
       String p_n=null;
       int count =0;
       try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
           
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
            stmt = conn.createStatement();
            String sql;
            
            sql = "SELECT Tour_Name FROM tour";
            ResultSet rs = stmt.executeQuery(sql);
      
             while(rs.next())
            {
                count++;
                p_n  = rs.getString("Tour_Name");
                if(p == count)
                {
                    break;
                }
            }
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
            return p_n;
        }   
   }
   int getBookId()
   {
       int id=0;
       try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
            
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
            stmt = conn.createStatement();
            String sql;
            
            sql = "SELECT Book_id FROM package_booking";
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next())
            {
         
                id  = rs.getInt("Book_id");
            }
             id++;
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
            return id;
        }   
   }
   int t=0;
   void sett(int p)
   {
       this.t=p;
   }
   int get_t()
   {
       return t;
   }
    void booking()
    {
        System.out.println("Enter Your Details");
        Book b = new Book();
        Scanner s = new Scanner(System.in);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
            
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
            stmt = conn.createStatement();
            String sql;
            
            sql = "SELECT * FROM package_booking";
            ResultSet rs = stmt.executeQuery(sql);
      
             
            System.out.println("Enter the package number you would like to book :");
            int p_id = s.nextInt();
            
            sett(p_id);
            System.out.print("Your Book id is      :");
            int book_id = b.getBookId();
            int b12=book_id;
            System.out.println(book_id);
            
            String bookdate = b.real_date();  //real time book
            
            //System.out.print("Your id is: ");  //login_id -left
            CS_login ab1 = new CS_login();
            String c_id = ab1.get_Login();
            System.out.print("Your id is         ");
            System.out.println(c_id);
            
            System.out.println("Enter your name:"); 
            s.nextLine();
            String y_name = s.nextLine();
            
            //System.out.println("Enter Package_name:");
            System.out.println("The package you like to book is :");
            System.out.println("ID :   " +p_id );
            int a=p_id;
            String p_name=b.get_pname(p_id);
            System.out.println("Package Name :  " +p_name );
            
            System.out.println("Enter the date you like to travel (yyyy/mm/dd):");
            String det =s.nextLine();
            
            System.out.println("Enter No. of members :");
            int no_of_per =s.nextInt();
            s.nextLine();
            
            
            int amt = getamt(p_id);
            //int amt =s.nextInt();
            //s.nextLine();
            
            System.out.print("Total charges are : Rs ");
            int t_amt = amt*no_of_per;
            System.out.println(t_amt);
            
            System.out.println("");
            System.out.println("");
            Book b1 = new Book();
            b1.credit();
                
            java.sql.PreparedStatement p1 = conn.prepareStatement("insert into package_booking(Book_id, Book_date, Customer_id, Customer_name,Package_name,Journey_date, No_of_Person,Amount) values(?,?,?,?,?,?,?,?)");

            p1.setInt(1,book_id);
            //p1.setDate(2,java.sql.Date.valueOf(bookdate));
            p1.setString(2,bookdate);
            p1.setString(3, c_id);
            p1.setString(4, y_name);
            p1.setString(5, p_name);
            //p1.setString(6, det);
            p1.setDate(6,java.sql.Date.valueOf(det));
            p1.setInt(7, no_of_per);
            p1.setInt(8, amt);
            
            int i = p1.executeUpdate();
            if(i!=0)
            {
                System.out.println("Thank you for booking !!!");
                for(int j=0;j<21;j++)
                {
                    System.out.print("*-*");
                }
                System.out.println("");
                Pdf pd = new Pdf();
                pd.Mail(b12,a);
                pdf123 p = new pdf123();
                p.Mail(b12,a);
            }
            else
            {
                System.out.println("failed to Book");
            }
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
           
        } 
    }
}