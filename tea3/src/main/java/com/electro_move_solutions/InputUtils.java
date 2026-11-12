package com.electro_move_solutions;

import java.util.Scanner;

/**
 * <p>
 * Crea una classe <b>InputUtils</b> que, fent servir la classe
 * {@link java.util.Scanner}, ofereix mètodes per poder llegir dades de
 * teclat, introduint el control d’errors.
 * </p>
 * 
 * @author Santiago Zuazu Martí
 * @version 3.0
 */
public class InputUtils {

    /**
     * Fent la variable estàtica, assegurem que només es fa servir un
     * {@link java.util.Scanner} i que, a més, tothom fa servir el mateix.
     */
    private static Scanner scan = new Scanner(System.in);

    // Definim quins són els codis d'error
    /**
     * Codi d'error de tipus numèric enter.
     */
    public static final int ERROR_INT = Integer.MAX_VALUE;

    /**
     * Codi d'error de tipus numèric de doble precisió.
     */
    public static final double ERROR_REAL = Double.MAX_VALUE;

    /**
     * <p>
     * Constructor de la classe {@link InputUtils}. No realitza cap acció
     * específica, ja que la classe principal només conté el mètode main() per
     * executar el programa i un parell de mètodes per introduir coordenades o tipus
     * de connector (així no repetim instruccions).
     * </p>
     */
    public InputUtils() {
    }

    /**
     * Lectura de un {@link java.lang.String}.
     * La lectura d'un objecte String mai pot donar un error.
     * 
     * @return La cadena de text llegida.
     */
    public static String readLine() {
        return scan.nextLine();
    }

    // Revisa si el llegit és un nombre enter
    /**
     * Retorna un nombre enter introduït. Si la dada no és del tipus enter,
     * retorna el codi d'error.
     * 
     * @return El nombre enter què s'ha introduït correctament o bé el nombre
     *         Integer.MIN_VALUE com a senyal d'error en la introducció de dades.
     */
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
    /**
     * Retorna un nombre enter introduït. Si la dada introduïda no és del tipus
     * enter, retorna el codi d’error. Si està fora de rang, és a dir, és menor
     * que el valor_minim o major que el valor_maxim, també retorna el codi
     * d’error.
     * 
     * @param valor_minim Un valor enter que estableix el mínim
     *                    del rang numèric vàlid.
     * @param valor_maxim Un valor enter que estableix el màxim
     *                    del rang numèric vàlid.
     * 
     * @return El nombre enter què s'ha introduït correctament o bé el nombre
     *         Integer.MIN_VALUE com a senyal d'error en la introducció de dades.
     */
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

    /**
     * Retorna un nombre de doble precisió introduït. Si la dada no és del tipus
     * doble precisió, retorna el codi d'error.
     * 
     * @return El nombre de doble precisió què s'ha introduït correctament o bé el
     *         nombre Double.MAX_VALUE com a senyal d'error en la introducció de
     *         dades.
     */
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

    /**
     * Retorna un nombre de doble precisió introduït. Si la dada no és del tipus
     * doble precisió, retorna el codi d'error. Si està fora de rang, és a dir, és
     * menor que el valor_minim o major que el valor_maxim, també retorna el codi
     * d’error.
     * 
     * @param valor_minim Un valor de doble precisió que estableix el mínim
     *                    del rang numèric vàlid.
     * @param valor_maxim Un valor de doble precisió que estableix el màxim
     *                    del rang numèric vàlid.
     * 
     * @return El nombre de doble precisió què s'ha introduït correctament o bé el
     *         nombre Double.MAX_VALUE com a senyal d'error en la introducció de
     *         dades.
     */
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
            /*
             * Qualsevol valor que no sigui un enter pur
             * (tant si són lletres, paraules o números amb decimals)
             * serà capturat i descartat pel bloc else.
             */
            scan.next();
            resultat = ERROR_REAL;
        }
        // Per netejar el carriage return <cr> pendent
        scan.nextLine();
        return resultat;
    }

    // Cal definir un mètode per tancar l'Scanner
    /**
     * Mètode per tancar el scanner de la classe {@link java.util.Scanner}
     */
    public static void close() {
        scan.close();
    }
}
