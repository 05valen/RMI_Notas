/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author valen
 */
public interface CalcInterface extends Remote{
     
          public float[][] generarMat(int numEstudent, int numNotas, int choice) throws RemoteException;
          public float[] calculateMin_Max(float matrizNotas[][], int choice,float vectorNotas [],int numNotas, int numEstudent) throws RemoteException;
          public float promedioGrupal(float matrizNotas[][], int choice,int numNotas, int numEstudent) throws RemoteException;

       
       
    
}
