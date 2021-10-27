import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
class clientCalculator {
public static void main(String args[ ]) throws Exception {
URL url = new URL("http://alex.net:8888/tenale/CalculatorBean?wsdl");
// Qualified name of the service:
// 1st arg is the service URI
// 2nd is the service name published in the WSDL
QName qname = new QName("http://calculadoras/", "CalculatorBeanService");
System.out.println("QName");
// Create, in effect, a factory for the service.
Service service = Service.create(url, qname);
System.out.println("QName");
// Extract the endpoint interface, the service "port".
calculadoras.Calculator eif = service.getPort(calculadoras.Calculator.class);
System.out.println(eif.cat(600000));
System.out.println(eif.ten(600000));

}
}
