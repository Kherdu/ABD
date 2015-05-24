import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xquery.*;

import org.w3c.dom.Element;

import net.xqj.exist.ExistXQDataSource;

public class practica3
{
  public static void main(String[] args) throws XQException
  {
    XQDataSource xqs = new ExistXQDataSource();
    xqs.setProperty("serverName", "localhost");
    xqs.setProperty("port", "8080");
    xqs.setProperty("user", "admin");
    xqs.setProperty("password", "admin");
    

    InputStream is = practica3.class.getResourceAsStream("/eurovision1.xquery");
    
    XQConnection con = xqs.getConnection();
    XQPreparedExpression exp = con.prepareExpression(is);
    
  
 
    XQResultSequence rs = exp.executeQuery();

    System.out.println("Consulta 1: ");
    
    while(rs.next())
    	System.out.println(rs.getItemAsString(null));
 
    

   
    con.close();
    
    System.out.println("\nConsulta 2: \n");
    is = practica3.class.getResourceAsStream("/eurovision2.xquery");
    
    con = xqs.getConnection();
    exp = con.prepareExpression(is);
    
    exp.bindInt(new QName("anyo"), 2015, null);
 
    rs = exp.executeQuery();

    while(rs.next())
    	System.out.println(rs.getItemAsString(null));
 
    

   
    con.close();
    System.out.println("\nConsulta 3: \n");
 is = practica3.class.getResourceAsStream("/eurovision3.xquery");
    
    con = xqs.getConnection();
    exp = con.prepareExpression(is);
    
    exp.bindInt(new QName("anyo"), 2015, null);
 
     rs = exp.executeQuery();

    while(rs.next())
    	System.out.println(rs.getItemAsString(null) );
 
    

   
    con.close();
  }
  

  
  
  
}