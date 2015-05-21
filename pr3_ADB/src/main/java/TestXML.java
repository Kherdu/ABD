import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.xquery.*;

import net.xqj.exist.ExistXQDataSource;

public class TestXML
{
  public static void main(String[] args) throws XQException
  {
    XQDataSource xqs = new ExistXQDataSource();
    xqs.setProperty("serverName", "localhost");
    xqs.setProperty("port", "8080");
    xqs.setProperty("user", "admin");
    xqs.setProperty("password", "admin");
    

    InputStream is = TestXML.class.getResourceAsStream("/eurovision3.xquery");
    
    XQConnection con = xqs.getConnection();
    XQPreparedExpression exp = con.prepareExpression(is);
    
    exp.bindInt(new QName("anyo"), 2015, null);
 
    XQResultSequence rs = exp.executeQuery();

    while(rs.next())
      System.out.println(rs.getItemAsString(null));

    con.close();
  }
}