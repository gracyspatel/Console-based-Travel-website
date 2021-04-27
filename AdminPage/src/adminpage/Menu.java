package adminpage;
import java.util.Scanner;

class Menu
{
	int id1;
	int n=1;

        Pack1 p1 = new Pack1();
 
    void menu_st()
	{
            Scanner sc = new Scanner(System.in);
  
            while(n !=  5)
            {
                for(int i=0;i<21;i++)
                {
                    System.out.print("---");
                } 
                System.out.println();
                System.out.println("\t\t\t  MAIN MENU : ");
                for(int i=0;i<21;i++)
                {
                    System.out.print("---");
                } 
                System.out.println();
                for(int i=0;i<21;i++)
                {
                    System.out.print("---");
                }
                System.out.println();
                System.out.println("1 :"+"ADD : ");
                System.out.println("2 :"+"DISPLAY : ");
                System.out.println("3 :"+"MODIFY : ");
                System.out.println("4 :"+"DELETE : ");
                System.out.println("5 :"+"EXIT : ");
                for(int i=0;i<21;i++)
                {
                    System.out.print("*-*");
                } 
                System.out.println("");
                //System.out.println("");
                System.out.println("Enter your choice..");
                n=sc.nextInt();
        
                switch(n)
                {
                    case 1: 
                        System.out.println("");
                        for(int i=0;i<21;i++)
                        {
                            System.out.print("*-*");
                        }
                        System.out.println("");
                        p1.input_menu();    //Adding data
                        break;
                    case 2:
                        p1.output_menu();   //Display data
                        break;
                    case 3: 
                        p1.modify();  //changes if any
                        break;
                    case 4: 
                        p1.remove_menu();  //data remove
                        break;
                    case 5:
                        System.out.println("");
                        for(int i=0;i<21;i++)
                        {
                            System.out.print("*-*");
                        }
                        System.out.println("");
                        System.out.println("Thank you !!");
                        System.out.println("Exit");
                        for(int i=0;i<21;i++)
                        {
                            System.out.print("---");
                        }
                        System.out.println("");
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