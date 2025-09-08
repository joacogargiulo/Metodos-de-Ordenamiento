package com.joaquin.metodosordenamiento;


import java.util.Random;
import java.util.Scanner;

public class Vector{
    private Scanner teclado = new Scanner(System.in);
    private Random random = new Random();
    private int[] vector;
    private int size;
    
    public Vector(int tamano) {
        vector = new int[tamano];
        size = 0;
    }
    
    public Vector() {
        vector = new int[0];
        size = 0;
    }
    
    public void cargarVector(String mensaje) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println(mensaje);
            vector[i] = teclado.nextInt();
            size++;
        }
    }
    
    
    public int ordenamientoBurbujaMenorAMayor() {
        int T = 0;
        T++; // asignacion: i = 0
        T+= 2; // comparacion y resta: i < size - 1
        for (int i = 0; i < size - 1; i++) {                        
            T++; // asignacion j = 0
            for (int j = 0; j < size - i - 1; j++) {                                           
                T+= 4; // 2 accesos a vector, comparacion y suma: vector[j] > vector[j + 1]
                if (vector[j] > vector[j + 1]) {
                    int temp = vector[j];
                    T+= 2; // asignacion y acceso a vector: temp = vector[j]
                    vector[j] = vector[j + 1];
                    T+= 4; // 2 accesos a vector, suma y asignacion: vector[j] = vector[j + 1]
                    vector[j + 1] = temp;
                    T+= 3; // acceso a vector, suma y asignacion: vector[j + 1] = temp
                }
                T+= 3; // comparacion y  2 restas: j < size - i - 1
                T+= 2; // suma y aignacion: j++  
            }
            T+= 2; // comparacion y resta: i < size - 1
            T+= 2; // suma y aignacion: i++
        }
        
        return T;
    }
    
    
    public int ordenamientoInsecionBinaria () {        
        int T = 0;
        
        for (int i = 1; i < size; i++) {
            int aux = vector[i];
            int primero = 0;
            int ultimo = i-1;
            
            while(primero <= ultimo) {
                int c = (primero + ultimo) / 2;
                if (aux < vector[c]) {
                    ultimo = c-1;
                } else {
                    primero = c+1;
                }
            }
            
            for (int j = i-1; j >= primero; j--) {
                vector[j+1] = vector[j];
            }
            vector[primero] = aux;
        }

        return T;
    }
    
    
    
    public void cargarVector(String mensaje, int min, int max) {
        for (int i = 0; i < vector.length; i++) {
            int ingreso;
            do {
                System.out.println(mensaje);
                ingreso = teclado.nextInt();
                
                if (ingreso < min || ingreso > max) {
                    System.out.println("ERROR - Ingrese un numero valido");
                }
            } while (ingreso < min || ingreso > max);
            vector[i] = ingreso;
            size++;
        }
    }
    
    public void imprimirVector(){
        for (int i = 0; i < size; i++) {
            System.out.println("vector[" + (i+1) + "] = " + vector[i]);
        }
    }
    
    public void cargaRandom(int min, int max){
        size = 0;
        for (int i = 0; i < vector.length; i++) {
            vector[i] = random.nextInt(max - min + 1) + min;
            size++;
        }
    }
    
    public int sumarElementos() {
        int suma = 0;
        for (int i = 0; i < size; i++) {
            suma += (int) vector[i];
        }
        return suma;
    }
    
    public void cargaRandomPrimos(int min, int max){
        for (int i = 0; i < vector.length; i++) {
            do {
                vector[i] = random.nextInt(max - min + 1) + min;
                size++;
            } while (!esPrimo((int) vector[i]));
        }
    }
    
    private boolean esPrimo(int x) {
        if (x <= 1) return false; // Si es 0 o 1 no es primo
        if (x <= 3) return true; // Si es 2 o 3 si es primo
        if (x % 2 == 0 || x % 3 == 0) return false; // Si es divisible en 2 o 3 no es primo
        for (int i = 5; (i*i) <= x; i+=6) { //Evaluamos todos los posibles divisores    
            if (x % i == 0 || x % (i+2) == 0) return false;
        }
        return true;
    }
    
    public int elementoMayor() {
        int mayor = (int) vector[0];
        for (int i = 1; i < size; i++) {
            if ((int) vector[i] > mayor) {
                mayor = (int) vector[i];
            }
        }
        return mayor;
    }
    
    public int length() {
        return vector.length; // Devuelve la capacidad del array 
    }
    
    public Object getElemento(int x){
        return vector[x]; // Devuelve el elemento del indice que se solicita
    }
    
    public int size() {
        return this.size; // Devuelve la cantidad real de elementos que tiene el array.
    }
    
    public void add(int x){
        if (size == vector.length) {
            // aumento la capacidad
            int nuevaCapacidad = vector.length + 1;
            int[] aux = new int[nuevaCapacidad];
            System.arraycopy(vector, 0, aux, 0, vector.length);
            vector = aux;
        }
        vector[size] = x;
        size++;
    }
    
    public void invertir(){
        int aux; //Variable auxiliar
        for (int i = 0; i < size/2; i++) {
            //Se intercambia el elemento i con el elemento n-i-1
            aux = vector[size-i-1];
            vector[size-i-1] = vector[i];
            vector[i] = aux;
        }
    }
    
    public Vector clonar() {
        Vector clon = new Vector();
        
        for (int i = 0; i < size; i++) {
            clon.add(vector[i]);
        }
        
        return clon;
    }
}
