package com.electro_move_solutions;

import java.util.Scanner;

/**
 * <p>
 * Classe principal de l'aplicació <b>ElectroMove</b>. Conté el mètode
 * d'execució principal (main) que permet realitzar proves interactives per
 * crear i gestionar instàncies de vehicles elèctrics, punts de càrrega i
 * coordenades geogràfiques a través de la consola.
 * </p>
 * 
 * @author Santiago Zuazu Martí
 * @version 3.0
 */
public class ElectroMove {

    /**
     * <p>
     * Constructor de la classe {@link ElectroMove}. No realitza cap acció
     * específica, ja que la classe principal només conté el mètode main() per
     * executar el programa i un parell de mètodes per introduir coordenades o tipus
     * de connector (així no repetim instruccions).
     * </p>
     */
    public ElectroMove() {
    }

    private static final int MAX_V = 8;
    private static final int MAX_PC = 5;

    /**
     * Mètode principal del programa. Executa el programa i realitza proves de les
     * classes {@link PuntCarrega}, {@link Vehicle}, {@link Coordenades} i
     * {@link InputUtils}.
     *
     * @param args els arguments de la línia de comandes (no s'utilitzen en aquest
     *             programa).
     */
    public static void main(String[] args) {

        // Declaració de les variables
        Vehicle[] vehicles = new Vehicle[MAX_V];
        PuntCarrega[] puntsCarrega = new PuntCarrega[MAX_PC];
        double distancia[] = new double[MAX_PC];
        int opcio = 0;

        // Inicialització array de vehicles
        vehicles[0] = new Vehicle("1234ABC", "Tesla", "Model 3", 513,
                new Coordenades(41.3851, 2.1734));
        vehicles[1] = new Vehicle("2345BCD", "Hyundai", "Kona Electric", 484,
                new Coordenades(41.6176, 0.6200));
        vehicles[2] = new Vehicle("3456CDE", "Kia", "EV3", 605,
                new Coordenades(41.9794, 2.8214));
        vehicles[3] = new Vehicle("4567DEF", "Renault", "Megane E-Tech", 468,
                new Coordenades(41.1189, 1.2445));
        vehicles[4] = new Vehicle("5678EFG", "Peugeot", "E-208", 400,
                new Coordenades(41.5463, 2.1086));
        vehicles[5] = new Vehicle("6789FGH", "Hyundai", "IONIQ 5", 540,
                new Coordenades(41.9301, 2.2549));
        vehicles[6] = null;
        vehicles[7] = null;

        // Inicialització array de punts de càrrega
        puntsCarrega[0] = new PuntCarrega("BCN-001", new Coordenades(41.4750, 2.1800),
                150.0, PuntCarrega.TYPE2);
        puntsCarrega[1] = new PuntCarrega("BCN-002", new Coordenades(41.3000, 2.0500),
                150.0, PuntCarrega.CHADEMO);
        puntsCarrega[2] = new PuntCarrega("GIR-001", new Coordenades(41.9900, 2.8000),
                100.0, PuntCarrega.CHADEMO);
        puntsCarrega[3] = new PuntCarrega("TAR-001", new Coordenades(41.1200, 1.2200),
                100.0, PuntCarrega.CCS);
        puntsCarrega[4] = new PuntCarrega("LLE-001", new Coordenades(41.6300, 0.6500),
                50.0, PuntCarrega.TYPE2);

        do {
            // PENDENT: mostrar menú
            // PENDENT: llegir opció
            System.out.println();
            switch (opcio) {
                case 1:
                    // PENDENT: mostrar el llistat de vehicles

                case 2:
                    // PENDENT: mostrar el llistat dels punts de càrrega

                case 3:
                    // PENDENT: gestionar la càrrega del cotxe (TREBALL EN EQUIP)

                case 4:
                    // PENDENT: gestionar l'alta de vehicle

                case 5:
                    // PENDENT: gestionar la finalització del programa
            }
        } while (opcio != 5);
        InputUtils.close();
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
     * @param scan     el scanner per llegir l'entrada.
     * @param missatge el missatge a mostrar per demanar l'entrada.
     * @return el número enter llegit.
     */
    private static int llegirEnter(Scanner scan, String missatge) {
        // El valor enter llegit que es retorna
        int enter = 0;
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
                enter = Integer.parseInt(entrada);
                /*
                 * Si Integer.parseInt(entrada) falla, salta directament al catch i mai executa
                 * la línia següent
                 */
                correcta = true;
            } catch (NumberFormatException e) {
                /*
                 * El bloc catch captura l'excepció (NumberFormatException) que llança el mètode
                 * Integer.parseInt() quan la cadena de text no té el format numèric adequat
                 * (número enter sense lletres o símbols). Això evita que el
                 * programa es tanqui de sobte per un error no controlat.
                 */
                // Mostra un missatge clar per pantalla informant l'usuari de l'equivocació i
                // demanant-li de nou un número correcte.
                System.out.println("Entrada errònia: si us plau, introdueix un número enter.");
                /*
                 * Com que la variable correcta no es posa a true dins del catch, el bucle
                 * do-while torna a començar i li torna a demanar l'entrada a l'usuari.
                 */
            }
        } while (!correcta);
        return enter;
    }
}
