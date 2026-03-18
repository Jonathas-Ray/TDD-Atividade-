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

    public static double desconto(int valor, int porcentagem){
        return valor - (valor * (porcentagem/100.0));
    }

    public static double desconto(int valor, boolean vip){ return vip? valor - (valor * 0.15) : valor;}

    public static double media (int nota1, int nota2, int nota3){return (nota1+nota2+nota3) / 3;}

    public static boolean verificaAprovacao(int nota){ return (nota>=7)? true : false;}
}
