package adminpage;//login& signup cli
import adminpage.Login.Login;  //login import
import adminpage.Login.Login_ma;


public class Adminpage 
{
    public static void main(String[] args)
    {	
        for(int i=0;i<21;i++)
        {
            System.out.print("*-*");
        }
        System.out.println("");
        System.out.println("\t\t\t  Admin\t\t");
        System.out.println("");
        for(int i=0;i<21;i++)
        {
            System.out.print("*-*");
        }
        System.out.println(""); 
        
        Login_ma l1 = new Login_ma();   //Login functiom
        int a=l1.log_m();
        
        while(a!=-1)
        {
         
            if(a==1)
            {
                System.out.println("");
                
                for(int i=0;i<21;i++)
                {
                    System.out.print("*-*");
                }
                System.out.println(""); 
                Menu m = new Menu();   //Main Menu() call if succcess
                m.menu_st();
                break;
            }
            else if(a==3)
            {
                System.out.println("");
                System.out.println("Incorrect ID or password!!!");
                for(int i=0;i<21;i++)
                {
                    System.out.print("*-*");
                }
                System.out.println(""); 
                System.out.println("");
                System.out.println("Login Again");
                System.out.println("");
                a=l1.log_m();   //login agail
            }
            else
            {
                a=-1;
                break;
            }
        }
    }
}
