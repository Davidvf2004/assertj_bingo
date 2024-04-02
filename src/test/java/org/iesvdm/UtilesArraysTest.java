package org.iesvdm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

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

        int[] arrayOriginal = {1, 2, 3, 4, 2, 5, 2};
        int elementoAEliminar = 2;


        int[] resultado = UtilesArrays.eliminar(arrayOriginal, elementoAEliminar);

        Assertions.assertNotNull(resultado);

        for (int elemento : resultado) {
            Assertions.assertNotEquals(elementoAEliminar, elemento);
        }

        int contador = 0;
        for (int elemento : arrayOriginal) {
            if (elemento != elementoAEliminar) {
                contador++;
            }
        }
        Assertions.assertEquals(contador, resultado.length);
    }

    @Test
    void ordenar()
    {
        int[] arrayOriginal = {5, 3, 9, 1, 7};

        int[] resultado = UtilesArrays.ordenar(arrayOriginal);

        Assertions.assertNotNull(resultado);

        for (int i = 0; i < resultado.length - 1; i++) {
            Assertions.assertTrue(resultado[i] <= resultado[i + 1]);
        }
    }

    @Test
    void desordenar()
    {
        int[] arrayOriginal = {1, 2, 3, 4, 5};
        int[] copiaArrayOriginal = Arrays.copyOf(arrayOriginal, arrayOriginal.length);

        UtilesArrays.desordenar(arrayOriginal);

        Assertions.assertNotNull(arrayOriginal);

        boolean esDiferente = false;
        for (int i = 0; i < arrayOriginal.length; i++) {
            if (arrayOriginal[i] != copiaArrayOriginal[i]) {
                esDiferente = true;
                break;
            }
        }
        Assertions.assertTrue(esDiferente);
    }

    @Test
    void invertir()
    {
        int[] arrayOriginal = {1, 2, 3, 4, 5};
        int[] arrayEsperado = {5, 4, 3, 2, 1};

        int[] resultado = UtilesArrays.invertir(arrayOriginal);

        Assertions.assertNotNull(resultado);
        Assertions.assertArrayEquals(arrayEsperado, resultado);
    }

    @Test
    void imprimir()
    {
        int[] array = {1, 2, 3, 4, 5};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UtilesArrays.imprimir(array);

        String expectedOutput = "\t[1, 2, 3, 4, 5]" + System.lineSeparator();
        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void estaOrdenado()
    {
        int[] arrayOrdenado = {1, 2, 3, 4, 5};
        int[] arrayDesordenado = {5, 4, 3, 2, 1};

        boolean resultadoOrdenado = UtilesArrays.estaOrdenado(arrayOrdenado);
        boolean resultadoDesordenado = UtilesArrays.estaOrdenado(arrayDesordenado);

        Assertions.assertTrue(resultadoOrdenado);
        Assertions.assertFalse(resultadoDesordenado);
    }

    @Test
    void buscar()
    {
        int[] array = {1, 2, 3, 4, 5};

        int posicionElementoExistente = UtilesArrays.buscar(array, 3);
        int posicionElementoNoExistente = UtilesArrays.buscar(array, 6);

        Assertions.assertEquals(2, posicionElementoExistente);
        Assertions.assertEquals(-1, posicionElementoNoExistente);
    }

    @Test
    void partirPor()
    {
        int[] arrayOriginal = {1, 2, 3, 4, 5};
        int posicionInicio = 1;
        int posicionCorte = 4;
        int[] arrayEsperado = {2, 3, 4};

        int[] resultado = UtilesArrays.partirPor(arrayOriginal, posicionInicio, posicionCorte);

        Assertions.assertNotNull(resultado);
        Assertions.assertArrayEquals(arrayEsperado, resultado);
    }

    @Test
    void sonIguales()
    {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {1, 2, 3, 4, 6};

        boolean resultado1 = UtilesArrays.sonIguales(array1, array2);
        boolean resultado2 = UtilesArrays.sonIguales(array1, array3);

        Assertions.assertTrue(resultado1);
        Assertions.assertFalse(resultado2);
    }

    @Test
    void elementosIguales()
    {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {1, 2, 3, 4, 6};

        boolean resultado1 = UtilesArrays.elementosIguales(array1, array2, 3);
        boolean resultado2 = UtilesArrays.elementosIguales(array1, array3, 4);

        Assertions.assertTrue(resultado1);
        Assertions.assertFalse(resultado2);
    }

    @Test
    void concatenarArrays()
    {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] arrayEsperado = {1, 2, 3, 4, 5, 6};

        int[] resultado = UtilesArrays.concatenarArrays(array1, array2);

        Assertions.assertArrayEquals(arrayEsperado, resultado);
    }
}

