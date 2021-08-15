/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import Elements.Casilla;
import TDAs.LinkedList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author aaron
 */
public class VistaJuegoController implements Initializable {
    
    
    @FXML
    private Pane root;
    
//Creando objetos en pantalla
    
    static int[][] arregloMatrix = new int[3][3];
    static LinkedList<Casilla> listaCasillas = new LinkedList();



//Creando objetos en pantalla
    private void crearMatriz() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla cas = new Casilla();
                cas.setTranslateX(j * 160);
                cas.setTranslateY(i * 160);
                cas.setLayoutX(j + 260);
                cas.setLayoutY(i + 200);
                root.getChildren().add(cas);
                listaCasillas.addLast(cas);
            }
        }

    }

    public static void llenarMatriz() {
        try {
            if (listaCasillas.get(0).getLink().equals("/resources/x.png")) {
                arregloMatrix[0][0] = 1;
            }
            if (listaCasillas.get(1).getLink().equals("/resources/x.png")) {
                arregloMatrix[0][1] = 1;
            }
            if (listaCasillas.get(2).getLink().equals("/resources/x.png")) {
                arregloMatrix[0][2] = 1;
            }
            if (listaCasillas.get(3).getLink().equals("/resources/x.png")) {

                arregloMatrix[1][0] = 1;
            }
            if (listaCasillas.get(4).getLink().equals("/resources/x.png")) {
                arregloMatrix[1][1] = 1;
            }
            if (listaCasillas.get(5).getLink().equals("/resources/x.png")) {
                arregloMatrix[1][2] = 1;
            }

            if (listaCasillas.get(6).getLink().equals("/resources/x.png")) {
                arregloMatrix[2][0] = 1;
            }
            if (listaCasillas.get(7).getLink().equals("/resources/x.png")) {
                arregloMatrix[2][1] = 1;
            }
            if (listaCasillas.get(8).getLink().equals("/resources/x.png")) {
                arregloMatrix[2][2] = 1;
            }

            if (listaCasillas.get(0).getLink().equals("/resources/o.png")) {
                arregloMatrix[0][0] = 2;
            }
            if (listaCasillas.get(1).getLink().equals("/resources/o.png")) {
                arregloMatrix[0][1] = 2;
            }
            if (listaCasillas.get(2).getLink().equals("/resources/o.png")) {
                arregloMatrix[0][2] = 2;
            }

            if (listaCasillas.get(3).getLink().equals("/resources/o.png")) {
                arregloMatrix[1][0] = 2;
            }
            if (listaCasillas.get(4).getLink().equals("/resources/o.png")) {
                arregloMatrix[1][1] = 2;
            }
            if (listaCasillas.get(5).getLink().equals("/resources/o.png")) {
                arregloMatrix[1][2] = 2;
            }

            if (listaCasillas.get(6).getLink().equals("/resources/o.png")) {
                arregloMatrix[2][0] = 2;
            }
            if (listaCasillas.get(7).getLink().equals("/resources/o.png")) {
                arregloMatrix[2][1] = 2;
            }
            if (listaCasillas.get(8).getLink().equals("/resources/o.png")) {
                arregloMatrix[2][2] = 2;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void utilidadTablero() {
        for (int i = 0; i < arregloMatrix.length; i++) {
            for (int j = 0; j < arregloMatrix[i].length; j++) {
                System.out.print(arregloMatrix[i][j] + " ");	// Imprime elemento 
            }
            System.out.println();	// Imprime salto de línea 
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearMatriz();
    }    
}
