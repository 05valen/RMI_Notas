
package Interface;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcInterface extends Remote{
          public float[][] generarMat(int numEstudent, int numNotas, int choice) throws RemoteException;
          public float[] calculateMin_Max(float matrizNotas[][], int choice,float vectorNotas [],int numNotas, int numEstudent) throws RemoteException;
          public float promedioGrupal(float matrizNotas[][], int choice,int numNotas, int numEstudent) throws RemoteException;
}
