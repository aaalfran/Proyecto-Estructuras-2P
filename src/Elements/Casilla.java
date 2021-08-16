/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import tictactoe.VistaJuegoController;

/**
 *
 * @author aaron
 */
public class Casilla extends StackPane {
    
    static int turnos = 1;
    private ImageView estado;
    private String link ="";

    public Casilla() {
        estado = new ImageView();
        estado.setFitHeight(100);
        estado.setFitWidth(100);
        setCursor(Cursor.HAND);
        getChildren().addAll(estado);

        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                
                if (!((turnos % 2) == 0)) {
                    link = "X";
                    estado.setImage(new Image("/resources/x.png"));
                

                }
                if ((turnos % 2) == 0) {
                    link = "O";
                    estado.setImage(new Image("/resources/o.png"));

                }

                turnos += 1;
                VistaJuegoController.utilidadTablero();
            }
             

        });
    }

    public static int getTurnos() {
        return turnos;
    }

    public static void setTurnos(int turnos) {
        Casilla.turnos = turnos;
    }

    public ImageView getEstado() {
        return estado;
    }

    public void setEstado(ImageView estado) {
        this.estado = estado;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return link ;
    }

    
}
