/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import TDAs.LinkedList;
import TDAs.Tree;
import java.util.ArrayList;
import java.util.Arrays;
import tictactoe.VistaJuegoController;
import static tictactoe.VistaJuegoController.arregloMatrix;

/**
 *
 * @author aaron
 */
public class JuegoAI {
   
    public static void MiniMax(String[][] tablero,String jugador){
        
        LinkedList<String[][]> matrices = new LinkedList<>();
        ArrayList<ArrayList<String>> valores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String[][] nuevo = tablero;
                if(nuevo[i][j].equals("-")){
                    
                    nuevo[i][j]=jugador;
                    valores.add(guardarValores(nuevo));
                    matrices.addLast(nuevo);
                    nuevo[i][j] = "-";
                }
                
            }
         
        }
        
        for(String[][] mat : ArregloMatriz(valores)){
            imprimirTablero(mat);
            System.out.println("--------------------");
        }   
    }
    
    public static void imprimirTablero(String[][] m){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static ArrayList guardarValores(String[][] m){
        ArrayList res = new ArrayList<>();    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res.add(m[i][j]);
            }
        }
        
        return res;
    }
    
    public static ArrayList<String[][]> ArregloMatriz(ArrayList<ArrayList<String>> al){
        ArrayList<String[][]> res = new ArrayList();
        for(ArrayList<String> arreglo : al){
           
            String[][] array = new String[3][3];
            int contador = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    array[i][j] = arreglo.get(contador);
                    contador++;
                    

                
                } 
            } 
            res.add(array);
        }
        return res;
    }
    
    
    
}
