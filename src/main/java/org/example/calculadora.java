package org.example;

public class calculadora {
    public static int soma(int a, int b){
        return a + b;
    }

     public static int sub(int a, int b){
        return a - b;
     }

    public static int multi(int a, int b){
        return a * b;
    }

    public static double div(int a, int b){
        //FLOAT E DOUBLE CONSIDERAM 10/0 = INFINITO E INFINITO=NÚMERO
        return a / b;
    }
}
