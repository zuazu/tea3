package com.electro_move_solutions;

/**
 * <p>
 * Classe que representa un punt de càrrega per a vehicles elèctrics dins del
 * sistema.
 * </p>
 * 
 * <p>
 * Permet emmagatzemar i gestionar la informació essencial de cada punt
 * (identificador, ubicació geogràfica, potència en kW, tipus de connector i
 * estat actual), així com calcular la distància respecte a altres punts de
 * càrrega.
 * </p>
 * 
 * @author Santiago Zuazu Martí
 * @version 3.0
 */
public class PuntCarrega {

    // declaració de les constants
    // Disposem de tres tipus de connector de un punt de càrrega.
    // Pot ser <b>TYPE2</b>, <b>CCS</b> o <b>CHADEMO</b> i els seus valors seran
    // respectivament els números enters 1, 2 i 3.

    /** Constant per a indicar el tipus de connector TYPE2. */
    public static final int TYPE2 = 1;

    /** Constant per a indicar el tipus de connector CCS. */
    public static final int CCS = 2;

    /** Constant per a indicar el tipus de connector CHADEMO. */
    public static final int CHADEMO = 3;

    // Necessitem tres constants per a indicar que un punt de càrrega està
    // disponible, ocupat o avariat. Els seus valors seran respectivament 1, 2 i 3.

    /** Constant per a indicar que un punt de càrrega està disponible. */
    public static final int DISPONIBLE = 1;

    /** Constant per a indicar que un punt de càrrega està ocupat. */
    public static final int OCUPAT = 2;

    /** Constant per a indicar que un punt de càrrega està avariat. */
    public static final int AVARIAT = 3;

    // el valor d'aquest atribut és el mateix per a tots els objectes
    /**
     * Atribut de classe (estàtic) que compta el nombre de punts de càrrega
     * gestionats.
     * Aquest atribut és compartit per totes les instàncies de la classe
     * {@link PuntCarrega} i s'incrementa cada vegada que es crea un nou punt de
     * càrrega.
     */
    private static int numPuntsCarregaGestionats = 0;

    // atributs
    /** L'identificador del punt de càrrega. */
    private String identificador;

    /**
     * La ubicació del punt de càrrega. Aquest atribut de instància (no estàtic) és
     * un objecte de la classe {@link Coordenades}.
     */
    private Coordenades ubicacio;

    /** La potència del punt de càrrega en kilowatts. */
    private double potencia;

    /** El tipus de connector del punt de càrrega. */
    private int connector;

    /** L'estat del punt de càrrega. */
    private int estat;

    // Constructors
    // Es considera que un punt de càrrega està disponible quan es crea.
    /**
     * Constructor de la classe {@link PuntCarrega}.
     *
     * @param identificador El identificador del punt de càrrega.
     * @param ubicacio      La ubicació del punt de càrrega.
     * @param potencia      La potència del punt de càrrega.
     * @param connector     El tipus de connector del punt de càrrega.
     */
    public PuntCarrega(String identificador, Coordenades ubicacio, double potencia, int connector) {
        this.identificador = identificador;
        this.ubicacio = new Coordenades(ubicacio.getLatitud(), ubicacio.getLongitud());
        this.potencia = potencia;
        this.connector = connector;
        this.estat = DISPONIBLE;
        numPuntsCarregaGestionats++;
    }

    // getters i setters
    /**
     * Mètode per llegir el identificador del punt de càrrega.
     *
     * @return String una cadena de text que representa l'identificador del punt de
     *         càrrega.
     */
    public String getIdentificador() {
        return this.identificador;
    }

    /**
     * Mètode per llegir la ubicació del punt de càrrega.
     *
     * @return Coordenades un objecte de tipus {@link Coordenades} amb la ubicació
     *         del punt de càrrega.
     */
    public Coordenades getUbicacio() {
        return this.ubicacio;
    }

    /**
     * Mètode per llegir la potència en kW del punt de càrrega.
     *
     * @return Un valor numèric de tipus doble precisió amb la potència del
     *         punt de càrrega.
     */
    public double getPotencia() {
        return this.potencia;
    }

    /**
     * Mètode per llegir el connector del punt de càrrega.
     *
     * @return Un enter amb el tipus de connector del punt de càrrega. Els
     *         valors possibles són <b>TYPE2</b>(1), <b>CCS</b>(2) o
     *         <b>CHADEMO</b>(3).
     */
    public int getConnector() {
        return this.connector;
    }

    /**
     * Mètode per llegir l'estat del punt de càrrega.
     *
     * @return Un enter amb l'estat del punt de càrrega. Els valors possibles
     *         són DISPONIBLE(1), OCUPAT(2) i AVARIAT(3).
     */
    public int getEstat() {
        return this.estat;
    }

    /**
     * Mètode per assignar un nou valor a l'identificador del punt de càrrega.
     *
     * @param identificador Una cadena de text amb l'identificador del punt de
     *                      càrrega.
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * Mètode per assignar un nou valor a la ubicació.
     *
     * @param ubicacio Un objecte de tipus {@link Coordenades} amb la nova ubicació
     *                 del punt de càrrega.
     */
    public void setUbicacio(Coordenades ubicacio) {
        this.ubicacio = ubicacio;
    }

    /**
     * Mètode per assignar un nou valor en kW a la potència.
     *
     * @param potencia Un valor numèric de tipus doble precisió amb la potència del
     *                 punt de càrrega.
     */
    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    /**
     * Mètode per assignar un nou valor al connector.
     *
     * @param connector Un enter amb el nou tipus de connector del punt de càrrega.
     *                  Els valors possibles són <b>TYPE2</b>(1), <b>CCS</b>(2) o
     *                  <b>CHADEMO</b>(3).
     */
    public void setConnector(int connector) {
        this.connector = connector;
    }

    /**
     * Mètode per assignar un nou valor al estat del punt de càrrega. Els valors
     * possibles són DISPONIBLE(1), OCUPAT(2) i AVARIAT(3).
     *
     * @param estat un enter amb el nou estat del punt de càrrega.
     */
    public void setEstat(int estat) {
        this.estat = estat;
    }

    // mètodes instància
    // obté la distància entre dos punts de càrrega
    /**
     * Obtenir la distància entre dos punts de càrrega.
     *
     * @param pc Un objecte de tipus {@link PuntCarrega} amb el qual es vol calcular
     *           la distància.
     * @return Un valor numèric de tipus doble precisió amb la distància
     *         entre els dos punts de càrrega en km.
     */
    public double distancia(PuntCarrega pc) {
        return this.ubicacio.distancia(pc.getUbicacio());
    }

    /**
     * Disposem de tres tipus de connector de un punt de càrrega.
     * Pot ser <b>TYPE2</b>, <b>CCS</b> o <b>CHADEMO</b> i els seus valors seran
     * respectivament els números enters 1, 2 i 3.
     * 
     * Obtenir una cadena de text amb el nom del connector del punt de càrrega a
     * partir del valor numèric de l'atribut connector.
     * 
     * @param connector Un valor enter representatiu del tipus de connector del punt
     *                  de càrrega.
     * 
     * @return Una cadena de text amb el nom del connector del punt de càrrega.
     */
    public String informacioConnector() {
        String connector;
        switch (this.connector) {
            case TYPE2:
                connector = "TYPE2";
                break;
            case CCS:
                connector = "CCS";
                break;
            default:
                connector = "CHADEMO";
        }
        return connector;
    }

    /**
     * Utilitzar tres constants de tipus numèric enter per a indicar que un punt de
     * càrrega està disponible, ocupat o avariat. Els seus valors seran
     * respectivament els números enters 1, 2 i 3.
     * 
     * Obtenir una cadena de text amb el estat del punt de càrrega a
     * partir del valor numèric de l'atribut estat.
     * 
     * @param estat Un valor enter representatiu del estat del punt
     *              de càrrega.
     * 
     * @return Una cadena de text amb el estat del punt de càrrega.
     */
    public String informacioEstat() {
        String estat;
        switch (this.estat) {
            case DISPONIBLE:
                estat = "DISPONIBLE";
                break;
            case OCUPAT:
                estat = "OCUPAT";
                break;
            default:
                estat = "AVARIAT";
        }
        return estat;
    }

    // mètodes estàtics
    /**
     * Mètode per obtenir el nombre de punts de càrrega creats. Aquest mètode és
     * de classe (estàtic), per tant no cal crear un objecte {@link PuntCarrega} per
     * poder-lo cridar.
     *
     * @return Un enter amb el nombre de punts de càrrega creats.
     */
    public static int getNumPuntsCarregaGestionats() {
        return numPuntsCarregaGestionats;
    }

    // toString()
    /**
     * <p>
     * Mètode heretat de la classe {@link java.lang.Object} per obtenir una
     * representació del punt de càrrega en cadena de text. Per exemple:
     * </p>
     * 
     * <p>
     * <b>{BCN-001, Ubicació: {2.1686, 41.3874}, 128.5 kW, CCS, DISPONIBLE}</b>
     * </p>
     *
     * <p>
     * Genera una cadena de caràcters que mostra informació rellevant sobre
     * l'objecte o la instància de la classe. Sobreescriu el mètode de: de la classe
     * {@link java.lang.Object}.
     *
     * @return Una cadena de text amb la representació del punt de càrrega.
     */
    @Override
    public String toString() {
        return "{" + this.identificador + ", " + this.ubicacio.toString()
                + ", " + this.potencia + " kW, " + this.informacioConnector()
                + ", " + this.informacioEstat() + "}";
    }

}
