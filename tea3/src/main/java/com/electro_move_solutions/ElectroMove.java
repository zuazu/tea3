package com.electro_move_solutions;

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
     * executar el programa i algun mètode per introduir coordenades o tipus
     * de connector (així no repetim instruccions).
     * </p>
     */
    public ElectroMove() {
    }

    /**
     * Nombre màxim de vehicles permesos al sistema.
     */
    private static final int MAX_V = 8;
    /**
     * Nombre màxim de punts de càrrega permesos al sistema.
     */
    private static final int MAX_PC = 5;

    /**
     * Mètode principal del programa. Al executar-se realitza proves de les
     * classes {@link PuntCarrega}, {@link Vehicle}, {@link Coordenades} i
     * {@link InputUtils}.
     *
     * @param args Els arguments de la línia de comandes (no s'utilitzen en aquest
     *             programa).
     */
    public static void main(String[] args) {

        // Declaració de les variables
        /*
         * Declara i inicialitza un array de vehicles amb una capacitat definida per
         * MAX_V.
         */
        Vehicle[] vehicles = new Vehicle[MAX_V];
        /*
         * Declara i inicialitza un array de punts de càrrega amb una capacitat definida
         * per MAX_PC.
         */
        PuntCarrega[] puntsCarrega = new PuntCarrega[MAX_PC];
        /*
         * Declara i inicialitza un array amb una capacitat definida
         * per MAX_PC. Emmagatzemarà les distàncies entre un vehicle i els punts de
         * càrrega disponibles.
         */
        // double distancia[] = new double[MAX_PC];
        /*
         * La opció del menú principal seleccionada.
         */
        int opcio = 0;

        /*
         * Inicialitzar el contingut del array de vehicles i deixar buides les dues
         * últimes posicions. Aquest bloc fa dues accions alhora: instancia els objectes
         * i els assigna (o carrega) dins de l'array per inicialitzar-ne el contingut.
         */
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

        /*
         * Inicialitzar tot el contingut del array de punts de càrrega. Aquest bloc fa
         * dues accions alhora: instancia els objectes
         * i els assigna (o carrega) dins de l'array per inicialitzar-ne el contingut.
         */
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

        /* Gestionar les diferents opcions del menú principal. */
        do {
            // Mostrar menú
            menuPrincipal();
            // Llegir opció
            opcio = InputUtils.readInt("\n\t\tEscull una opció: ", 1, 5);
            switch (opcio) {
                case 1: {
                    imprimirArray(vehicles);
                    break;
                }
                case 2: {
                    imprimirArray(puntsCarrega);
                    break;
                }
                case 3: {
                    System.out.print("\nIntrodueix matrícula vehicle: ");
                    String matricula = InputUtils.readLine();
                    Vehicle cotxe = compararMatricula(matricula, vehicles);
                    // Punt de càrrega proper i lliure
                    PuntCarrega disponible = null;
                    if (cotxe == null) {
                        System.out.println("\nLa matrícula del vehicle no existeix.");
                    } else if ((disponible = puntCarregaProperLliure(cotxe, puntsCarrega)) == null) {
                        System.out.println("\nNo hi ha cap punt de càrrega lliure.");
                    } else {
                        cotxe.setEstat(3);
                        disponible.setEstat(2);
                        System.out.println(
                                "\nEl vehicle s'està carregant al punt de càrrega " + disponible.getIdentificador()
                                        + ".");
                    }
                    break;
                }
                case 4: {
                    int i = 0;
                    boolean flag = false;
                    while (i < vehicles.length && !flag) {
                        if (vehicles[i] == null) {
                            flag = true;
                        } else {
                            i++;
                        }
                    }
                    if (!flag) {
                        // L'array vehicles està ple
                        System.out.println("\nNo es poden registrar més vehicles.");
                    } else {
                        // Crear un vehicle
                        String matricula = InputUtils.readValidLicensePlate();
                        if ((compararMatricula(matricula, vehicles) == null)) {
                            System.out.print("Marca: ");
                            String marca = InputUtils.readLine();
                            System.out.print("Model: ");
                            String model = InputUtils.readLine();
                            int autonomia = InputUtils.readInt("Autonomia (en km): ");
                            Coordenades ubicacioVehicle = InputUtils.introduirCoordenades();
                            Vehicle cotxe = new Vehicle(matricula, marca, model, autonomia, ubicacioVehicle);
                            vehicles[i] = cotxe;
                            System.out.println("\nEl vehicle ha estat creat.");
                        } else {
                            System.out.println("\nAquesta matrícula ja existeix.");
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("\nSortint del programa...");
                    break;
                }
            }
        } while (opcio != 5);
        InputUtils.close();
    }

    /**
     * Mostrar un menú principal per pantalla.
     */
    private static void menuPrincipal() {
        System.out.println("\n\t\tGESTIÓ MOBILITAT ELÈCTRICA\n\n");
        System.out.println("\t1. Mostrar vehicles");
        System.out.println("\t2. Mostrar punts de càrrega");
        System.out.println("\t3. Posar en càrrega un vehicle");
        System.out.println("\t4. Donar d'alta un vehicle");
        System.out.println("\t5. Sortir");
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

    /**
     * Comparar si són idèntiques la matrícula introduïda per consola amb les que
     * consten emmagatzemades dins d'un array de vehicles.
     * 
     * @param matricula Una matrícula de vehicle.
     * @param vehicles  Un array de objectes de la classe {@link Vehicle}.
     * @return Un objecte Vehicle emmagatzemat dins del array vehicles que té la
     *         mateixa matrícula que la passada com a paràmetre. En el cas de no
     *         trobar la mateixa matrícula, retornar un valor null.
     */
    public static Vehicle compararMatricula(String matricula, Vehicle[] vehicles) {
        Vehicle cotxe = null;
        int posicio = 0;
        boolean trobada = false;
        // Si l'array de vehicles o la String matricula són null el mètode retronar null
        if (vehicles == null || matricula == null) {
            cotxe = null;
        } else {
            // Iterar mentre que qualsevol posició estigui dins dels límits i que no
            // l'haguem trobat encara.
            while (posicio < vehicles.length && !trobada) {
                // Assegurar que la posició del array no estigui lliure i que les matrícules
                // coincideixin
                if (vehicles[posicio] != null && vehicles[posicio].getMatricula().equals(matricula)) {
                    cotxe = vehicles[posicio];
                    trobada = true;
                }
                posicio++;
            }
        }
        return cotxe;
    }

    /**
     * Esbrinar si un punt de càrrega està lliure.
     * 
     * @param puntCarrega El punt de càrrega del que cal esbrinar si està lliure.
     * @return Un valor booleà que determina si el punt de càrrega està lliure o no.
     */
    public static boolean puntCarregaLliure(PuntCarrega puntCarrega) {
        boolean lliure = false;
        if (puntCarrega.getEstat() == 1) {
            lliure = true;
        }
        return lliure;
    }

    /**
     * Cercar un punt de càrrega proper i lliure per un vehicle.
     * 
     * @param cotxe        El vehicle al qual li volem assignar un punt de càrrega
     *                     elèctrica proper.
     * @param puntsCarrega Una sèrie de punts de càrrega elèctrica que poden estar
     *                     avariats, ocupats o disponibles.
     * @return El Punt de càrrega disponible més proper a la ubicació del cotxe.
     */
    public static PuntCarrega puntCarregaProperLliure(Vehicle cotxe, PuntCarrega puntsCarrega[]) {
        Coordenades coordenadesCotxe = cotxe.getUbicacio();
        PuntCarrega puntMesProper = null;
        double minDistancia = Double.MAX_VALUE; // Inicialitzem amb el valor màxim possible
        for (int i = 0; i < puntsCarrega.length; i++) {
            PuntCarrega puntActual = puntsCarrega[i];
            // Comprovem si el punt està lliure
            if (puntCarregaLliure(puntActual)) {
                double distancia = puntActual.getUbicacio().distancia(coordenadesCotxe);
                // Si trobem una distància menor que la mínima actual, l'actualitzem
                if (distancia < minDistancia) {
                    minDistancia = distancia;
                    puntMesProper = puntActual;
                }
            }
        }
        return puntMesProper;
    }
}