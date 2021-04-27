package clientpage.Login;
import clientpage.C_menu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CS_login  //class login
{
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/tour";
   static final String USER = "root";
   static final String PASS = "1234";
   String st = null;
   public void set_id(String a)
   {
       st=a;
   }
   public String get_Login() throws Exception  
   {
       String abc=null;
      File f1 = new File("temp.txt"); 
      FileReader fr= new FileReader(f1);        
      BufferedReader br=new BufferedReader(fr);
      String s=null;
      while((s=br.readLine())!=null)            
        {
            abc = s;
            break;
          //System.out.println(s);
        }
        fr.close();
        return abc;
   }
   public void login_menu() throws Exception
   {
       Scanner sc = new Scanner(System.in);
        int n=0;
            while(n !=  1)
            {
                
                for(int i=0;i<21;i++)
                {
                    System.out.print("+++");
                }
                System.out.println("");
                System.out.println("1 :"+" HOME : ");
                System.out.println("2 :"+" LOGIN : ");
                System.out.println("3 :"+" SIGNUP : ");
                for(int i=0;i<21;i++)
                {
                    System.out.print("+++");
                }
                System.out.println("");
                System.out.println("Enter your choice..");
                n=sc.nextInt();
        
                switch(n)
                {
                    case 1:
                        break;
                    case 2:
                        CS_login s1 = new CS_login();
                        int z=s1.log_c();
                        if(z==0)
                        {
                            for(int i=0;i<21;i++)
                            {
                                System.out.print("---");
                            }
                            System.out.println("");
                            System.out.println("Login Failed");
                            System.out.println("Did you forgot your id / password??(yes/no)");
                            sc.nextLine();
                            String a = sc.nextLine();
                            
                            if(a.equals("yes") || a.equals("Yes") ||a.equals("YES"))
                            {
                                
                                System.out.println("Sign up Again");
                                Sign_up s = new Sign_up();
                                s.sign_upf();
                                n=1;
                            }
                            else if(a.equals("No") || a.equals("NO") || a.equals("no"))
                            {
                                System.out.println("Do you want to login again?? (Yes/No)");
                                String b = sc.nextLine();
                                if(b.equals("yes") || b.equals("Yes") ||b.equals("YES"))
                                {
                                    System.out.println("Login Again");
                                    n=2;
                                    break;
                                }
                                else
                                {
                                    for(int i=0;i<21;i++)
                                    {
                                        System.out.print("+++");
                                    }
                                    System.out.println("");
                                    System.out.println("Sorry!! ");
                                    n=1;
                                }
                            }
                            else
                            {
                                for(int i=0;i<21;i++)
                                {
                                    System.out.print("+++");
                                }
                                System.out.println("");
                                System.out.println("Sorry!! ");
                                n=1;
                            }
                        }
                        else
                        {
                            n=1;
                        }
                        break;
                    case 3:
                        Sign_up s = new Sign_up();
                        s.sign_upf();
                        break;
                    default :
                    {
                	System.out.flush();
                        System.out.println("WRONG CHOICE");
                	System.out.println("Press any key to continue : ");
                    }
                }
            } 
   }
   public int check_user(String str)   //check id user exist
   {
       int i=0;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = null;
                Statement stmt = null;
           
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
                stmt = conn.createStatement();
                String sql;
                
                sql = "SELECT User_name FROM customer_registration";
                ResultSet rs = stmt.executeQuery(sql);
                
                while(rs.next())
                {
                    String name = rs.getString("User_name");
                    
                    if(name.equals(str))
                    {
                        System.out.println("Username Already exist!!!");
                        System.out.println("Try another Username!!");
                        i=2;
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
            
       return i;
   }
   public void savelog1(String id, String pass)  //writes to file
   {
        try
        {
         BufferedWriter t1 = new BufferedWriter(new FileWriter("temp.txt"));
         t1.write(id);
         t1.write("\n");
         t1.write(pass);
         t1.write("\n");
         t1.close();
         System.out.println("");
      }
      catch (IOException e) {
      }
   }
   public int log_c()  //login fun
   {
       int f=0;
       Scanner s = new Scanner(System.in);
       CS_login c = new CS_login();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
           
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
    
            stmt = conn.createStatement();
            String sql;
            
            sql = "SELECT User_name, Password FROM customer_registration";
            ResultSet rs = stmt.executeQuery(sql);
      
            System.out.println("");
                for(int i=0;i<21;i++)
                {
                    System.out.print("---");
                }
            System.out.println("");
               
            System.out.println("Enter your id/username :");
            String id1 = s.nextLine();
            st=id1;
            System.out.println("Enter your password");
            String pass1 = s.nextLine();
            
            while(rs.next())
            {
         
                String id  = rs.getString("User_name");
                String pass = rs.getString("Password");
                
                if( id.equals(id1) && pass.equals(pass1))
                {
                    for(int i=0;i<21;i++)
                    {
                        System.out.print("---");
                    }
                    System.out.println("");
                    c.savelog1(id,pass);
                    System.out.println("Login Successful");
                    System.out.println("Thank you for Login!!!");
                    for(int i=0;i<21;i++)
                    {
                        System.out.print("---");
                    }
                    f=1;
                    break;
                }
                else
                {
                    f=0;
                    continue;
                }
            }
            if(f==0)
            {
                    System.out.println("lOGIN FAILED");
                    
                    System.out.println("Do you want to sign up (yes or no)");
                    String ab = s.nextLine();
                    
                    if(ab.equals("yes") || ab.equals("Yes"))
                    {
                        Sign_up s1 = new Sign_up();
                        s1.sign_upf();
                    }
                    else
                    {
                        CS_login f0 = new CS_login();
                        f0.login_menu();
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
       return f;
    }
}   