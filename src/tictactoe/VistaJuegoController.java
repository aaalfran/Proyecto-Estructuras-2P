/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import Elements.Casilla;
import TDAs.LinkedList;
import TDAs.Tree;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import static tictactoe.VistaJuegoController.arregloMatrix;

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
    private LinkedList<Tree<String[][]>> matricesChildren;
    Tree<String[][]> tree = new Tree<>(arregloMatrix);

    boolean moveFirst = true;

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

    public static void utilidadTablero() {

        int contador = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arregloMatrix[i][j] = listaCasillas.get(contador).getLink();
                contador++;

            }
        }

        chequeoFilas();

        chequeoColumnas();

        chequoDigonalPrincipal();
    }

    public static void chequeoFilas() {
        //Chequeo por filas
        int cond = 1;
        int cond2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (j < 3) {
                    if (!arregloMatrix[i][j].equals("O")) {
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
    }

    public static void chequeoColumnas() {
        //Chequeo por columnas
        int condFila = 1;
        int cond2Fila = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (j < 3) {
                    if (!arregloMatrix[j][i].equals("O")) {
                        condFila *= 1;
                    } else {
                        condFila *= 0;
                    }
                } else {
                    if (condFila == 1) {
                        cond2Fila++;
                    }
                }

            }
            condFila = 1;
        }
    }

    public static void chequoDigonalPrincipal() {
        //Chequeo por diagonal principal      
        if (!arregloMatrix[0][0].equals("O") && !arregloMatrix[1][1].equals("O") && !arregloMatrix[2][2].equals("O")) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    public void possibleStates(String opcion) {
        String[][] matrixTmp = arregloMatrix.clone();

        //GENERA LOS POSIBLES MOVIMIENTOS EN UN TABLERO VACIO
        if (moveFirst) {
            if (opcion.equals("x")) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        matrixTmp[i][j] = opcion;
                        matricesChildren.addLast(tree);
                        matrixTmp[i][j] = null;//revisar

                    }

                }
                tree.getRoot().setChildren(matricesChildren);

            } else if (opcion.equals("o")) {
                if (opcion.equals("x")) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            matrixTmp[i][j] = opcion;
                            matricesChildren.addLast(tree);
                            matrixTmp[i][j] = null;

                        }

                    }
                    tree.getRoot().setChildren(matricesChildren);

                }

            }
            moveFirst = false;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearMatriz();
    }
}
