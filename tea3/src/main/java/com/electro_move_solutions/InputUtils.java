package com.electro_move_solutions;

import java.util.Scanner;

/**
 * <p>
 * Crea una classe <b>InputUtils</b> que, fent servir la classe
 * {@link java.util.Scanner}, ofereix mètodes per poder llegir dades des de
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

    /**
     * <p>
     * Constructor de la classe {@link InputUtils}.
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

    /**
     * <p>
     * Mètode per llegir una matrícula de cotxe des de la consola.
     * Si l'usuari introdueix un valor que no és en el format adient, es mostrarà un
     * missatge d'error i es tornarà a demanar l'entrada repetidament.
     * </p>
     * 
     * @return Un valor enter introduït amb el format correcte.
     */
    public static String readValidLicensePlate() {
        String matricula = "";
        // Expressió regular de una matrícula de vehicle:
        // 4 dígits (\d{4}) seguits de 3 lletres ([a-zA-Z]{3})
        String regex = "^\\d{4}[a-zA-Z]{3}$";

        boolean formatCorrecte = false;
        // Mentre el format que s'introdueixi no sigui correcte es repetirà el bucle
        while (!formatCorrecte) {
            System.out.print("Matrícula: ");
            /*
             * Llegir una línia de text introduïda per l'usuari (amb
             * readLine()), eliminar els espais en blanc del principi i del final (amb
             * .trim()), i guardar el resultat net a la variable de text matricula.
             */
            matricula = readLine().trim();
            // Indica si aquesta cadena coincideix o no amb l'expressió regular donada.
            // El mètode matches() de la classe String retorna un valor booleà.
            if (matricula.matches(regex)) {
                formatCorrecte = true;
            } else {
                System.out.println("Entrada errònia: si us plau, introdueix el següent format:");
                System.out.println("calen exactament 4 dígits seguits de 3 lletres (ex: 1234ABC).");
            }
        }
        // Converteix automàticament tot a majúscules i ho retorna
        return matricula.toUpperCase();
    }

    /**
     * <p>
     * Obtenir les dades introduïdes per teclat de les coordenades de una ubicació.
     * A continuació genera una instància de {@link Coordenades}, que és retornada.
     * </p>
     * 
     * <p>
     * Aquest mètode <b>introduirCoordenades</b> s'ha desenvolupat per evitar
     * repetir un bloc de línies de codi cada cop que es genera una ubicació en el
     * mètode <b>main</b> d'aquesta mateixa classe {@link ElectroMove}.
     * </p>
     * 
     * <p>
     * Per a la lectura de la latitud i la longitud, utilitza els mètodes de
     * {@link InputUtils} que permeten especificar els valors mínim i màxim. Es
     * considera que aquestes dades s'introdueixen correctament, de manera que no
     * cal gestionar els possibles errors de lectura al mètode <b>main()</b>.
     * </p>
     * 
     * @return Un objecte de la classe {@link Coordenades} que a partir de una
     *         latitud i una longitud defineix una ubicació.
     */
    public static Coordenades introduirCoordenades() {
        System.out.println("Ubicació:");
        double latitud = InputUtils.readReal("\tLatitud: ", Coordenades.MIN_LAT, Coordenades.MAX_LAT);
        double longitud = InputUtils.readReal("\tLongitud: ", Coordenades.MIN_LONG, Coordenades.MAX_LONG);
        Coordenades ubicacio = new Coordenades(latitud, longitud);
        return ubicacio;
    }

    // Revisa si el llegit és un nombre enter.
    /**
     * 
     * <p>
     * Mètode per llegir un número enter des de la consola.
     * Si l'usuari introdueix un valor que no és un número enter, es mostrarà un
     * missatge d'error i es tornarà a demanar l'entrada repetidament.
     * </p>
     *
     * 
     * <p>
     * El primer que fa <b>Integer.parseInt()</b> en rebre el text és comprovar si
     * la cadena és nul·la (null). Com que no pot llegir cap caràcter d'un objecte
     * null, llança una excepció de format numèric (<b>NumberFormatException</b>)
     * per indicar que la cadena no és vàlida per ser convertida.
     * </p>
     * 
     * <p>
     * El mètode <b>Integer.parseInt()</b> (ni tampoc <b>Double.parseDouble()</b>)
     * no pot llançar una <b>NullPointerException</b> directament si li passes un
     * valor null. En lloc d'això, si li passes un argument null, el mètode llançarà
     * una <b>NumberFormatException</b>.
     * </p>
     * 
     * @param missatge El missatge que es mostra per demanar l'entrada.
     * @return Un valor enter introduït correctament.
     */
    public static int readInt(String missatge) {
        // El valor enter llegit que es retorna
        int resultat = 0;
        // Canvia de valor a cert quan l'entrada és correcta
        boolean correcta = false;
        do {
            /*
             * Demanar l'entrada adient d'un valor mitjançant un missatge.
             */
            System.out.print(missatge);
            /*
             * Llegir una línia de text introduïda per l'usuari (amb
             * readLine()), eliminar els espais en blanc del principi i del final (amb
             * .trim()), i guardar el resultat net a la variable de text entrada.
             */
            String entrada = readLine().trim();
            try {
                /*
                 * Si la conversió té èxit, retorna directament un valor primitiu de tipus
                 * numèric enter.
                 * 
                 * Si Integer.parseInt(entrada) falla, salta directament al catch i mai executa
                 * la línia següent
                 */
                resultat = Integer.parseInt(entrada);
                correcta = true;
            } catch (NumberFormatException e) {
                /*
                 * El bloc catch captura immediatament l'excepció (NumberFormatException) que
                 * llança el mètode Integer.parseInt() quan la cadena de text no té el format
                 * numèric adequat (número enter sense lletres o símbols). Això evita que el
                 * programa es tanqui de sobte per un error no controlat.
                 */
                // Mostra un missatge clar per pantalla informant a l'usuari de l'equivocació i
                // demanant-li de nou un número com cal.
                System.out.println("\nEntrada errònia: si us plau, introdueix un número enter.");
                /*
                 * Com que la variable booleana no es passa a true, el bucle
                 * do-while torna a començar i torna a demanar l'entrada a l'usuari.
                 */
            }
        } while (!correcta);
        return resultat;
    }

    // Revisa si el llegit és un nombre enter i està comprès dins d'un rang.
    /**
     * 
     * <p>
     * Mètode per llegir un número enter des de la consola.
     * Si l'usuari introdueix un valor que no és un número enter, o bé no està dins
     * del rang de valors, es mostrarà un missatge d'error i es tornarà a demanar
     * l'entrada repetidament.
     * </p>
     *
     * 
     * <p>
     * El primer que fa <b>Integer.parseInt()</b> en rebre el text és comprovar si
     * la cadena és nul·la (null). Com que no pot llegir cap caràcter d'un objecte
     * null, llança una excepció de format numèric (<b>NumberFormatException</b>)
     * per indicar que la cadena no és vàlida per ser convertida.
     * </p>
     * 
     * <p>
     * El mètode <b>Integer.parseInt()</b> (ni tampoc <b>Double.parseDouble()</b>)
     * no pot llançar una <b>NullPointerException</b> directament si li passes un
     * valor null. En lloc d'això, si li passes un argument null, el mètode llançarà
     * una <b>NumberFormatException</b>.
     * </p>
     *
     * 
     * @param missatge    El missatge que es mostra per demanar l'entrada.
     * @param valorMinim Un valor que estableix el mínim
     *                    del rang numèric vàlid.
     * @param valorMaxim Un valor que estableix el màxim
     *                    del rang numèric vàlid.
     * @return Un valor enter introduït correctament.
     */
    public static int readInt(String missatge, int valorMinim, int valorMaxim) {
        // El valor enter llegit que es retorna
        int resultat = 0;
        // Canvia de valor a cert quan l'entrada és correcta
        boolean correcta = false;
        do {
            /*
             * Demanar l'entrada adient d'un valor mitjançant un missatge.
             */
            System.out.print(missatge);
            /*
             * Llegir una línia de text introduïda per l'usuari (amb
             * readLine()), eliminar els espais en blanc del principi i del final (amb
             * .trim()), i guardar el resultat net a la variable de text entrada.
             */
            String entrada = readLine().trim();
            try {
                /*
                 * Si la conversió té èxit, retorna directament un valor primitiu de tipus
                 * numèric enter.
                 * 
                 * Si Integer.parseInt(entrada) falla, salta directament al catch i mai executa
                 * la línia següent
                 */
                resultat = Integer.parseInt(entrada);
                // Verifica que sigui un valor dins del rang passat com arguments al mètode
                if (resultat <= valorMaxim && resultat >= valorMinim) {
                    correcta = true;
                } else {
                    System.out.println("\nEntrada errònia: si us plau, introdueix un valor entre el " + valorMinim
                            + " i el " + valorMaxim + ".");
                }
            } catch (NumberFormatException e) {
                /*
                 * El bloc catch captura immediatament l'excepció (NumberFormatException) que
                 * llança el mètode Integer.parseInt() quan la cadena de text no té el format
                 * numèric adequat (número enter sense lletres o símbols). Això evita que el
                 * programa es tanqui de sobte per un error no controlat.
                 */
                // Mostra un missatge clar per pantalla informant a l'usuari de l'equivocació i
                // demanant-li de nou un número com cal.
                System.out.println("\nEntrada errònia: si us plau, introdueix un número enter.");
                /*
                 * Com que la variable booleana no es passa a true, el bucle
                 * do-while torna a començar i torna a demanar l'entrada a l'usuari.
                 */
            }
        } while (!correcta);
        return resultat;
    }

    // Revisa si el llegit és un nombre real de doble precisió
    /**
     * 
     * <p>
     * Mètode per llegir un nombre real de doble precisió des de la consola.
     * Si l'usuari introdueix un valor que no és un nombre real, es mostrarà un
     * missatge d'error i es tornarà a demanar l'entrada repetidament.
     * </p>
     *
     * 
     * <p>
     * El primer que fa <b>Double.parseDouble()</b> en rebre el text és comprovar si
     * la cadena és nul·la (null). Com que no pot llegir cap caràcter d'un objecte
     * null, llança una excepció de format numèric (<b>NumberFormatException</b>)
     * per indicar que la cadena no és vàlida per ser convertida.
     * </p>
     * 
     * <p>
     * El mètode <b>Double.parseDouble()</b> (ni tampoc <b>Integer.parseInt()</b>)
     * no pot llançar una <b>NullPointerException</b> directament si li passes un
     * valor null. En lloc d'això, si li passes un argument null, el mètode llançarà
     * una <b>NumberFormatException</b>.
     * </p>
     *
     * 
     * @param missatge El missatge que es mostra per demanar l'entrada.
     * @return Un nombre real de doble precisió introduït correctament.
     */
    public static double readReal(String missatge) {
        // El nombre real de doble precisió llegit que es retorna
        double resultat = 0;
        // Canvia de valor a cert quan l'entrada és correcta
        boolean correcta = false;
        do {
            /*
             * Demanar l'entrada adient d'un valor mitjançant un missatge.
             */
            System.out.print(missatge);
            /*
             * Llegir una línia de text introduïda per l'usuari (amb
             * readLine()), eliminar els espais en blanc del principi i del final (amb
             * .trim()), i guardar el resultat net a la variable de text entrada.
             */
            String entrada = readLine().trim();
            try {
                /*
                 * Si la conversió té èxit, retorna directament un valor primitiu de tipus
                 * nombre real de doble precisió.
                 * 
                 * Si Double.parseDouble(entrada) falla, salta directament al catch i mai
                 * executa la línia següent.
                 */
                resultat = Double.parseDouble(entrada);
                correcta = true;
            } catch (NumberFormatException e) {
                /*
                 * El bloc catch captura immediatament l'excepció (NumberFormatException) que
                 * llança el mètode Double.parseDouble() quan la cadena de text no té el format
                 * numèric adequat (nombre real sense lletres o símbols). Això evita que el
                 * programa es tanqui de sobte per un error no controlat.
                 */
                // Mostra un missatge clar per pantalla informant a l'usuari de l'equivocació i
                // demanant-li de nou un número com cal.
                System.out.println("\nEntrada errònia: si us plau, introdueix un nombre real de doble precisió.");
                /*
                 * Com que la variable booleana no es passa a true, el bucle
                 * do-while torna a començar i torna a demanar l'entrada a l'usuari.
                 */
            }
        } while (!correcta);
        return resultat;
    }

    // Revisa si el llegit és un nombre real de doble precisió i està comprès dins
    // d'un rang.
    /**
     * 
     * <p>
     * Mètode per llegir un nombre real de doble precisió des de la consola.
     * Si l'usuari introdueix un valor que no és un nombre real, o
     * bé no està dins del rang de valors, es mostrarà un missatge d'error i es
     * tornarà a demanar l'entrada repetidament.
     * </p>
     *
     * 
     * <p>
     * El primer que fa <b>Double.parseDouble()</b> en rebre el text és comprovar si
     * la cadena és nul·la (null). Com que no pot llegir cap caràcter d'un objecte
     * null, llança una excepció de format numèric (<b>NumberFormatException</b>)
     * per indicar que la cadena no és vàlida per ser convertida.
     * </p>
     * 
     * <p>
     * El mètode <b>Double.parseDouble()</b> (ni tampoc <b>Integer.parseInt()</b>)
     * no pot llançar una <b>NullPointerException</b> directament si li passes un
     * valor null. En lloc d'això, si li passes un argument null, el mètode llançarà
     * una <b>NumberFormatException</b>.
     * </p>
     *
     * 
     * @param missatge    El missatge que es mostra per demanar l'entrada.
     * @param valorMinim Un valor que estableix el mínim
     *                    del rang numèric vàlid.
     * @param valorMaxim Un valor que estableix el màxim
     *                    del rang numèric vàlid.
     * @return Un nombre real de doble precisió introduït correctament.
     */
    public static double readReal(String missatge, double valorMinim, double valorMaxim) {
        // El nombre real de doble precisió llegit que es retorna
        double resultat = 0;
        // Canvia de valor a cert quan l'entrada és correcta
        boolean correcta = false;
        do {
            /*
             * Demanar l'entrada adient d'un valor mitjançant un missatge.
             */
            System.out.print(missatge);
            /*
             * Llegir una línia de text introduïda per l'usuari (amb
             * readLine()), eliminar els espais en blanc del principi i del final (amb
             * .trim()), i guardar el resultat net a la variable de text entrada.
             */
            String entrada = readLine().trim();
            try {
                /*
                 * Si la conversió té èxit, retorna directament un valor primitiu de tipus
                 * nombre real de doble precisió.
                 * 
                 * Si Double.parseDouble(entrada) falla, salta directament al catch i mai
                 * executa la línia següent.
                 */
                resultat = Double.parseDouble(entrada);
                // Verifica que sigui un valor dins del rang passat com arguments al mètode
                if (resultat <= valorMaxim && resultat >= valorMinim) {
                    correcta = true;
                } else {
                    System.out.println("\nEntrada errònia: "
                            + "si us plau, introdueix un nombre real de doble precisió entre el "
                            + valorMinim
                            + " i el " + valorMaxim + ".");
                }
            } catch (NumberFormatException e) {
                /*
                 * El bloc catch captura immediatament l'excepció (NumberFormatException) que
                 * llança el mètode Double.parseDouble() quan la cadena de text no té el format
                 * numèric adequat (nombre real sense lletres o símbols). Això evita que el
                 * programa es tanqui de sobte per un error no controlat.
                 */
                // Mostra un missatge clar per pantalla informant a l'usuari de l'equivocació i
                // demanant-li de nou un número com cal.
                System.out.println("\nEntrada errònia: si us plau, introdueix un nombre real de doble precisió.");
                /*
                 * Com que la variable booleana no es passa a true, el bucle
                 * do-while torna a començar i torna a demanar l'entrada a l'usuari.
                 */
            }
        } while (!correcta);
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
