/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5e;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class EjercicioA {

    public static void main(String[] args) {

        // Creo el bucle del programa
        int opcion = 0;
        int tamano = 0;
        do {
            opcion = pedirOpcion();
            switch (opcion) {
                case 1 -> {
                    // Pido el tamaño de la matriz cuadrada
                    tamano = pedirTamanoMatriz();
                    // Creo la matriz con el tamaño
                    int[][] matriz = new int[tamano][tamano];
                    // Relleno la matriz manualmente
                    rellenarMatrizUsuario(matriz);
                    // Imprimo la matriz
                    imprimirMatriz(matriz);
                    // Calculo el elemento especial
                }
                case 2 -> {
                    // Pido el tamaño de la matriz cuadrada
                    tamano = pedirTamanoMatriz();
                    // Creo la matriz con el tamaño
                    int[][] matriz = new int[tamano][tamano];
                    // Relleno la matriz aleatoriamente
                    rellenarMatrizAleatorio(matriz);
                    // Imprimo la matriz
                    imprimirMatriz(matriz);
                    // Calculo el elemento especial
                }
            }
        } while (opcion != 3);
    }

    // Atributos de clase
    private static Scanner teclado = new Scanner(System.in);
    private static Random aleatorio = new Random();

    // Método que enseña la matriz por consola
    private static void imprimirMatriz(int[][] matriz) {
        System.out.println("");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("\t" + matriz[i][j] + "\t");
            }
            System.out.println("|");
        }
        System.out.println("");
    }

    // Método para imprimir el menú
    private static void imprimirMenu() {
        String menu = """
                      -----------------------------------------------
                      |          Elige una opción (El numero)       |
                      -----------------------------------------------
                      |                                             |
                      |  1. Introducir manualmente los elementos.   |
                      |                                             |
                      |  2. Rellenado aleatorio de los elementos.   |
                      |                                             |
                      |  3. Terminar el programa.                   |
                      |                                             |
                      -----------------------------------------------
                      """;
        System.out.println(menu);
    }

    // Método para pedir la opción
    private static int pedirOpcion() {
        int opcion = 0;
        do {
            try {
                imprimirMenu();
                opcion = teclado.nextInt();
                if (opcion > 3 || opcion < 1) {
                    System.out.println("Elige una opción válida.");
                    System.out.println("--------------------------------------");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Introduce un entero.");
                System.out.println("--------------------------------------");
            }
            teclado.nextLine(); // Limpio buffer
        } while (opcion > 3 || opcion < 1);
        return opcion;
    }

    // Método para pedir N (tamaño de la fila y columna de la matriz)
    private static int pedirTamanoMatriz() {
        int tamano = 0;
        do {
            try {
                System.out.println("Introduce el tamaño de la matriz [3,6]: ");
                tamano = teclado.nextInt();
                if (tamano < 3 || tamano > 6) {
                    System.out.println("Introduce un tamaño válido.");
                    System.out.println("--------------------------------------");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Introduce un entero.");
                System.out.println("--------------------------------------");
            }
        } while (tamano < 3 || tamano > 6);
        return tamano;
    }

    // Método para pedir los elementos de la matriz por teclado
    private static int pedirElemento() {
        int elemento = 0;
        do {
            try {
                System.out.println("Introduce el siguiente elemento de la matriz:");
                elemento = teclado.nextInt();
                if (elemento < 0) {
                    System.out.println("Introduce un número positivo.");
                    System.out.println("--------------------------------------");
                } else {
                    break; // Salgo del bucle una vez introducido un elemento válido
                }
            } catch (InputMismatchException ime) {
                System.out.println("Introduce un entero.");
                System.out.println("--------------------------------------");
            }
            teclado.nextLine(); // Limpio buffer
        } while (true);
        return elemento;
    }

    // Método para rellenar la matriz manualmente
    private static void rellenarMatrizUsuario(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = pedirElemento();
            }
        }
    }

    // Método para rellenar aleatoriamente
    private static void rellenarMatrizAleatorio(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = aleatorio.nextInt(0, 21);
            }
        }
    }
    // Método para calcular el elemento especial
    private static Coordenada encontrarElemento(){
        
    }
}
