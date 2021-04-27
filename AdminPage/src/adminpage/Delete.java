package adminpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Delete
{

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/tour";

   static final String USER = "root";
   static final String PASS = "1234";
   
    void delete()   //all delete
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you sure you want to delete all packages");
        System.out.println("yes or no");
        String ch = sc.nextLine();
        
        if(ch.equals("Yes") || ch.equals("yes"))
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = null;
                Statement stmt = null;
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
       
                Statement st = conn.createStatement();
                st.executeUpdate("DELETE FROM Tour");
                System.out.println("Successfully deleted all the packages !!");
                conn.close();
            }
            catch (Exception e)
            {
                System.out.println("Got an exception! ");
            System.out.println(e.getMessage());
            }
        }
    }
    void deleteid()  //id detlete
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
      
    
           
            Statement st = conn.createStatement();
            System.out.println("Enter ID");
            int id=sc.nextInt();
            st.executeUpdate("DELETE FROM Tour where Tour_ID="+id);
            System.out.println("Successfully deleted the package!!");
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println("Got an exception! ");
            System.out.println(e.getMessage());
        }
    }
    void deletename()  //parti name delete
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
      
    
           
            Statement st = conn.createStatement();
            System.out.println("Enter ID");
            String na = sc.nextLine();
            st.executeUpdate("DELETE FROM Tour where Tour_Name="+na);
            System.out.println("Successfully deleted the package !!");
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println("Got an exception! ");
            System.out.println(e.getMessage());
        }
    }
    void deletem()  //delete menu
    {
        Scanner sc = new Scanner(System.in);
       Delete d2 = new Delete();
       int n=0;
       while(n!=3)
       {
       for(int i=0;i<21;i++)
                {
                    System.out.print("---");
                } 
       System.out.println("");
       System.out.println("Delete Package by :");
       System.out.println("1."+"Tour ID");
       System.out.println("2."+"Tour Name");
       System.out.println("3."+"Exit");
       System.out.println("Enter your choice..");
       n = sc.nextInt();
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
                        d2.deleteid();
                        break;
                    case 2:
                        System.out.println("");
                        for(int i=0;i<21;i++)
                        {
                            System.out.print("*-*");
                        }
                        System.out.println("");
                        d2.deletename();
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
    }
}
