/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Implement.CalcImplement;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author valen
 */
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
