/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import Elements.Casilla;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.Effect;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aaron
 */
public class SettingsController implements Initializable {
    
    public static String fichaSeleccionada;
    public static String fichaComputadora;
    public static boolean turnoHumano;
    boolean existeFicha= false;
    boolean existeInicio=false;
    
    @FXML
    private ComboBox<String> ComboBox;
    private final ObservableList opciones = FXCollections.observableArrayList("Computadora","Humano");
    
        @FXML
    private Button SelectX;

    @FXML
    private Button SelectO;
    
     @FXML
    private Rectangle selectionX;

    @FXML
    private Rectangle selectionO;

    @FXML
    private Button play;
    
    @FXML
    private CheckBox checkBoxSugerencia;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBox.setItems(opciones);
        play.setDisable(true);
        ComboBox.setDisable(true);
        selectionX.setOpacity(0);
        selectionO.setOpacity(0);
        
    }    
    
    @FXML
    void clickPlay(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VistaJuego.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickSelectO(ActionEvent event) {
        ComboBox.setDisable(false);
       fichaSeleccionada = "O" ;
       fichaComputadora = "X";
       existeFicha = true;
       selectionX.setOpacity(0);
       selectionO.setOpacity(1);
       
       
        habilitarPlay();
    }

    @FXML
    void clickSelectX(ActionEvent event) {
        ComboBox.setDisable(false);
        fichaSeleccionada = "X" ;
        fichaComputadora = "O";
        existeFicha = true;
        selectionX.setOpacity(1);
        selectionO.setOpacity(0);
        
        
        
        habilitarPlay();
    }
    
    @FXML
    void comboClick(ActionEvent event) {
        if(null == ComboBox.getValue()){
            existeInicio = false;
        }else switch (ComboBox.getValue()) {
            case "Computadora":
                turnoHumano = false;
                existeInicio = true;
                Casilla.turno = fichaComputadora;
                habilitarPlay();

                System.out.println("CPU");
                break;
            case "Humano":
                turnoHumano = true;
                existeInicio = true;
                Casilla.turno = fichaSeleccionada;
                habilitarPlay();
                System.out.println("HUMAN");
                break;
            default:
                break;
        }
    }
    
    @FXML
    void habilitarSugerencias(ActionEvent event) {
        System.out.println("Sugerencias activadas");
        //TODO 
    }
    
    private boolean configComplete(){
        return existeFicha && existeInicio;
    }
    
    private void habilitarPlay(){
        if(configComplete()){
            play.setDisable(false);
            
        }else{
            play.setDisable(true);
        }
    }
    
}