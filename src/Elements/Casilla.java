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
    private String link = "-";
    private ImageView ImagenEstado;
    public Casilla() {
        ImagenEstado = new ImageView();
        ImagenEstado.setFitHeight(100);
        ImagenEstado.setFitWidth(100);
        getChildren().addAll(ImagenEstado);
        setCursor(Cursor.HAND);
        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                
                try {
                this.setDisable(true);
                clickEnTablero();
                VistaJuegoController.actualizarListaCasillas(link, this);
                VistaJuegoController.actualizarTablero();
                JuegoAI.generarArbolUtilidades(VistaJuegoController.arregloMatrix, turno);
                JuegoAI.tomarDecision(VistaJuegoController.arregloMatrix, turno);
                System.out.println(JuegoAI.coordenadasPosibles(VistaJuegoController.arregloMatrix, turno));
                if(VistaJuegoController.terminarJuego(link)){
                    clickEnTableroAI();
                }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Empate");
                }
                
                
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
    
    public static void clickEnTableroAI(){
        if(!SettingsController.turnoHumano){
            Casilla click = JuegoAI.CasillaporSeleccionar(VistaJuegoController.arregloMatrix, turno);
            if(SettingsController.fichaSeleccionada.equals("X")){
                System.out.println("Se actualiza O");
                click.ImagenEstado.setImage(new Image("/resources/o.png"));
            }else{
                System.out.println("Se actualiza X");
                click.ImagenEstado.setImage(new Image("/resources/x.png"));
            }
            click.setDisable(true);
            SettingsController.turnoHumano= true;
            VistaJuegoController.actualizarListaCasillas(SettingsController.fichaComputadora,JuegoAI.CasillaporSeleccionar(VistaJuegoController.arregloMatrix, turno));
            VistaJuegoController.actualizarTablero();
            System.out.println("TABLERO DESPUES DE LA IA");
            JuegoAI.imprimirTablero(VistaJuegoController.arregloMatrix);
            System.out.println(VistaJuegoController.isWinner(turno));
            
            VistaJuegoController.terminarJuego(turno);
           
            if(turno.equals("X")){
                turno = "O";
            }else{
                turno = "X";
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
