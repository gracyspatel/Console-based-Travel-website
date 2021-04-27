package clientpage;
import java.util.Scanner;

public class C_Menus  //package menu
{
    void pack_menu1() throws Exception
    {
            Scanner sc = new Scanner(System.in);
        int n=0;
            while(n !=  4)
            {
                for(int i=0;i<21;i++)
                {
                    System.out.print("*-*");
                }
                System.out.println("");
                System.out.println("MAIN MENU : ");
                for(int i=0;i<21;i++)
                {   
                    System.out.print("---");
                }
                System.out.println("");
                System.out.println("1 :"+" HOME : ");
                System.out.println("2 :"+" NATIONAL PACKAGES : ");
                System.out.println("3 :"+" INTERNATIONAL PACKAGES :  ");
                System.out.flush();
                for(int i=0;i<21;i++)
                {   
                    System.out.print("*-*");
                }
                System.out.println("");
                System.out.println("Enter your choice..");
                n=sc.nextInt();
                System.out.println("");
                switch(n)
                {
                    case 1:
                        n=4;
                        break;
                    case 2:
                        Pack b = new Pack();
                        b.display("National");
                        break;
                    case 3:
                        Pack b1 = new Pack();
                        b1.display("International");
                        break;
                    case 4:
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
