package clientpage;  //package display

import java.io.File;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class pdf123
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/tour";
   
   static final String USER = "root";
   static final String PASS = "1234";
   
      void Mail(int book_id,int p_id) throws IOException   //pdf create
     {
      Scanner s = new Scanner(System.in);
      
      PDDocument document = new PDDocument();
      document.addPage(new PDPage());
      
      System.out.println("Enter the name of pdf you like to name :");
      String str = s.nextLine();
      str=str+"1.pdf";
      document.save(str);
      
      System.out.println("PDF created");
      document.close(); 
      
      
      
      try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            Statement stmt = null;
            
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            
            sql = "SELECT Tour_ID, Tour_Name, Place_From, Place_To,Duration_days,Fare,Description,pack_det FROM tour";
            ResultSet rs = stmt.executeQuery(sql);
                 
            PDDocument doc = PDDocument.load(new File(str));
            PDPage page = doc.getPage(0);       
                    PDPageContentStream contentStream = new PDPageContentStream(doc, page);
                    contentStream.beginText(); 
                    contentStream.setFont( PDType1Font.TIMES_ROMAN, 16 );
      
                     contentStream.setLeading(14.5f);
                    contentStream.newLineAtOffset(25, 725); 
            int k=0;
            
             while(rs.next())
            {
                int id  = rs.getInt("Tour_ID");
                String name = rs.getString("Tour_Name");
                String placef = rs.getString("Place_From");
                String placeT = rs.getString("Place_To");
                int durationd = rs.getInt("Duration_days");
                int fare = rs.getInt("Fare");
                String dis = rs.getString("Description");
                String pack_det1 = rs.getString("pack_det");
                        
                if(p_id==id)
                {
                    String text = "Booking done successfully."; 
                    String txt1 = "Package Details :";
                    contentStream.newLine();
                    contentStream.newLine();
                    
                    contentStream.showText(text);
                    contentStream.newLine();
                    contentStream.newLine();
                    contentStream.newLine();
                    
                    contentStream.showText(txt1);
                    contentStream.newLine();
                    
                    contentStream.showText("TOUR ID :  ");
                    String ic = String.valueOf(id);
                    contentStream.showText(ic);
                    contentStream.newLine();
                    
                    contentStream.showText("PACKAGE NAME :  ");
                    contentStream.showText(name);
                    contentStream.newLine();
                  
                    contentStream.showText("PLACE FROM :  ");
                    contentStream.showText(placef);
                    contentStream.newLine();
                    contentStream.showText("PLACE TO :  ");
                    contentStream.showText(placeT);
                    contentStream.newLine();
                    
                    contentStream.showText("No. OF DAYS:  ");
                    ic = String.valueOf(durationd);  
                    contentStream.showText(ic);
                    contentStream.newLine();
                    
                    contentStream.showText("CHARGES PER PRESON :  ");
                    String.valueOf(fare);  
                    contentStream.showText(ic);
                    contentStream.newLine();
                    
                    contentStream.showText(dis);
                    contentStream.newLine();
                    
                    contentStream.showText("YOUR PACKAGE IS :");
                    contentStream.showText(pack_det1);
                    contentStream.newLine();
                }  
            }
             
             contentStream.newLine();
             contentStream.showText("ENJOY YOUR TRIP !!!");
             contentStream.newLine();
             contentStream.endText();
             System.out.println("Enjoy your trip!!"); 
            System.out.println("Content of the pdf saved");       
      
            contentStream.close();
            doc.save(new File(str));
            doc.close();
        }
        catch(SQLException se)
        {                  
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }
}