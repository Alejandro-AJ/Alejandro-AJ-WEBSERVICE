<HTML>
<center>
<BODY bgcolor="#FFDDDD">
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "mis.Auto" %>
<%@ page import = "mis.plan" %>
<% 
   ArrayList L=(ArrayList)request.getAttribute("AUTO");
   ArrayList B2=(ArrayList)request.getAttribute("TEN");
%>

 <h1>DESPLEGANDO LA CONSULTA</h1>
<table>
<% 
   boolean cambio=true;
   Auto A;
   plan B;
   Iterator i = L.iterator();
   Iterator j = B2.iterator(); 
   while(i.hasNext())
   {
      A=(Auto)i.next();
      B=(plan)j.next();
      if (cambio)
      {
%>
        <tr bgcolor="#EEFFEE">
<%
      }
      else
      {
%>
        <tr bgcolor="#AADDAA">
<%
      }
%>        
          <td><%= A.getId() %></td>
          <td><%= A.getMarca() %></td>
          <td><%= A.getModelo() %></td>
          <td><%= A.getTipo() %></td>
          <td><%= String.format("%.2f", A.getPrecio()) %></td>
          <td><%= B.getC() %></td>
          <td><%= String.format("%.2f", B.getT()) %></td>
        </tr>
<%
      cambio=!cambio;
   }
%>

</table>    



</BODY>
</center>
</HTML>
