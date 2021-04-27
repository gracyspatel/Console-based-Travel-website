package adminpage;

import static adminpage.Delete.DB_URL;
import static adminpage.Delete.PASS;
import static adminpage.Delete.USER;
import com.mysql.jdbc.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Modify
{
    
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/tour";

   static final String USER = "root";
   static final String PASS = "1234";
   
    void modify1()  //get andchange
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
      
    
           
            stmt = conn.createStatement();
            System.out.print("Enter Tour_ID whose package needs to be modified :");
            int Tourid = sc.nextInt();
            
            String q = "Select * from tour where Tour_ID="+Tourid;
            java.sql.ResultSet rs = stmt.executeQuery(q);
            
            if(rs.next())
			{
				
                                rs.getInt(1);
				//System.out.println("1.Tour_id :"+rs.getInt(1));
                                System.out.println("");
                                System.out.println();
				System.out.println("1.Tour_Name :"+rs.getString(2));
				System.out.println();
                                System.out.println("2.Departure :"+rs.getString(3));
				System.out.println();
                                System.out.println("3.Destination  :"+rs.getString(4));
				System.out.println();
                                System.out.println("4.Duration_days :"+rs.getInt(5));
                                System.out.println();
                                System.out.println("5.Charges :"+rs.getInt(6));
                                System.out.println();
                                System.out.println("6.Description :"+rs.getString(7));
                                System.out.println();
                                System.out.println("7.Package details :"+rs.getString(8));
				System.out.println();
                                System.out.println("8.Exit");
				System.out.println();
                                System.out.println();
                                
                                System.out.println("Enter the feild that needs to be edited");
                                
                                System.out.println();
                                System.out.println("Enter your choice..");
                                
                                int ch = sc.nextInt();
                                System.out.println("");
                                String pat="";
				
                                switch(ch)
                                {
					case 1:
						System.out.print("Enter New Tour_Name:");
                                                sc.nextLine();
						String b = sc.nextLine();
						pat="Tour_Name ='"+ b +"'";
						break;
					case 2:
						System.out.print("Enter New place of Departure:");
                                                sc.nextLine();
						String c = sc.nextLine();
						pat="Place_From ='"+ c +"'";
						break;
					case 3:
						System.out.print("Enter New place of Destination:");
                                                sc.nextLine();
						String d = sc.nextLine();
						pat="Place_To ='"+ d +"'";
						break;
                                        case 4:
						System.out.print("Enter New number of days:");
						int e = sc.nextInt();
						pat="Duration_days ='"+ e +"'";
						break;
                                        case 5:
						System.out.print("Enter New Charges:");
						int g = sc.nextInt();
						pat=" Fare ='"+ g +"'";
						break;
                                        case 6:
						System.out.print("Enter New  Description:");
						sc.nextLine();
                                                String h = sc.nextLine();
						pat=" Description ='"+ h +"'";
						break;
                                        case 7:
                                                System.out.print("Enter New  Package details (National or International):");
						sc.nextLine();
                                                String i = sc.nextLine();
						pat=" Duration_det ='"+ i +"'";
                                                break;
                                        case 8:
						System.out.println("Exit");
                                                break;
					default:
						System.out.println("Wrong Option");
						break;
				}
				if(!pat.equals(""))
				{
					q="update tour set "+pat+" where Tour_ID ="+Tourid;
					stmt.executeUpdate(q);
					System.out.println("Record Updated....");
				}
			}
			else
			{
				System.out.println("Record Not Found...");
			}
            conn.close();
    }
    catch (Exception e)
    {
      System.out.println("Got an exception! ");
      System.out.println(e.getMessage());
    }
    }
}
