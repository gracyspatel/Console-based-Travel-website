package adminpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Display 
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/tour";
   
   static final String USER = "root";
   static final String PASS = "1234";
   
   void display_n()
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
           
            System.out.println();
            System.out.println("*\t\t\tNATIONAL PACKAGES\t\t\t*");
            System.out.println();
            int flag=0;
             while(rs.next())
            {
         
                int id  = rs.getInt("Tour_ID");
                String name = rs.getString("Tour_Name");
                String placef = rs.getString("Place_From");
                String placeT = rs.getString("Place_To");
                int durationd = rs.getInt("Duration_days");
                int fare = rs.getInt("Fare");
                String dis = rs.getString("Description");
                String pack_det1 = rs.getString("pack_det");

                if(pack_det1.equals("n") || pack_det1.equals("Natinal") || pack_det1.equals("national"))
                {
                 System.out.println("*\t\t"+name+"\t\t*");
                 System.out.println("Tour ID :  "+id);
                 System.out.println("From : " + placef);
                 System.out.println("To : " + placeT);
                 System.out.println("No of Days : " + durationd);
                 System.out.println("Charges : " + fare);
                 System.out.println(dis);
                 System.out.println(pack_det1+ " Package " );
                 System.out.println("  ");   
                 flag=0;
                 continue;
                }
                else
                {
                    flag=1;
                    continue;
                }
            }
             if(flag==1)
             {
                 System.out.println("No package found");
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
   }
   void display_i()
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
            System.out.println();
            System.out.println("*\t\t\tINTERNATIONAL PACKAGES PACKAGES\t\t\t*");
            System.out.println();
             while(rs.next())
            {
         
                int id  = rs.getInt("Tour_ID");
                String name = rs.getString("Tour_Name");
                String placef = rs.getString("Place_From");
                String placeT = rs.getString("Place_To");
                int durationd = rs.getInt("Duration_days");
                int fare = rs.getInt("Fare");
                String dis = rs.getString("Description");
                String pack_det1 = rs.getString("pack_det");

                if(pack_det1.equals("i") || pack_det1.equals("International") || pack_det1.equals("international"))
                {
                 System.out.println("*\t\t"+name+"\t\t*");
                 System.out.println("Tour ID :  "+id);
                 System.out.println("From : " + placef);
                 System.out.println("To : " + placeT);
                 System.out.println("No of Days : " + durationd);
                 System.out.println("Charges : " + fare);
                 System.out.println(dis);
                 System.out.println(pack_det1+ " Package " );
                 System.out.println("  ");   
                }
                else
                {
                    System.out.println("No Record found");
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
   }
   void displayid()
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
            System.out.println("Enter Tour ID :");
            int idt = s.nextInt();
             while(rs.next())
            {
         
                int id  = rs.getInt("Tour_ID");

                String name = rs.getString("Tour_Name");
                String placef = rs.getString("Place_From");
                String placeT = rs.getString("Place_To");
                int durationd = rs.getInt("Duration_days");
                int fare = rs.getInt("Fare");
                String dis = rs.getString("Description");
                String pack_det1 = rs.getString("pack_det");

                if(idt==id)
                {
                 System.out.println("*\t\t"+name+"\t\t*");
                 System.out.println("Tour ID :  "+id);
                 System.out.println("From : " + placef);
                 System.out.println("To : " + placeT);
                 System.out.println("No of Days : " + durationd);
                 System.out.println("Charges : " + fare);
                 System.out.println(dis);
                 System.out.println(pack_det1+ " Package " );
                 System.out.println("  ");   
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
   }
   void displayname()  // search by package name
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
            System.out.println("Enter Tour Package Name :");
            String namet = s.nextLine();
             while(rs.next())
            {
         
                int id  = rs.getInt("Tour_ID");
                String name = rs.getString("Tour_Name");
                String placef = rs.getString("Place_From");
                String placeT = rs.getString("Place_To");
                int durationd = rs.getInt("Duration_days");
                int fare = rs.getInt("Fare");
                String dis = rs.getString("Description");
                String pack_det1 = rs.getString("pack_det");

                if(name.equals(namet))
                {
                 System.out.println("*\t\t"+name+"\t\t*");
                 System.out.println("Tour ID :  "+id);
                 System.out.println("From : " + placef);
                 System.out.println("To : " + placeT);
                 System.out.println("No of Days : " + durationd);
                 System.out.println("Charges : " + fare);
                 System.out.println(dis);
                 System.out.println(pack_det1+ " Package " );
                 System.out.println("  ");   
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
   }
   void display1()  //menu fun
   {
       Scanner sc = new Scanner(System.in);
       Display d1 = new Display();
       for(int i=0;i<21;i++)
                {
                    System.out.print("---");
                } 
       System.out.println("");
       System.out.println("Serach Package by :");
       System.out.println("1."+"Tour ID");
       System.out.println("2."+"Tour Name");
       System.out.println("3."+"Exit");
       System.out.println("Enter your choice..");
       int n = sc.nextInt();
       System.out.println("");
       
       switch(n)
                {
                    case 1: 
                        System.out.println("");
                        for(int i=0;i<21;i++)
                        {
                            System.out.print("*-*");
                        }
                        System.out.println("");
                        d1.displayid();
                        break;
                    case 2:
                        System.out.println("");
                        for(int i=0;i<21;i++)
                        {
                            System.out.print("*-*");
                        }
                        System.out.println("");
                        d1.displayname();
                        break;
                    case 3:
                        break;
                    default :
                    {
                        System.out.println("WRONG CHOICE");
                	//System.out.println("Press any key to continue : ");
                    }
                }
   }
    void display2()   //display alll
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
      
             while(rs.next())
            {
         
                int id  = rs.getInt("Tour_ID");
                String name = rs.getString("Tour_Name");
                String placef = rs.getString("Place_From");
                String placeT = rs.getString("Place_To");
                int durationd = rs.getInt("Duration_days");
                int fare = rs.getInt("Fare");
                String dis = rs.getString("Description");
                String pack_det1 = rs.getString("pack_det");

         
                System.out.println("*\t\t"+name+"\t\t*");
                System.out.println("Tour ID :  "+id);
                System.out.println("From : " + placef);
                System.out.println("To : " + placeT);
                System.out.println("No of Days : " + durationd);
                System.out.println("Charges : " + fare);
                System.out.println(dis);
                System.out.println(pack_det1+ " Package " );
                System.out.println("  ");

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
    }
    
}
