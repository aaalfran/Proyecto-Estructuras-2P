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
    
    static String[][] arregloMatrix = new String[3][3];
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
        
        System.out.println(listaCasillas);

    }
    public static void utilidadTablero(String valor) {
    
        
    int contador =0;
    for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arregloMatrix[i][j]= listaCasillas.get(contador).getLink();
                contador++;
                
            }
    }
    
    //Chequeo por filas
    int cond=1;
    int cond2=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if(j<3){
                    if(!arregloMatrix[i][j].equals("O")){
                        cond*=1;
                    }else{
                    cond*=0;
                    }
                }else{
                    if(cond==1){
                    cond2++;
                }
                }
                
            }
            cond=1;
    }
        System.out.println(cond2);
 }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearMatriz();
    }    
}
