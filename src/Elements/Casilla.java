/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javax.swing.JOptionPane;
import tictactoe.SettingsController;
import tictactoe.VistaJuegoController;

/**
 *
 * @author aaron
 */
public class Casilla extends StackPane {

    public static String turno ="";
    private String link = "";
    private ImageView ImagenEstado;
    public Casilla() {
        ImagenEstado = new ImageView();
        ImagenEstado.setFitHeight(100);
        ImagenEstado.setFitWidth(100);
        getChildren().addAll(ImagenEstado);
        setCursor(Cursor.HAND);
        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                clickEnTablero();
                VistaJuegoController.utilidadTablero(link);
                consultarGanador();
            }

        });
    }

    
    
    public void clickEnTablero(){
       if(SettingsController.fichaSeleccionada.equals("O")&& SettingsController.turnoHumano && turno.equals("O")){
                   
                    link = "O";
                    ImagenEstado.setImage(new Image("/resources/o.png"));
                    VistaJuegoController.possibleStates("O");
                    turno = "X";
                    SettingsController.turnoHumano=false;
                    
                    
                }    
                if(SettingsController.fichaSeleccionada.equals("X")&& SettingsController.turnoHumano&& turno.equals("X")){
                    link = "X";
                    ImagenEstado.setImage(new Image("/resources/x.png"));
                    turno = "O";
                    SettingsController.turnoHumano=false;
                    
                }
    }
    
    public void consultarGanador(){
        if (VistaJuegoController.isWinner(link)) {
                    JOptionPane.showMessageDialog(null, "¡Ganó el jugador "+link+"!");
                    System.out.println("XD: "+link);
                } else {
                    if (VistaJuegoController.isTie()) {
                        JOptionPane.showMessageDialog(null, "¡Empate!");
                    }
                }
    }
    
    public ImageView getEstado() {
        return ImagenEstado;
    }

    public void setEstado(ImageView estado) {
        this.ImagenEstado = estado;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return link;
    }

}
