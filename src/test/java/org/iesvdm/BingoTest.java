package org.iesvdm;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.Arrays;


public class BingoTest {

    @Test
    void rellenarNumerosCarton()
    {
        int[][] carton = new int[9][3];

        Bingo.rellenarNumerosCarton(carton);

        for (int i = 0; i < carton.length; i++) {
            assertTrue(Arrays.stream(carton[i]).distinct().count() == carton[i].length);
        }
    }

    @Test
    void ponerBlancos()
    {

        int[][] carton = new int[9][3];

        Bingo.ponerBlancos(carton);

        boolean blancosColocadosCorrectamente = true;
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if (carton[i][j] == -1) {

                    int contadorBlancos = 0;
                    for (int k = 0; k < carton[i].length; k++) {
                        if (carton[k][j] == -1) {
                            contadorBlancos++;
                        }
                    }
                    if (contadorBlancos > 2) {
                        blancosColocadosCorrectamente = false;
                        break;
                    }
                }
            }
            if (!blancosColocadosCorrectamente) {
                break;
            }
        }
        assertTrue(blancosColocadosCorrectamente);
    }

    @Test
    void buscarFila()
    {
        int[][] carton = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        assertFalse(Bingo.buscarFila(carton, 0, 1));

        carton[1][1] = -1;

        assertTrue(Bingo.buscarFila(carton, 1, 1));
    }

    @Test
    void buscarColumna()
    {
        int[][] carton = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18},
                {19, 20, 21},
                {22, 23, 24},
                {25, 26, 27}
        };

        carton[0][0] = -1;
        carton[0][1] = -1;

        boolean resultado = Bingo.buscarColumna(carton, 0);
        assertTrue(resultado);

        resultado = Bingo.buscarColumna(carton, 1);
        assertFalse(resultado);
    }

    @Test
    void buscarValorRepetido()
    {
        int[] numeros = {1, 2, 3, 4, 5};

        boolean resultado = Bingo.buscarValorRepetido(numeros, 3);
        assertTrue(resultado);

        resultado = Bingo.buscarValorRepetido(numeros, 6);
        assertFalse(resultado);
    }

    @Test
    void pintarCarton()
    {
        int[][] carton = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18},
                {19, 20, 21},
                {22, 23, 24},
                {25, 26, 27}
        };

        int[] bolasSacadas = {1, 5, 9, 12, 15, 20, 22, 26};

        int aciertos = Bingo.pintarCarton(carton, bolasSacadas);

        assertEquals(8, aciertos);
    }

    @Test
    void insertarAlFinal()
    {
        int[] array = {1, 2, 3, 4, 5};

        int[] nuevoArray = Bingo.insertarAlFinal(array, 6);

        assertEquals(array.length + 1, nuevoArray.length);
        assertEquals(6, nuevoArray[nuevoArray.length - 1]);
    }

    @Test
    void ordenar()
    {
        int[] arrayDesordenado = {5, 3, 1, 4, 2};

        // Creamos el array ordenado esperado
        int[] arrayOrdenado = {1, 2, 3, 4, 5};

        // Llamamos al método para ordenar el array
        int[] arrayResultado = Bingo.ordenar(arrayDesordenado);

        // Verificamos que el array resultante sea igual al array esperado
        assertArrayEquals(arrayOrdenado, arrayResultado);
    }

}
