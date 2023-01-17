/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5e;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class EjercicioB {

    public static void main(String[] args) {

        int alturaCopa = 0;
        alturaCopa = pedirAltura();
        String[][] matriz = crearMatriz(alturaCopa);
        imprimirMatriz(matriz);
    }

    // Atributos de clase
    private static Scanner teclado = new Scanner(System.in);

    // Método para pedir la altura de la copa del árbol
    private static int pedirAltura() {
        int alturaCopa = 0;
        do {
            try {
                System.out.println("Introduce la altura de la copa del árbol: ");
                alturaCopa = teclado.nextInt();
                if (alturaCopa < 2 || alturaCopa > 10) {
                    System.out.println("La altura tiene que estar entre 2 y 10.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("La altura tiene que ser un entero.");
            }
            System.out.println("----------------------------------------------");
            teclado.nextLine(); // Limpio el buffer
        } while (alturaCopa < 2 || alturaCopa > 10);
        return alturaCopa;
    }

    // Método que almacena el árbol en la matriz
    private static String[][] crearMatriz(int alturaCopa) {
        final int ALTURA_TRONCO = 2;
        // Creo la matriz en función de la altura de la copa y del tronco
        String[][] matriz = new String[(alturaCopa + ALTURA_TRONCO)][(alturaCopa * 2) - 1];
        // Ajusto la altura de la copa teniendo en cuenta que la matriz empieza en 0
        alturaCopa--;
        // Relleno los elementos de la matriz correspondientes a la sección de la copa
        for (int i = 0; i < matriz.length - ALTURA_TRONCO; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (j < (alturaCopa - i) || j > (alturaCopa + i)) ? " " : "*";
            }
        }
        // Relleno los elementos de la matriz correspondientes a la sección del tronco
        for (int i = matriz.length - ALTURA_TRONCO; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (j != alturaCopa) ? " " : "*";
            }
        }
        return matriz;
    }

    // Método para imprimir la matriz
    private static void imprimirMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }
}