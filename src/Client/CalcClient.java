/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Interface.CalcInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author valen
 */
public class CalcClient {

    public static void main(String[] args) throws IOException {
        int numEstudent = 0, numNotas = 0;
        float promedioGrupal;
        int choice = 0;
        float matrizNotas[][] = new float[0][0];

        boolean confirmacion = false;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            
            JOptionPane.showMessageDialog(null, "1.LLenado de matriz\n "   +
                                                 "2.Hallar la menor nota del estudiante\n  "+
                                                 "3.Hallar la mayor valor de cada nota\n  " +
                                                 "4.Promedio del grupo\n   " +
                                                 "5.Salir\n    ");
            System.out.println("1.LLenado de matriz  ");
            System.out.println("2.Hallar la menor nota del estudiante  ");
            System.out.println("3.Hallar la mayor valor de cada nota  ");
            System.out.println("4.Promedio del grupo   ");
            System.out.println("5.Salir    ");

            System.out.println("OPCION:");
            choice = Integer.parseInt(br.readLine());

            if (choice != 5) {
                try {
                    CalcInterface calcinterface = (CalcInterface) Naming.lookup("Calculate"); //buscar el objeto remoto
                    if (choice == 1) {
                        System.out.println("Numero de estudiantes:");
                        numEstudent = Integer.parseInt(br.readLine());
                        System.out.println("Numero de notas:");
                        numNotas = Integer.parseInt(br.readLine());

                        matrizNotas = calcinterface.generarMat(numEstudent, numNotas, choice);

                        System.out.println(":::::Notas Estudiantes ::::");
                        for (int i = 0; i < matrizNotas.length; i++) {
                            for (int j = 0; j < matrizNotas[i].length; j++) {
                                System.out.print("   " + matrizNotas[i][j] + "   ");
                            }
                            System.out.println();
                        }
                        confirmacion = true;
                    }
                    if (confirmacion == true) {
                        if (choice == 2) {
                            float vectorNotas[] = new float[numEstudent];
                            vectorNotas = calcinterface.calculateMin_Max(matrizNotas, choice, vectorNotas, numNotas, numEstudent);

                            for (int i = 0; i < vectorNotas.length; i++) {
                                System.out.println(" Nota menor del estudiante" + (i + 1) + ":   " + vectorNotas[i] + "   ");
                            }
                        } else if (choice == 3) {
                            float vectorNotas[] = new float[numNotas];
                            vectorNotas = calcinterface.calculateMin_Max(matrizNotas, choice, vectorNotas, numNotas, numEstudent);

                            for (int i = 0; i < vectorNotas.length; i++) {
                                System.out.println(" La mayor valor de cada nota" + (i + 1) + ":   " + vectorNotas[i] + "   ");
                            }

                        }else if(choice == 4){
                            float promedio=0;
                            promedio = calcinterface.promedioGrupal(matrizNotas,choice, numNotas, numEstudent);
                            System.out.println("El promedio grupal es:" + promedio);
                            
                        }
                    }
                    
                } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                    Logger.getLogger(CalcClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } while (choice != 5);
    }

}
