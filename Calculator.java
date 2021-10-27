package calculadoras;
import javax.jws.WebService;
import javax.jws.WebMethod;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
@WebService
@SOAPBinding(style=Style.RPC)
public interface Calculator extends Remote
{
@WebMethod String cat(double x);
@WebMethod double ten(double y);

}
