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
            if (opcion != 3) {
                // Pido el tamaño de la matriz cuadrada
                tamano = pedirTamanoMatriz();
                // Creo la matriz con el tamaño
                int[][] matriz = new int[tamano][tamano];
                // Relleno la matriz según la opción
                switch (opcion) {
                    case 1 -> {
                        rellenarMatrizUsuario(matriz);
                    }
                    case 2 -> {
                        rellenarMatrizAleatorio(matriz);
                    }
                }
                // Imprimo la matriz
                imprimirMatriz(matriz);
                // Calculo el elemento especial
                Coordenada coordenadaElemento = encontrarElemento(matriz);
                // Imprimo el resultado
                imprimirResultado();
            }
        } while (opcion != 3);
    }

    // Atributos de clase
    private static Scanner teclado = new Scanner(System.in);
    private static Random aleatorio = new Random();
    // Hago la coordenada un atributo de clase para no tener que generar un
    // objeto nuevo en cada iteración del bucle principal
    private static Coordenada coordenada = new Coordenada();

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
                }
            } catch (InputMismatchException ime) {
                System.out.println("Introduce un entero.");
            }
            System.out.println("--------------------------------------");
            teclado.nextLine(); // Limpio buffer
        } while (tamano < 3 || tamano > 6);
        return tamano;
    }

    // Método para pedir los elementos de la matriz por teclado
    private static int pedirElemento(int numeroElemento) {
        int elemento = -1;
        do {
            try {
                System.out.println("Introduce el elemento número "
                        + numeroElemento + " de la matriz: ");
                elemento = teclado.nextInt();
                if (elemento < 0) {
                    System.out.println("Introduce un número positivo.");
                } else {
                    teclado.nextLine(); // Limpio buffer
                    break; // Salgo del bucle una vez introducido un elemento válido
                }
            } catch (InputMismatchException ime) {
                System.out.println("Introduce un entero.");
            }
            System.out.println("--------------------------------------");
            teclado.nextLine(); // Limpio buffer
        } while (true);
        return elemento;
    }

    // Método para rellenar la matriz manualmente
    private static void rellenarMatrizUsuario(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                // El paramétro del método es el número del elemento que pido
                matriz[i][j] = pedirElemento(i * matriz[0].length + j + 1);
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

    // Método para calcular el elemento especial (Devuelve el primero que lo cumpla)
    private static Coordenada encontrarElemento(int[][] matriz) {
        // Pongo la coordenada con los valores estándar para iniciar la búsqueda
        restablecerCoordenada();

        // Inicio la búsqueda
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                // Me quedo con el elemento mayor de la fila
                if (matriz[i][j] > coordenada.getElemento()) {
                    coordenada.setElemento(matriz[i][j]);
                    coordenada.setCoordenadaY(i);
                    coordenada.setCoordenadaX(j);
                }
            }
            // Compruebo si ese elemento cumple el requisito de la columna y si
            // lo cumple devuelvo su coordenada
            if (comprobarColumna(matriz)) {
                return coordenada;
            }
            // Si no esta en esta fila restauro el valor de coordenada 
            // para que busque en la siguiente
            restablecerCoordenada();
        }
        // En el caso en que no se cumpla ninguna vez el if de arriba devuelvo
        // una coordenada (-1, -1, -1) (El valor predeterminado)
        restablecerCoordenada();
        return coordenada;
    }

    // Método para comprobar si es el menor elemento de su columna
    private static boolean comprobarColumna(int[][] matriz) {
        boolean cumple = true;
        for (int i = 0; i < matriz.length; i++) {
            if (coordenada.getElemento() > matriz[i][coordenada.getCoordenadaX()]) {
                return (!cumple);
            }
        }
        return cumple;
    }

    // Método que imprime el resultado por consola
    private static void imprimirResultado() {
        System.out.println("---------------------------------------------");
        if (coordenada.getCoordenadaX() != -1) {
            String stringResultado = """
                                     El elemento especial está en la fila %d,
                                     en la columna %d y el elemento es %d.
                                     """.
                    formatted(coordenada.getCoordenadaY(), coordenada.getCoordenadaX(),
                            coordenada.getElemento());
            System.out.println(stringResultado);
            System.out.println("");
        } else {
            System.out.println("No existe ningún elemento especial.");
        }
    }
    
    // Método que establece el valor predeterminado a coordenada
    private static void restablecerCoordenada(){
        coordenada.setCoordenadaX(-1);
        coordenada.setCoordenadaY(-1);
        coordenada.setElemento(-1);
    }
}
