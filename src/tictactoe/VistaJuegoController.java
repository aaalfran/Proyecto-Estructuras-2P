/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import Elements.Casilla;
import Elements.JuegoAI;
import TDAs.LinkedList;
import TDAs.Tree;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static tictactoe.VistaJuegoController.arregloMatrix;

/**
 * FXML Controller class
 *
 * @author aaron
 */
public class VistaJuegoController implements Initializable {

    @FXML
    private Pane root;
    
    @FXML
    private ImageView botonExit;

//Creando objetos en pantalla
    public static String[][] arregloMatrix = new String[3][3];
    static LinkedList<Casilla> listaCasillas = new LinkedList();
    public static Casilla[][] mesadeJuego = new Casilla[3][3];

    static Tree<String[][]> tree = new Tree<>(arregloMatrix);

    static boolean moveFirst = true;

//Creando objetos en pantalla
    private void crearMatriz() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla cas = new Casilla();
                mesadeJuego[i][j]= cas;
                cas.setTranslateX(j * 160);
                cas.setTranslateY(i * 160);
                cas.setLayoutX(j + 260);
                cas.setLayoutY(i + 200);
                root.getChildren().add(cas);
                listaCasillas.addLast(cas);
            }
        }
    }
    
    public static void actualizarListaCasillas(String ficha, Casilla casClick){
        int indice = obtenerCoordenadaCasilla(casClick);
        
        casClick.setLink(ficha);
        //System.out.println(casClick.getLink());
        listaCasillas.set(indice, casClick);
        
    }
    
    public static int obtenerCoordenadaCasilla(Casilla casClick){
        int contador = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                contador++;
                if(mesadeJuego[i][j].equals(casClick)){
                    System.out.println(contador);
                    return contador;
                }
            }
        }
        
        return -1;  
    }
    
    public static void actualizarTablero(){
        int contador = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arregloMatrix[i][j] = listaCasillas.get(contador).getLink();
                
                contador++;
            }
        }
        //System.out.println(listaCasillas);
        
    }

    public static int utilidadTablero(String[][] matrix, String opcion) {
        int pX = 0;
        int pO = 0;

        
        
        int filaX = chequeoFilas(matrix, "X");

        int columnaX = chequeoColumnas(matrix, "X");

        int diagonalPrincipalX = chequoDigonalPrincipal(matrix, "X");

        int diagonalSeecundariaX = chequeoDiagonalSecundaria(matrix, "X");

        int filaO= chequeoFilas(matrix, "O");

        int columnaO = chequeoColumnas(matrix, "O");

        int diagonalPrincipalO = chequoDigonalPrincipal(matrix, "O");

        int diagonalSeecundariaO = chequeoDiagonalSecundaria(matrix, "O");

        pX= (filaX + columnaX + diagonalPrincipalX + diagonalSeecundariaX);
        
        pO=  (filaO+columnaO+diagonalPrincipalO+diagonalSeecundariaO);
        
        if(opcion.equals("X")){
            return pO-pX;
        }else{
            return pX-pO;
        }


    }

    public static int chequeoFilas(String[][] matrix, String Opcion) {
        //Chequeo por filas
        int cond = 1;
        int cond2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (j < 3) {
                    if (!matrix[i][j].equals(Opcion)) {
                        cond *= 1;
                    } else {
                        cond *= 0;
                    }
                } else {
                    if (cond == 1) {
                        cond2++;
                    }
                }

            }
            cond = 1;
        }
        return cond2;
    }

    public static int chequeoColumnas(String[][] matrix, String Opcion) {
        //Chequeo por columnas
        int condColumna = 1;
        int cond2Columna = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (j < 3) {
                    if (!matrix[j][i].equals(Opcion)) {
                        condColumna *= 1;
                    } else {
                        condColumna *= 0;
                    }
                } else {
                    if (condColumna == 1) {
                        cond2Columna++;
                    }
                }

            }
            condColumna = 1;
        }
        return cond2Columna;
    }

    public static int chequoDigonalPrincipal(String[][] matrix, String Opcion) {
        //Chequeo por diagonal principal      
        if (!matrix[0][0].equals(Opcion) && !matrix[1][1].equals(Opcion) && !matrix[2][2].equals(Opcion)) {
            return 1;
        } else {
            return 0;
        }

    }

    public static int chequeoDiagonalSecundaria(String[][] matrix, String Opcion) {
        //Chequeo por diagonal secundaria      
        if (!matrix[0][2].equals(Opcion) && !matrix[1][1].equals(Opcion) && !matrix[2][0].equals(Opcion)) {
            return 1;
        } else {
            return 0;
        }
    }

   
    public static boolean isTie() {
        boolean estado = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arregloMatrix[i][j].equals("")) {
                    return false;
                }
            }

        }

        return estado;
    }
    
    public static boolean checkWinnerBoard(String[][] tablero, String link){
        boolean filas = false;
            boolean columnas = false;
            boolean diagPrincipal = false;
            boolean diagSecundaria = false;

            int condFila = 1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j <= 3; j++) {
                    if (j < 3) {
                        if (tablero[i][j].equals(link)) {
                            condFila *= 1;
                        } else {
                            condFila *= 0;
                        }
                    } else {
                        if (condFila == 1) {
                            filas = true;
                        }
                    }

                }
                condFila = 1;
            }

            //Chequeo por columnas
            int eColumna = 1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j <= 3; j++) {
                    if (j < 3) {
                        if (tablero[j][i].equals(link)) {
                            eColumna *= 1;
                        } else {
                            eColumna *= 0;
                        }
                    } else {
                        if (eColumna == 1) {
                            columnas = true;
                        }
                    }

                }
                eColumna = 1;
            }

            //Chequeo diagonal Principal
            if (tablero[0][0].equals(link) && tablero[1][1].equals(link) && tablero[2][2].equals(link)) {
                diagPrincipal = true;
            }

            //Chequeo por diagonal secundaria      
            if (tablero[0][2].equals(link) && tablero[1][1].equals(link) && tablero[2][0].equals(link)) {
                diagSecundaria = true;
            }

            return diagPrincipal || diagSecundaria || filas || columnas;
    }

    public static boolean isWinner(String link) {
        if (link.equals("X") || link.equals("O")) {
            boolean filas = false;
            boolean columnas = false;
            boolean diagPrincipal = false;
            boolean diagSecundaria = false;

            int condFila = 1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j <= 3; j++) {
                    if (j < 3) {
                        if (arregloMatrix[i][j].equals(link)) {
                            condFila *= 1;
                        } else {
                            condFila *= 0;
                        }
                    } else {
                        if (condFila == 1) {
                            filas = true;
                        }
                    }

                }
                condFila = 1;
            }

            //Chequeo por columnas
            int eColumna = 1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j <= 3; j++) {
                    if (j < 3) {
                        if (arregloMatrix[j][i].equals(link)) {
                            eColumna *= 1;
                        } else {
                            eColumna *= 0;
                        }
                    } else {
                        if (eColumna == 1) {
                            columnas = true;
                        }
                    }

                }
                eColumna = 1;
            }

            //Chequeo diagonal Principal
            if (arregloMatrix[0][0].equals(link) && arregloMatrix[1][1].equals(link) && arregloMatrix[2][2].equals(link)) {
                diagPrincipal = true;
            }

            //Chequeo por diagonal secundaria      
            if (arregloMatrix[0][2].equals(link) && arregloMatrix[1][1].equals(link) && arregloMatrix[2][0].equals(link)) {
                diagSecundaria = true;
            }

            return diagPrincipal || diagSecundaria || filas || columnas;
        }
        return false;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearMatriz();
        
        if(!SettingsController.turnoHumano){
            JuegoAI.imprimirTablero(arregloMatrix);
            actualizarTablero();
            JuegoAI.imprimirTablero(arregloMatrix);
            Casilla.clickEnTableroAI();
        }
    }
    
     @FXML
    void clicExit(MouseEvent event) throws IOException {
        
            arregloMatrix = new String[3][3];
            listaCasillas = new LinkedList();
            mesadeJuego = new Casilla[3][3];
            Parent root = FXMLLoader.load(getClass().getResource("VistaInicio.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
    public static boolean terminarJuego(String link){
        boolean continuar = true;
        if(checkWinnerBoard(arregloMatrix, link)){
            
            JOptionPane.showMessageDialog(null, "¡Ganó el jugador "+link+"!");
            continuar = false;
            
            for(Casilla[] cas : mesadeJuego){
                for(Casilla c: cas){
                    c.setDisable(true);
                }
            }
            //System.exit(1);
        }
        
        return continuar;
    }
}
