package adminpage;

import com.mysql.jdbc.PreparedStatement;
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Pack1 
{
    void input_menu()  //input menu
    {
        Input t = new Input();
        t.input();
    }
    void modify()
    {
        Modify m = new Modify();
        m.modify1();
    }
    void remove_menu()  //input menu
    {
        Delete d1 = new Delete();
        Scanner sc = new Scanner(System.in);
        int n=0;
        while(n !=  3)
            {
                System.out.println("Delete Menu : ");
                System.out.println("1 :"+"Delete particualar Package: ");
                System.out.println("2 :"+"Delete all packages: ");
                System.out.println("3 :"+"EXIT : ");
    	
                n=sc.nextInt();
        
                switch(n)
                {
                    case 1: 
                        d1.deletem();
                        break;
                    case 2: 
                        d1.delete();
                        break;
                    case 3:
                        break;
                    default :
                    {
                	System.out.println("WRONG CHOICE");
                	System.out.println("Press any key to continue : ");
                    }
                }
            }
    }
     void output_menu()  //display menu
    {
        Scanner sc = new Scanner(System.in);
        Display d2 = new Display();
        int n=0;
            while(n !=  5)
            {
                System.out.println("");
                for(int i=0;i<21;i++)
                {
                    System.out.print("---");
                } 
                System.out.println("");
                System.out.println("\t\t\t  MAIN MENU : ");
                for(int i=0;i<21;i++)
                {
                    System.out.print("---");
                } 
                System.out.println("");
                System.out.println("1 :"+"Display Particular Package");
                System.out.println("2 :"+"Dispaly all the Packages");
                System.out.println("3 :"+"Display National Packages");
                System.out.println("4 :"+"Display International Packages");
                System.out.println("5 :"+"EXIT : ");
                for(int i=0;i<21;i++)
                {
                    System.out.print("---");
                } 
                System.out.println("");
                System.out.println("Enter your choice..");
                n=sc.nextInt();
                System.out.println("");
        
                switch(n)
                {
                    case 1: 
                        d2.display1();
                        break;
                    case 2: 
                        d2.display2();
                        break;
                    case 3:
                        d2.display_n();
                        break;
                    case 4:
                        d2.display_i();
                        break;
                    case 5:
                        break;
                    default :
                    {
                	System.out.println("WRONG CHOICE");
                	System.out.println("Press any key to continue : ");
                    }
                }
            }
    }
}