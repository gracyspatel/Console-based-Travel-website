package adminpage.Login;

import java.util.Scanner;

public class Login_ma
{
    public int log_m()
    {
        
        Scanner sc = new Scanner(System.in);
        int n=0;
        while(n !=  5)
            {
                for(int i=0;i<21;i++)
                {
                    System.out.print("*-*");
                }
                System.out.println(""); 
                System.out.println("\t\t\t  MAIN MENU : ");
                System.out.println("1 :"+"LOGIN : ");
                System.out.println("2 :"+"EXIT : ");
    	
                for(int i=0;i<21;i++)
                {
                    System.out.print("*-*");
                }
                System.out.println(""); 
                System.out.println("Enter your choice :");
                n=sc.nextInt();
                System.out.println("");
                switch(n)
                {
                    case 1: 
                            for(int i=0;i<21;i++)
                            {
                                System.out.print("*-*");
                            }
                            System.out.println("");
                            System.out.println("Login :");
                            System.out.println("");
                            Login l = new Login();
                            int b=l.Log_main();
                            if(b==1)
                            {
                                return 1;
                            }
                            else
                            {
                                return 3;
                            }
                    case 2:
                        System.out.println("Thank you !!");
                        System.out.println("Exit");
                        for(int i=0;i<21;i++)
                        {
                            System.out.print("---");
                        }
                        System.out.println("");
                        return 0;
                    default :
                    {
                	System.out.println("WRONG CHOICE");
                	//System.out.println("Press any key to continue : ");
                    }
                }
            }
        return 0;
    }
}
