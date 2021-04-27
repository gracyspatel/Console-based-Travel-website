
package clientpage;

import clientpage.Login.CS_login;
import clientpage.Login.Sign_up;
import java.io.File;

public class ClientPage
{
    public static void main(String[] args) throws Exception
    {
        for(int i=0;i<21;i++)
        {
            System.out.print("*-*");
        }
        System.out.println("");
        System.out.println(":                    TRAVEL BOOKING SYSTEM                    :");
        System.out.println(":                    WELCOME TO TRAVELIN!!                    :");
        C_menu m = new C_menu();
        m.pack_menu1();
      
        File f= new File("temp.txt");
        f.delete();
        File f1= new File("cart.txt");
        f1.delete();
    }
    
}
