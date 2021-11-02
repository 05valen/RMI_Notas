
/**
 * TRABAJO 1 RMI
 * Proyecto integrador 
 * @author Valentina Restrepo Castrillon 
 * @author Satiago Quiceno Betancur
 */
package Server;
import Implement.CalcImplement;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalcServer {
   public static void main(String []args) throws RemoteException
    { 
       Registry reg=LocateRegistry.createRegistry(1099);
       CalcImplement calcImplement=new CalcImplement(0,0);
      //nombre objeto
       reg.rebind("Calculate", calcImplement);
       System.out.println("servidor iniciado");
    
    }
}
