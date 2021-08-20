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
    public static String[][] arregloMatrix = new String[3][3];
    static LinkedList<Casilla> listaCasillas = new LinkedList();

    static Tree<String[][]> tree = new Tree<>(arregloMatrix);

    static boolean moveFirst = true;

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

    public static int utilidadTablero(String Opcion) {

        int contador = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arregloMatrix[i][j] = listaCasillas.get(contador).getLink();
                contador++;

            }
        }

        int fila = chequeoFilas(Opcion);

        int columna = chequeoColumnas(Opcion);

        int diagonalPrincipal = chequoDigonalPrincipal(Opcion);

        int diagonalSeecundaria = chequeoDiagonalSecundaria(Opcion);

        return fila + columna + diagonalPrincipal + diagonalSeecundaria;
    }

    public static int chequeoFilas(String Opcion) {
        //Chequeo por filas
        int cond = 1;
        int cond2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (j < 3) {
                    if (!arregloMatrix[i][j].equals(Opcion)) {
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

    public static int chequeoColumnas(String Opcion) {
        //Chequeo por columnas
        int condColumna = 1;
        int cond2Columna = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (j < 3) {
                    if (!arregloMatrix[j][i].equals(Opcion)) {
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

    public static int chequoDigonalPrincipal(String Opcion) {
        //Chequeo por diagonal principal      
        if (!arregloMatrix[0][0].equals(Opcion) && !arregloMatrix[1][1].equals(Opcion) && !arregloMatrix[2][2].equals(Opcion)) {
            return 1;
        } else {
            return 0;
        }

    }

    public static int chequeoDiagonalSecundaria(String Opcion) {
        //Chequeo por diagonal secundaria      
        if (!arregloMatrix[0][2].equals(Opcion) && !arregloMatrix[1][1].equals(Opcion) && !arregloMatrix[2][0].equals(Opcion)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void possibleStates(String opcion) {
        //crea los hijos del arbol(posibles movimientos)
        try {
            LinkedList<Tree<String[][]>> matricesChildren = new LinkedList();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    String[][] matrixTmp = new String[3][3];
                    Tree<String[][]> children = new Tree<>(matrixTmp);
                    matricesChildren.addLast(children);
                }

            }

            //estados si la computadora Inicia
            int acum = 0;
            int acum2 = 0;
            int acum3 = 0;
            for (int i = 0; i < matricesChildren.size(); i++) {
                if (i < 3) {
                    String element = matricesChildren.get(i).getRoot().getContent()[0][acum] = opcion;
                    acum++;

                }
                if (i >= 3 && i < 6) {
                    String element = matricesChildren.get(i).getRoot().getContent()[1][acum2] = opcion;
                    acum2++;
                }
                if (i >= 6 && i < 9) {
                    String element = matricesChildren.get(i).getRoot().getContent()[2][acum3] = opcion;
                    acum3++;
                }

            }
            //carga el arbol con sus hijos
            tree.getRoot().setChildren(matricesChildren);

            for (Tree<String[][]> m : matricesChildren) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(m.getRoot().getContent()[i][j] + " ");	// Imprime elemento 
                    }
                    System.out.println();	// Imprime salto de línea 
                }
                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    
    public static boolean isWinner() {
        boolean filas = false;
        boolean columnas = false;
        boolean diagPrincipal = false;
        boolean diagSecundaria = false;

        int condFila = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (j < 3) {
                    if (arregloMatrix[i][j].equals("X")) {
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
                    if (arregloMatrix[j][i].equals("X")) {
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
        if (arregloMatrix[0][0].equals("X") && arregloMatrix[1][1].equals("X") && arregloMatrix[2][2].equals("X")) {
            diagPrincipal = true;
        }

        //Chequeo por diagonal secundaria      
        if (arregloMatrix[0][2].equals("X") && arregloMatrix[1][1].equals("X") && arregloMatrix[2][0].equals("X")) {
            diagSecundaria = true;
        }

        return diagPrincipal || diagSecundaria || filas || columnas;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearMatriz();
    }
}
