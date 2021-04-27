
package clientpage;

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
import java.util.Scanner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class MiailSending {
   void Mail() throws IOException {
      Scanner sc = new Scanner(System.in);
      System.out.println("Do you want to save the document (Print this to be safe(1/2))");
       int a = sc.nextInt();
      if(a == 1)
      {
       PDDocument document = new PDDocument();
      document.addPage(new PDPage());
      document.save("C:\\Dhv\\abc.pdf");
      
      System.out.println("PDF created");
      document.close();
      
      //Loading an existing document 
      PDDocument doc = PDDocument.load(new File("C:\\Dhv\\abc.pdf")); 

      //Creating a PDF Document 
      PDPage page = doc.getPage(0);       
      PDPageContentStream contentStream = new PDPageContentStream(doc, page); 
      
      //Begin the Content stream 
      contentStream.beginText(); 

      //Setting the font to the Content stream  
      contentStream.setFont( PDType1Font.TIMES_ROMAN, 16 ); 

      //Setting the position for the line 
      contentStream.newLineAtOffset(25, 725 ); 
      String text = "This is an example of adding text to a page in the pdf document."; 

      //Adding text in the form of string 
      contentStream.showText(text); 

      //Ending the content stream 
      contentStream.endText(); 
      System.out.println("Content added");       

      //Closing the content stream 
      contentStream.close();      

      //Saving the document
        doc.save(new File("C:\\Dhv\\abc.pdf")); 
      //Closing the document  
      doc.close();
      }
   }
}