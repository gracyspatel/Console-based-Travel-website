package clientpage.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sign_up   //sign_up class
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/tour";

   static final String USER = "root";
   static final String PASS = "1234";
   
    public void sign_upf()  //sign up fun
    {
        Scanner s = new Scanner(System.in);
        for(int i=0;i<21;i++)
        {
            System.out.print("---");
        }
        System.out.println("");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
            
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
            stmt = conn.createStatement();
            String sql;
            
            sql = "SELECT * FROM customer_registration";
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("Enter Registration Details :");
            System.out.println("              ---             ");
            System.out.println("Enter Username_id:");
            String user_name =s.nextLine();  
            CS_login l = new CS_login();
            int i1 = l.check_user(user_name );
            if(i1==2)
            {
                System.out.println("Try Again!!!");
            }
            else
            {
                System.out.println("Enter Password:");
                String pass =s.nextLine();
                System.out.println("Enter First Name:");
                String f_name = s.nextLine();
                System.out.println("Enter Last Name:");
                String l_name = s.nextLine();
                System.out.println("Enter age:");
                int age = s.nextInt();
                s.nextLine();
                System.out.println("Enter Email-id:");
                String email =s.nextLine();
                        
                java.sql.PreparedStatement p1 = conn.prepareStatement("insert into customer_registration( User_name, Password,First_Name,Last_Name,Age,Email_Id) values(?,?,?,?,?,?)");
            
                p1.setString(1,user_name);
                p1.setString(2,pass);
                p1.setString(3, f_name);
                p1.setString(4, l_name);
                p1.setInt(5, age);
                p1.setString(6, email);
            
                int i = p1.executeUpdate();
                if(i!=0)
                {
                    System.out.println("");
                    System.out.println("Registraion Done !!");
                    System.out.println("Thank you for registration!!");
                    System.out.println("Login before booking !!");
                    for(i=0;i<21;i++)
                    {
                        System.out.print("---");
                    }
                    System.out.println("");
                }
                else
                {
                    System.out.println("");
                    System.out.println("failed to sign up");
                    for(i=0;i<21;i++)
                    {
                        System.out.print("---");
                    }
                    System.out.println("");
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
}
