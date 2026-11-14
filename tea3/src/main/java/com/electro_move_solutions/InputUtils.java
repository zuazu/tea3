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

    /**
     * <p>
     * Mètode per llegir un número enter des de la consola.
     * Si l'usuari introdueix un valor que no és un número enter,
     * es mostrarà un missatge d'error i es tornarà a demanar l'entrada.
     * </p>
     *
     * <p>
     * El mètode Integer.parseInt() (ni tampoc Double.parseDouble()) no pot llançar
     * una NullPointerException directament si li passes un valor null.
     * </p>
     *
     * <p>
     * En lloc d'això, si li passes un argument null, el mètode llançarà una
     * NumberFormatException.
     * </p>
     *
     * <p>
     * El primer que fan en rebre el text és comprovar si la cadena és nul·la
     * (null). Com que no pot llegir cap caràcter d'un objecte null,
     * llança una excepció de format numèric (NumberFormatException)
     * per indicar que la cadena no és vàlida per ser convertida.
     * </p>
     *
     * @param missatge   El missatge a mostrar per demanar l'entrada.
     * @param valorMinim El valor numèric mínim acceptat.
     * @param valorMaxim El valor numèric màxim acceptat.
     * @return El número enter llegit.
     */
    public static int llegirOpcio(String missatge, int valorMinim, int valorMaxim) {
        // El valor enter llegit que es retorna
        int numeroEnter = 0;
        // Canvia de valor a cert quan l'entrada és correcta
        boolean correcta = false;
        do {
            System.out.print(missatge);
            String entrada = scan.nextLine().trim();
            try {
                /*
                 * Si la conversió té èxit, retorna directament un valor primitiu de tipus
                 * numèric enter
                 */
                numeroEnter = Integer.parseInt(entrada);
                /*
                 * Si Integer.parseInt(entrada) falla, salta directament al catch i mai executa
                 * la línia següent
                 */
                if (numeroEnter <= valorMaxim && numeroEnter >= valorMinim) {
                    correcta = true;
                } else {
                    System.out.println("\nEntrada errònia: si us plau, introdueix un valor entre el 1 i el 5.");
                }
            } catch (NumberFormatException e) {
                /*
                 * El bloc catch captura l'excepció (NumberFormatException) que llança el mètode
                 * Integer.parseInt() quan la cadena de text no té el format numèric adequat
                 * (número enter sense lletres o símbols). Això evita que el
                 * programa es tanqui de sobte per un error no controlat.
                 */
                // Mostra un missatge clar per pantalla informant l'usuari de l'equivocació i
                // demanant-li de nou un número correcte.
                System.out.println("\nEntrada errònia: si us plau, introdueix un número enter.");
                /*
                 * Com que la variable correcta no es pasa a true dins del catch, el bucle
                 * do-while torna a començar i li torna a demanar l'entrada a l'usuari.
                 */
            }
        } while (!correcta);
        return numeroEnter;
    }

    /**
     * Imprimir per pantalla els elements no nuls de qualsevol array d'objectes.
     *
     * @param array L'array d'objectes que es vol mostrar.
     */
    public static void imprimirArray(Object[] array) {
        System.out.print("\n");
        for (Object element : array) {
            if (element != null) { // Evita imprimir les posicions buides (com vehicles[6] i [7])
                System.out.println(element.toString());
            }
        }
        System.out.print("\n");
    }

    // Cal definir un mètode per tancar l'Scanner
    /**
     * Mètode per tancar el scanner de la classe {@link java.util.Scanner}
     */
    public static void close() {
        scan.close();
    }
}
