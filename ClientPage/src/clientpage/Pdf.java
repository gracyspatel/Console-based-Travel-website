package clientpage;  //booking details

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

public class Pdf
{
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/tour";
   
   static final String USER = "root";
   static final String PASS = "1234";
   
      void Mail(int book_id,int p_id) throws IOException
     {
      Scanner s = new Scanner(System.in);
      
      PDDocument document = new PDDocument();
      document.addPage(new PDPage());
      
      System.out.println("Enter the name of pdf you like to name :");
      String str = s.nextLine();
      str=str+".pdf";
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
            
            sql = "SELECT Book_id, Book_date,Customer_id,Customer_name,Package_name,Journey_date,No_of_Person,Amount FROM package_booking";
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
                int id1  = rs.getInt("Book_id");
                String pa_id = rs.getString("Book_date");
                String y_id = rs.getString("Customer_id");
                String y_name = rs.getString("Customer_name");
                String pa_name = rs.getString("Package_name");
                String det_book = rs.getString("Journey_date");
                int no = rs.getInt("No_of_Person");
                int amt = rs.getInt("Amount");
                
                if(book_id==id1)
                {
                    String text = "Booking done successfully."; 
                    String txt1 = "YOUR BOOKING DETAILS :";
                    contentStream.newLine();
                    contentStream.newLine();
                    
                    contentStream.showText(text);
                    contentStream.newLine();
                    contentStream.newLine();
                    contentStream.newLine();
                    
                    contentStream.showText(txt1);
                    contentStream.newLine();
                    
                    contentStream.showText("BOOKING ID :  ");
                    String ic = String.valueOf(id1);
                    contentStream.showText(ic);
                    contentStream.newLine();
                    
                    contentStream.showText("BOOKING DATE AND TIME:  ");
                    contentStream.showText(pa_id);
                    contentStream.newLine();
                  
                    contentStream.showText("CUSTOMER ID:  ");
                    contentStream.showText(y_id);
                    contentStream.newLine();
                    
                    contentStream.showText("CUSTOMER NAME:  ");
                    contentStream.showText(y_name);
                    contentStream.newLine();
                    
                    contentStream.showText("PACKAGE NAME :  ");  
                    contentStream.showText(pa_name);
                    contentStream.newLine();
                    
                    contentStream.showText("JOURNEY DATE :  ");
                    contentStream.showText(det_book);
                    contentStream.newLine();
                    
                    contentStream.showText("NO. OF VISITORS :  ");
                    ic = String.valueOf(no);
                    contentStream.showText(ic);
                    contentStream.newLine();
                    
                    contentStream.showText("TOTAL COST :  ");
                    ic = String.valueOf(amt);
                    contentStream.showText(ic);
                    contentStream.newLine();
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