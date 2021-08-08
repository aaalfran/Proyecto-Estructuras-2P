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

/**
 *
 * @author aaron
 */
public class Casilla extends StackPane {
    
    public Casilla(){
        ImageView estado = new ImageView();
        estado.setFitHeight(100);
        estado.setFitWidth(100);
        setCursor(Cursor.HAND);
        getChildren().addAll(estado);
        
        setOnMouseClicked(event->{
            if(event.getButton() == MouseButton.PRIMARY){
                estado.setImage(new Image("/resources/x.png"));
            }
            
        });
    }
}
