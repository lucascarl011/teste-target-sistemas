package com.target.TesteTargetSistemas;

import java.util.Scanner;

public class Exe5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String entrada = scanner.nextLine();

        String invertida = inverterString(entrada);
        System.out.println("String invertida: " + invertida);
    }

    public static String inverterString(String texto) {
        StringBuilder invertida = new StringBuilder();
        for (int i = texto.length() - 1; i >= 0; i--) {
            invertida.append(texto.charAt(i));
        }
        return invertida.toString();
    }
}
