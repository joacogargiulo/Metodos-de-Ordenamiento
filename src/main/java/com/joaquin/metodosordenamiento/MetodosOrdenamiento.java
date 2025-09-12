package com.joaquin.metodosordenamiento;

import java.util.Scanner;

public class MetodosOrdenamiento {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int cantidadElementos;
        int contadorOE = 0;
        int burbujaMenorMayorT;        
        
        System.out.println("Ingrese la cantidad de elementos a ordenar:");
        cantidadElementos = teclado.nextInt();
        Vector vector = new Vector(cantidadElementos);
        Vector menorMayor = new Vector(cantidadElementos);
        Vector insercionBinaria = new Vector(cantidadElementos);
        
        if (cantidadElementos > 10) {
            vector.cargaRandom(0, cantidadElementos*10);
        } else {
            vector.cargarVector("Ingrese un numero entero:");
        }
        
        
        
        burbujaMenorMayorT = vector.clonar().ordenamientoBurbujaMenorAMayor();
            
        System.out.println("\nOrdenamient Burbuja de menor a mayor: T(" + burbujaMenorMayorT + ")\n");
        
        
        
        insercionBinaria = vector.clonar();
        int insercionBinariaT = insercionBinaria.ordenamientoInsecionBinaria();
        
        insercionBinaria.imprimirVector();
       
        //System.out.println("\nOrdenamient Burbuja de menor a mayor: T(" + insercionBinariaT + ")\n");
        
        
        

    }
}
