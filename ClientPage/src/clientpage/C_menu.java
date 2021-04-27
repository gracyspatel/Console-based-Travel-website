package clientpage; 

import clientpage.Login.CS_login;
import java.io.File;
import java.util.Scanner;

public class C_menu
{
    public void pack_menu1()throws Exception
    {
            Scanner sc = new Scanner(System.in);   //main menu
            int n=0;
            while(n != 6)
            {
                System.out.println("");
                for(int i=0;i<21;i++)
                {
                    System.out.print("*-*");
                }
                System.out.println("");
                System.out.println(":                         MAIN MENU:                          :");
                for(int i=0;i<21;i++)
                {
                    System.out.print("-.-");
                }
                System.out.println("");
                System.out.println(": 1 :"+" HOME :                                                  :");
                System.out.println(": 2 :"+" PACKAGES :                                              :");
                System.out.println(": 3 :"+" LOGIN AND SIGNUP :                                      :");
                System.out.println(": 4 :"+" CART :                                                  :");
                System.out.println(": 5 :"+" ABOUT US :                                              :");
                System.out.println(": 6 :"+" EXIT :                                                  :");
                
                for(int i=0;i<21;i++)
                {
                    System.out.print("-.-");
                }
                System.out.println("");
                System.out.println("Enter your choice..");
                n=sc.nextInt();
                System.out.println("");
                switch(n)
                {
                    case 1:
                        n=1;
                        break;
                    case 2:
                        C_Menus a = new C_Menus();
                        a.pack_menu1();
                        n=2;
                        break;
                    case 3:
                        CS_login cs = new CS_login();
                        cs.login_menu();
                        n=3;
                        break;
                    case 4: 
                        Cart c = new Cart();
                        c.display_cart();
                        n=4;
                        break;
                    case 5: 
                        Contact c1 = new Contact();
                        c1.cont();
                        n=5;
                        break;
                    case 6:
                        File f= new File("temp.txt");
                        f.delete();
                        System.out.println("Thnak you for visiting!!");
                        for(int i=0;i<21;i++)
                        {
                            System.out.print("---");
                        }
                        System.out.println("");
                        //file delete login details nd cart details
                        n=6;
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
}
