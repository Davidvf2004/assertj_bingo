package org.iesvdm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class UtilesArraysTest {
    @Test
    void limpiar() {
        int[] arrayOriginal = {1, 2, 3, 4, 5};

        int[] resultado = UtilesArrays.limpiar();

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(0, resultado.length);
    }

    @Test
    void rellenar()
    {
        int[] array = new int[5];
        int numeroElementos = 5;

        int[] resultado = UtilesArrays.rellenar(array, numeroElementos);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(numeroElementos, resultado.length);

        for (int i = 0; i < resultado.length; i++) {
            Assertions.assertEquals(0, resultado[i]);
        }
    }

    @Test
    void insertarAlFinal()
    {
        int[] arrayOriginal = {1, 2, 3, 4, 5};
        int elemento = 6;

        int[] resultado = UtilesArrays.insertarAlFinal(arrayOriginal, elemento);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(arrayOriginal.length + 1, resultado.length);

        Assertions.assertEquals(elemento, resultado[resultado.length - 1]);
    }
    @Test
    void insertarAlPrincipio() {
        int[] arrayOriginal = {1, 2, 3, 4, 5};
        int elemento = 0;

        int[] resultado = UtilesArrays.insertarAlPrincipio(arrayOriginal, elemento);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(arrayOriginal.length + 1, resultado.length);
        Assertions.assertEquals(elemento, resultado[0]);

        for (int i = 0; i < arrayOriginal.length; i++) {
            Assertions.assertEquals(arrayOriginal[i], resultado[i + 1]);
        }
    }

    @Test
    void insertarOrdenado()
    {
        int[] arrayOriginal = {1, 3, 5, 7, 9};
        int elemento = 4;

        int[] resultado = UtilesArrays.insertarOrdenado(arrayOriginal, elemento);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(arrayOriginal.length + 1, resultado.length);

        for (int i = 0; i < resultado.length - 1; i++) {
            Assertions.assertTrue(resultado[i] <= resultado[i + 1]);
        }

        Assertions.assertTrue(UtilesArrays.buscar(resultado, elemento) >= 0);
    }

    @Test
    void eliminarUltimo()
    {
        int[] arrayOriginal = {1, 2, 3, 4, 5};

        int[] resultado = UtilesArrays.eliminarUltimo(arrayOriginal);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(arrayOriginal.length - 1, resultado.length);

        for (int i = 0; i < resultado.length; i++) {
            Assertions.assertEquals(arrayOriginal[i], resultado[i]);
        }
    }

    @Test
    void eliminarPrimero() {
        int[] arrayOriginal = {1, 2, 3, 4, 5};

        int[] resultado = UtilesArrays.eliminarPrimero(arrayOriginal);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(arrayOriginal.length - 1, resultado.length);

        for (int i = 0; i < resultado.length; i++) {
            Assertions.assertEquals(arrayOriginal[i + 1], resultado[i]);
        }
    }

    @Test
    void eliminarPosicion()
    {

        int[] arrayOriginal = {1, 2, 3, 4, 5};
        int posicionAEliminar = 2;


        int[] resultado = UtilesArrays.eliminarPosicion(arrayOriginal, posicionAEliminar);


        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(arrayOriginal.length - 1, resultado.length);

        for (int i = 0; i < posicionAEliminar; i++) {
            Assertions.assertEquals(arrayOriginal[i], resultado[i]);
        }
        for (int i = posicionAEliminar; i < resultado.length; i++) {
            Assertions.assertEquals(arrayOriginal[i + 1], resultado[i]);
        }
    }

    @Test
    void eliminar()
    {

    }

    @Test
    void ordenar()
    {

    }

    @Test
    void desordenar()
    {

    }

    @Test
    void invertir()
    {

    }
}

