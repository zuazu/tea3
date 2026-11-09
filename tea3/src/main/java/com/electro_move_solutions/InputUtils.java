package com.electro_move_solutions;

import java.util.Scanner;

public class InputUtils {

    // Fent la variable estàtica, assegurem que només es fa servir un Scanner
    // i que, a més, tothom fa servir el mateix.
    private static Scanner scan = new Scanner(System.in);

    // Definim quins són els codis d'error
    public static final int ERROR_INT = Integer.MAX_VALUE;
    public static final double ERROR_REAL = Double.MAX_VALUE;

    // La lectura d'un String mai pot donar un error
    public static String readLine() {
        return scan.nextLine();
    }

    // Revisa si el llegit és un nombre enter
    public static int readInt() {
        int resultat;
        if (scan.hasNextInt())
            resultat = scan.nextInt();
        else {
            // Ignorar el valor de l'entrada
            scan.next();
            resultat = ERROR_INT;
        }
        // Per llegir el <cr>
        scan.nextLine();
        return resultat;
    }

    // Revisa si el llegit és un nombre enter i està comprès dins d'un rang.
    public static int readInt(int valorMinim, int valorMaxim) {
        //
        int resultat = 0;
        if (scan.hasNextInt()) {
            resultat = scan.nextInt();
            // Verifica que sigui un valor dins del rang
            if (resultat < valorMinim || resultat > valorMaxim) {
                // En cas que no estigui dins el rang, retornarà el codi d'error.
                resultat = ERROR_INT;
            }
        } else {
            scan.next();
            resultat = ERROR_INT;
        }
        scan.nextLine();
        return resultat;
    }

    public static double readReal() {
        double resultat;
        if (scan.hasNextDouble())
            resultat = scan.nextDouble();
        else {
            // Ignorar el valor de l'entrada
            scan.next();
            resultat = ERROR_REAL;
        }
        scan.nextLine();
        return resultat;
    }

    // Revisa si el llegit és un nombre enter i està comprès dins d'un rang.
    public static double readReal(double valorMinim, double valorMaxim) {
        //
        double resultat = 0.0;
        if (scan.hasNextDouble()) {
            resultat = scan.nextDouble();
            // Verifica que sigui un valor dins del rang
            if (resultat < valorMinim || resultat > valorMaxim) {
                // En cas que no estigui dins el rang, retornarà el valor negatiu més petit
                resultat = ERROR_REAL;
            }
            //
        } else {
            scan.next();
            resultat = ERROR_REAL;
        }
        scan.nextLine();
        return resultat;
    }

    // Cal definir un mètode per tancar l'Scanner
    public static void close() {
        scan.close();
    }
}
