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
import java.util.Collections;
import tictactoe.SettingsController;
import tictactoe.VistaJuegoController;
import static tictactoe.VistaJuegoController.arregloMatrix;

/**
 *
 * @author aaron
 */
public class JuegoAI {

    public static void MiniMax() {

    }

    public static void imprimirTablero(String[][] m) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static ArrayList guardarValores(String[][] m) {
        ArrayList res = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res.add(m[i][j]);
            }
        }

        return res;
    }

    public static LinkedList<String[][]> tableriosHijoVacio(String jugador) {
        if (jugador.equals("O")) {
            LinkedList<String[][]> matrices = new LinkedList<>();
            ArrayList<ArrayList<String>> valores = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    String[][] nuevo = new String[3][3];
                    nuevo[0][0] = "-";
                    nuevo[0][1] = "-";
                    nuevo[0][2] = "-";

                    nuevo[1][0] = "-";
                    nuevo[1][1] = "-";
                    nuevo[1][2] = "-";

                    nuevo[2][0] = "-";
                    nuevo[2][1] = "-";
                    nuevo[2][2] = "-";

                    if (nuevo[i][j].equals("-")) {

                        nuevo[i][j] = "X";
                        valores.add(guardarValores(nuevo));
                        matrices.addLast(nuevo);
                        nuevo[i][j] = "-";
                    }

                }

            }
            LinkedList<String[][]> res = new LinkedList<>();
            for (ArrayList<String> arreglo : valores) {

                String[][] array = new String[3][3];
                int contador = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        array[i][j] = arreglo.get(contador);
                        contador++;

                    }
                }
                //imprimirTablero(array);
                res.addLast(array);
            }
            return res;
        } else {
            LinkedList<String[][]> matrices = new LinkedList<>();
            ArrayList<ArrayList<String>> valores = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    String[][] nuevo = new String[3][3];
                    nuevo[0][0] = "-";
                    nuevo[0][1] = "-";
                    nuevo[0][2] = "-";

                    nuevo[1][0] = "-";
                    nuevo[1][1] = "-";
                    nuevo[1][2] = "-";

                    nuevo[2][0] = "-";
                    nuevo[2][1] = "-";
                    nuevo[2][2] = "-";
                    if (nuevo[i][j].equals("-")) {

                        nuevo[i][j] = "O";
                        valores.add(guardarValores(nuevo));
                        matrices.addLast(nuevo);
                        nuevo[i][j] = "-";
                    }

                }

            }
            LinkedList<String[][]> res = new LinkedList<>();
            for (ArrayList<String> arreglo : valores) {

                String[][] array = new String[3][3];
                int contador = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        array[i][j] = arreglo.get(contador);
                        contador++;

                    }
                }
                //imprimirTablero(array);
                res.addLast(array);
            }
            return res;
        }

    }

    public static LinkedList<String[][]> tablerosPosibles(String[][] tablero, String jugador) {
        LinkedList<String[][]> matrices = new LinkedList<>();
        ArrayList<ArrayList<String>> valores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String[][] nuevo = tablero;
                if (nuevo[i][j].equals("-")) {

                    nuevo[i][j] = jugador;
                    valores.add(guardarValores(nuevo));
                    matrices.addLast(nuevo);
                    nuevo[i][j] = "-";
                }

            }

        }
        LinkedList<String[][]> res = new LinkedList<>();
        for (ArrayList<String> arreglo : valores) {

            String[][] array = new String[3][3];
            int contador = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    array[i][j] = arreglo.get(contador);
                    contador++;
                }
            }
            res.addLast(array);
        }
        
        return res;
    }
    
    public static ArrayList<ArrayList<Integer>> coordenadasPosibles(String[][] tablero, String jugador){
        
        ArrayList<ArrayList<Integer>> coordenadas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String[][] nuevo = tablero;
                ArrayList<Integer> coordenada = new ArrayList<>();
                if (nuevo[i][j].equals("-")) {
                    coordenada.add(i);
                    coordenada.add(j);
                    coordenadas.add(coordenada);
                    nuevo[i][j] = jugador;
                    nuevo[i][j] = "-";
                }

            }

        }
        return coordenadas;
    }

    public static ArrayList<ArrayList<Integer>> generarArbolUtilidades(String[][] tablero, String turno) {
        ArrayList<ArrayList<Integer>>listaUtilidadles=new ArrayList<>();
        LinkedList<String[][]> hijos = tablerosPosibles(tablero, turno);
        Tree<String[][]> treePrincipal = new Tree<>(arregloMatrix);
        LinkedList<Tree<String[][]>> totalHijos = new LinkedList<>();
        
        int contador1 = -1;
        for(String[][]tab : hijos){
            contador1++;
//            System.out.println("hijo"+ contador1);
//            imprimirTablero(tab);
            Tree<String[][]> hijo = new Tree<>(tab);
            totalHijos.addLast(hijo);
        }
        
        treePrincipal.getRoot().setChildren(totalHijos);
        
        for(Tree<String[][]> h : treePrincipal.getRoot().getChildren()){
            LinkedList<String[][]> nietos;
            if(turno.equals("O")){
                nietos = tablerosPosibles(h.getRoot().getContent(),"X");
            }else{
                nietos = tablerosPosibles(h.getRoot().getContent(),"O");
            }
            LinkedList<Tree<String[][]>> totalNietos = new LinkedList<>();
            ArrayList<Integer>utilidadXarbol=new ArrayList<>();
            
            int contador = -1;
            for(String[][]tab : nietos){
                contador++;
//                System.out.println("nieto"+ contador);
//                imprimirTablero(tab);
                int utilidad;
                if(VistaJuegoController.checkWinnerBoard(tab,SettingsController.fichaComputadora)){
                    utilidad = 100000;
                    utilidadXarbol.add(utilidad);
                }else if(VistaJuegoController.checkWinnerBoard(tab,SettingsController.fichaSeleccionada)){
                    utilidad = -100000;
                    utilidadXarbol.add(utilidad);
                }else{
                    utilidad = VistaJuegoController.utilidadTablero(tab,turno);
                    utilidadXarbol.add(utilidad);
                }
                Tree<String[][]> nieto = new Tree<>(tab);
                //System.out.println("Utilidad del tablero: " + utilidad);
                //System.out.println("-------------------");
                totalNietos.addLast(nieto);
                
            }
            listaUtilidadles.add(utilidadXarbol);
            h.getRoot().setChildren(totalNietos);
        }
        
        System.out.println(listaUtilidadles);
        return listaUtilidadles;
    }
    
    
    public static int tomarDecision(String[][] tablero, String turno){
        ArrayList<ArrayList<Integer>> listaUtilidades = generarArbolUtilidades(tablero, turno);
        ArrayList<Integer> utilidadesDecisiones = new ArrayList<>();
        for(ArrayList<Integer> utilidad : listaUtilidades ){
            int menor = Collections.min(utilidad);
            utilidadesDecisiones.add(menor);
        }
        
        int decisionFinal = utilidadesDecisiones.indexOf(Collections.max(utilidadesDecisiones));
        System.out.println(utilidadesDecisiones);
        System.out.println(decisionFinal);
        
        LinkedList<String[][]> opciones = tablerosPosibles(tablero, turno);
        
        String[][] seleccion = opciones.get(decisionFinal);
        
        imprimirTablero(seleccion);
       
        
        return decisionFinal;
    }
    
    public static Casilla CasillaporSeleccionar(String[][] tablero, String turno){
        ArrayList<ArrayList<Integer>> coordenadas = coordenadasPosibles(tablero, turno);
        
        int coordenadaSeleccionada = tomarDecision(tablero, turno);
        ArrayList<Integer> coordenada = coordenadas.get(coordenadaSeleccionada);
        
        System.out.println(coordenada);
        
        Casilla cuadroAdibujar = VistaJuegoController.mesadeJuego[coordenada.get(0)][coordenada.get(1)];
        
        return cuadroAdibujar;
            
    }        
        
    
}
