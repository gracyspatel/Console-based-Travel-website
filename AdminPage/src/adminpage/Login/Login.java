package adminpage.Login;
import java.io.Console; 
import java.util.Scanner;

public class Login
{
    int Log_main()
    {
        String pass=null;
        String aid= null;
        try
        {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter Id: ");
            String ch1 = sc.nextLine();
            System.out.println("Enter password: ");    
            String ch2= sc.nextLine();
       
            aid=String.valueOf(ch1);
            pass=String.valueOf(ch2);
            
        }
        catch(Exception e)
        {
         //exception   
        }
        finally
        {
            if (pass.equals("1234") && aid.equals("dcs"))
            {   
                System.out.println("");
                System.out.println("Login Successful!!");
                return 1;
            }
        }
        return 0;
    }
}