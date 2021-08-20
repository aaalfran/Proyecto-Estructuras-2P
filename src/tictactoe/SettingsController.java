/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aaron
 */
public class SettingsController implements Initializable {
    
    String fichaSeleccionada;
    boolean empiezaHumano;
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
    private Button play;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBox.setItems(opciones);
        play.setDisable(true);
        
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
       fichaSeleccionada = "O" ;
       existeFicha = true;
       
       if(configComplete()){
           play.setDisable(false);
       }
    }

    @FXML
    void clickSelectX(ActionEvent event) {
        fichaSeleccionada = "X" ;
        existeFicha = true;
        
        
        if(configComplete()){
           play.setDisable(false);
       }
    }
    
    @FXML
    void comboClick(ActionEvent event) {
        if(null == ComboBox.getValue()){
            existeInicio = false;
        }else switch (ComboBox.getValue()) {
            case "Computadora":
                empiezaHumano = false;
                existeInicio = true;
                break;
            case "Humano":
                empiezaHumano = true;
                existeInicio = true;
                break;
            default:
                break;
        }
    }
    
    private boolean configComplete(){
        return existeFicha && existeInicio;
    }
    
}