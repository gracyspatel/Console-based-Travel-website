package adminpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Input
{
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/tour";

   static final String USER = "root";
   static final String PASS = "1234";
   
    int get_id()
    {
        int t_id=0;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
            
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
            stmt = conn.createStatement();
            String sql;
            
            sql = "SELECT Tour_ID FROM tour";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                t_id=rs.getInt("Tour_ID");
            }
            t_id++;
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
           return t_id;
        }   
    }
    int input()
    {
        Scanner s = new Scanner(System.in);
        Input inp = new Input();
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
      
            System.out.println("Enter Package details :");   ///takes input
            System.out.println("\t\t\t---\t\t\t");
            
            System.out.print("New Tour ID is : ");
            int tourid = inp.get_id();
            System.out.println(tourid);
            System.out.println("");
            //int tourid =s.nextInt();
            //s.nextLine();
            System.out.println("Enter Tour Package Name :");
            String tourname =s.nextLine();
            System.out.println("");
            System.out.println("Enter the place of Departure :");
            String from =s.nextLine();
            System.out.println("");
            System.out.println("Enter the place of Destination :");
            String to = s.nextLine();
            System.out.println("");
            System.out.println("Enter number of days :");
            int days = s.nextInt();
            s.nextLine();
            System.out.println("");
            System.out.println("Enter Charges :");
            int fa =s.nextInt();
            s.nextLine();
            System.out.println("");
            System.out.println("Enter extra discription you would like to add :");
            String descri =s.nextLine();
            System.out.println("");
            System.out.println("Enter type of package (National or International): ");
            String pack_det =s.nextLine();
            
            java.sql.PreparedStatement p1 = conn.prepareStatement("insert into tour(Tour_ID, Tour_Name, Place_From, Place_To,Duration_days,Fare,Description,pack_det) values(?,?,?,?,?,?,?,?)");
            /*stmt.executeUpdate("INSERT INTO tour VALUES (6, 'Bombay_Mumbai', 'Vadodara', 'Mumbai', 3, '3 Days 3 Night', 7000, 'Everything included')");*/
            
            p1.setInt(1,tourid);  //dataase insert
            p1.setString(2,tourname);
            p1.setString(3, from);
            p1.setString(4, to);
            p1.setInt(5, days);
            p1.setInt(6, fa);
            p1.setString(7, descri);
            p1.setString(8, pack_det);
            
            int i = p1.executeUpdate();  //databse update
            
            if(i!=0)
            {
                System.out.println("");
                System.out.println("Package added successfully !!!");
                System.out.println("\t\t\t\t---");
                for(i=0;i<21;i++)
                {
                    System.out.print("---");
                } 
                System.out.println("");
                System.out.println("");
            }
            else
            {
                System.out.println("");
                System.out.println("Package failed to add");
                System.out.println("");
                for(i=0;i<21;i++)
                {
                    System.out.print("---");
                } 
                System.out.println();
                System.out.println("");
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
            return 0;
        }   
    }
}

