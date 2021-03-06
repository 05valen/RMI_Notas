/**
 * TRABAJO 1 RMI
 * Proyecto integrador 
 * @author Valentina Restrepo Castrillon 
 * @author Satiago Quiceno Betancur
 */
package Implement;
import Interface.CalcInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcImplement extends UnicastRemoteObject implements CalcInterface {
    public int numEstudent;
    public int numNotas;
    public float matriz[][];
    public float vectorNotas[];

    public CalcImplement(int numEstudent, int numNotas) throws RemoteException {
        this.numEstudent = numEstudent;
        this.numNotas = numNotas;
    }

    public int getNumEstudent() {
        return numEstudent;
    }

    public void setNumEstudent(int numEstudent) {
        this.numEstudent = numEstudent;
    }

    public int getNumNotas() {
        return numNotas;
    }

    public void setNumNotas(int numNotas) {
        this.numNotas = numNotas;
    }

    public float[][] LlenadoMat(int numEstudent, int numNotas) {
       float matrizNotas[][] = new float[numEstudent][numNotas];
       double aux=0.0f;

        for (int i = 0; i < numEstudent; i++) {
            for (int j = 0; j < numNotas; j++) {
                    double precision = Math.pow(10, 1);
                    double minimo = 1*precision;
                    double maximo = 5*precision;
                   aux =Math.floor(Math.random()*(maximo-minimo+1) + minimo) / precision;
                   matrizNotas[i][j] = (float)aux;
            }
        }
        matriz = matrizNotas;
        ImprimirMat(matrizNotas);
        return matriz;
    }

    public void ImprimirMat(float matrizNotas[][]) {
        System.out.println("::::::::ESTUDIANTES:::::::::");
        for (int i = 0; i < matrizNotas.length; i++) {
            for (int j = 0; j < matrizNotas[i].length; j++) {

                System.out.print("Estudiante " + (i + 1) + ": ");
                System.out.println("Nota " + (j + 1) + ": " + matrizNotas[i][j]);
            }
            System.out.println("");
        }
    }

    public float[] MayorNota(float matrizNotas[][], float vectorNotas[], int numNotas, int numEstudent) {
        float mayor = 0;
        float NotasMayores[] = new float[vectorNotas.length];

        for (int j = 0; j < numNotas; j++) {
           for (int i = 0; i < numEstudent; i++) {
                System.out.println(matrizNotas[i][j]);
                if (matrizNotas[i][j] > mayor) {
                    mayor = matrizNotas[i][j];
                }
            }
            NotasMayores[j] = mayor;
            System.out.println("El mayor valor de la nota" + (j + 1) + " es: " + mayor);
            mayor = 0;
        }
        vectorNotas = NotasMayores;
        return vectorNotas;
    }

    public float[] MenorNota(float matrizNotas[][], float vectorNotas[], int numNotas, int numEstudent) {
        float menor = 9999;
        float NotasMenoresEst[] = new float[vectorNotas.length];

        for (int i = 0; i < numEstudent; i++) {
            for (int j = 0; j < numNotas; j++) {
                System.out.println(matrizNotas[i][j]);
                if (matrizNotas[i][j] < menor) {
                    menor = matrizNotas[i][j];
                }
            }
            NotasMenoresEst[i] = menor;
            System.out.println("La nota menor del estudiantes " + (i + 1) + " es: " + menor);
            menor = 9999;
        }
        vectorNotas = NotasMenoresEst;
        return vectorNotas;
    }
   
    public float PromedioGrupal(float matrizNotas[][], int numNotas, int numEstudent) {
        float promedio =0,  notas=0;
        for (int i = 0; i < matrizNotas.length; i++) {
            for (int j = 0; j < matrizNotas[i].length; j++) {
                notas = notas + matrizNotas[i][j];
            }
        }
            promedio=(notas/(numNotas*numEstudent));
            System.out.println("El promedio del grupo es " + promedio);
        return promedio;
    }
    
    @Override
    public float[][] generarMat(int numEstudent, int numNotas, int choice) throws RemoteException {
        switch (choice) {
            case 1:
                return LlenadoMat(numEstudent, numNotas);

            default:
                System.out.println("ERROR");
                return null;
        }
    }

    @Override
    public float[] calculateMin_Max(float[][] matrizNotas, int choice, float[] vectorNotas, int numNotas, int numEstudent) throws RemoteException {
        switch (choice) {
            case 3:
                System.out.println(matrizNotas);
                return MenorNota(matrizNotas, vectorNotas, numNotas, numEstudent);
            case 4:
                System.out.println(matrizNotas);
                return MayorNota(matrizNotas, vectorNotas, numNotas, numEstudent);
            default:
                System.out.println("ERROR");
                return null;
        }
    }

    @Override
    public float promedioGrupal(float[][] matrizNotas, int choice, int numNotas, int numEstudent) throws RemoteException {
            switch (choice) {
            case 5:
                System.out.println(matrizNotas);
                return PromedioGrupal(matrizNotas,numNotas,numEstudent);
            default:
                System.out.println("ERROR");
                return 0;
        }
    }
}
