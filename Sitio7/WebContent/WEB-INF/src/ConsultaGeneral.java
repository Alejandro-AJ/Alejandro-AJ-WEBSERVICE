import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;
import mis.Auto;
import mis.plan;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class ConsultaGeneral extends HttpServlet
{
  public void service(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException
  {
    PrintWriter out=response.getWriter();   
   
    String url="jdbc:postgresql://127.0.0.1:5432/coche";
    Connection con=null;
    String query="SELECT * FROM auto ORDER BY id";
    try
    {    
      Class.forName("org.postgresql.Driver");
      con=DriverManager.getConnection(url,"harold","123");
      Statement inst=con.createStatement();
      ResultSet rs=inst.executeQuery(query);
      URL url2 = new URL("http://alex.net:8888/tenale/CalculatorBean?wsdl");
      QName qname = new QName("http://calculadoras/", "CalculatorBeanService");
      Service service = Service.create(url2, qname);
      ArrayList L=new ArrayList();
      ArrayList B2=new ArrayList();
      while (rs.next())
      {
        
        String id = rs.getString(1).trim();
        String marca = rs.getString(2).trim();
        int modelo = rs.getInt(3);
        String tipo = rs.getString(4).trim();
        double precio= rs.getDouble(5);
        calculadoras.Calculator eif = service.getPort(calculadoras.Calculator.class);
        Auto A=new Auto();
        plan B=new plan();
        A.setId(id);
        A.setMarca(marca);
        A.setModelo(modelo);
        A.setTipo(tipo);
        A.setPrecio(precio);
        String cate=(String)eif.cat(precio);
       
        B.setC(eif.cat(precio));
        B.setT(eif.ten(precio)); 
        //A.setClas(eif.cat(precio));
        //A.setTen(eif.ten(precio));
        /*out.println(A.getId());
        out.println(A.getNombre());
        out.println(A.getMarca());
        out.println(A.getModelo());
        out.println(A.getTipo());
        out.println(A.getPrecio());
        out.println(A.getNMeses());
        out.println(A.getInMes());
        out.println(A.getIva());*/
        //B.add(eif);
        L.add(A);
        B2.add(B);
      }
      con.close();
      inst.close();
      request.setAttribute("AUTO",L);
      request.setAttribute("TEN",B2);
      request.getRequestDispatcher("./DespliegaConsultaGeneral.jsp").forward(request, response); 
      /*  out.println(id);
        out.println(nombre);
        out.println(marca);
        out.println(modelo);
        out.println(tipo);
        out.println(precio);
        out.println(meses);
        out.println(imen);
        out.println(iva); */
    }
    catch(Exception exc)
    {
     out.println(exc.getMessage());  
    }
  }
} 
