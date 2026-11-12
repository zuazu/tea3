package com.electro_move_solutions;

/**
 * <p>
 * Classe que representa un vehicle elèctric dins del sistema de gestió.
 * Permet emmagatzemar i gestionar la informació bàsica de cada vehicle
 * (matrícula, marca, model, percentatge de bateria, autonomia i estat actual),
 * així com controlar les seves operacions bàsiques d'estat (engegar, aturar i
 * carregar).
 * </p>
 * 
 * @author Santiago Zuazu Martí
 * @version 3.0
 */
public class Vehicle {

    // declaració de les constants
    /**
     * Constants que representen els diferents estats d'un vehicle elèctric.
     * Els valors són: ATURAT = 1, EN_MOVIMENT = 2, EN_CARREGA = 3.
     * Aquestes constants s'utilitzen per indicar l'estat actual del vehicle.
     */
    public static final int ATURAT = 1;
    /**
     * Constants que representen els diferents estats d'un vehicle elèctric.
     * Els valors són: ATURAT = 1, EN_MOVIMENT = 2, EN_CARREGA = 3.
     * Aquestes constants s'utilitzen per indicar l'estat actual del vehicle.
     */
    public static final int EN_MOVIMENT = 2;
    /**
     * Constants que representen els diferents estats d'un vehicle elèctric.
     * Els valors són: ATURAT = 1, EN_MOVIMENT = 2, EN_CARREGA = 3.
     * Aquestes constants s'utilitzen per indicar l'estat actual del vehicle.
     */
    public static final int EN_CARREGA = 3;

    // el valor d'aquest atribut és el mateix per a tots els objectes
    /**
     * Atribut de classe (estàtic) que compta el nombre de vehicles gestionats.
     * Aquest atribut és compartit per totes les instàncies de la classe
     * {@link Vehicle} i s'incrementa cada vegada que es crea un nou vehicle.
     */
    private static int numVehiclesGestionats = 0;

    // atributs
    /** La matrícula del vehicle. */
    private String matricula;
    /** La marca del vehicle. */
    private String marca;
    /** El model del vehicle. */
    private String model;
    /** El percentatge de bateria del vehicle. */
    private int percentatge;
    /** L'autonomia del vehicle. */
    private int autonomia;
    /** L'estat del vehicle. */
    private int estat;
    /** La ubicació del vehicle. */
    private Coordenades ubicacio;

    // Constructors
    /**
     * Constructor de la classe {@link Vehicle}.
     *
     * @param matricula La matrícula del vehicle.
     * @param marca     La marca del vehicle.
     * @param model     El model del vehicle.
     * @param autonomia L'autonomia del vehicle.
     * @param ubicacio  La ubicació del vehicle.
     */
    Vehicle(String matricula, String marca, String model, int autonomia, Coordenades ubicacio) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.percentatge = 100;
        this.autonomia = autonomia;
        this.estat = ATURAT;
        this.ubicacio = ubicacio;
        numVehiclesGestionats++;
    }

    // getters i setters
    /**
     * Mètode per llegir la matrícula del vehicle.
     *
     * @return Una cadena de text amb la matrícula del vehicle.
     */
    public String getMatricula() {
        return this.matricula;
    }

    /**
     * Mètode per llegir la marca del vehicle.
     *
     * @return Una cadena de text amb la marca del vehicle.
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * Mètode per llegir el model del vehicle.
     *
     * @return Una cadena de text amb el model del vehicle.
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Mètode per llegir el percentatge de bateria del vehicle.
     *
     * @return Un enter amb el percentatge de bateria del vehicle.
     */
    public int getPercentatge() {
        return this.percentatge;
    }

    /**
     * Mètode per llegir l'autonomia del vehicle.
     *
     * @return Un enter amb l'autonomia del vehicle.
     */
    public int getAutonomia() {
        return this.autonomia;
    }

    /**
     * Mètode per llegir l'estat del vehicle.
     *
     * @return Un enter amb l'estat del vehicle. Pot estar ATURAT(1),
     *         EN_MOVIMENT(2) o EN_CARREGA(3).
     */
    public int getEstat() {
        return this.estat;
    }

    /**
     * Mètode per llegir la ubicació del vehicle amb coordenades de latitud i
     * longitud.
     * 
     * @return La ubicació del vehicle en una instància de la classe
     *         {@link Coordenades}
     */
    public Coordenades getUbicacio() {
        return this.ubicacio;
    }

    /**
     * Mètode per assignar un nou valor a la matrícula del vehicle.
     *
     * @param matricula Una cadena de text amb la matrícula del vehicle.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Mètode per assignar un nou valor a la marca del vehicle.
     *
     * @param marca Una cadena de text amb la marca del vehicle.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Mètode per assignar un nou valor al model del vehicle.
     *
     * @param model Una cadena de text amb el model del vehicle.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Mètode per assignar un nou valor al percentatge de bateria del vehicle.
     *
     * @param percentatge Un enter amb el percentatge de bateria del vehicle.
     */
    public void setPercentatge(int percentatge) {
        this.percentatge = percentatge;
    }

    /**
     * Mètode per assignar un nou valor a l'autonomia del vehicle.
     *
     * @param autonomia Un enter amb l'autonomia del vehicle.
     */
    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    /**
     * Mètode per assignar un nou valor a l'estat del vehicle.
     * Pot estar ATURAT(1), EN_MOVIMENT(2) o EN_CARREGA(3).
     *
     * @param estat Un enter amb l'estat del vehicle.
     *              Pot estar ATURAT(1), EN_MOVIMENT(2) o EN_CARREGA(3).
     */
    public void setEstat(int estat) {
        this.estat = estat;
    }

    /**
     * Mètode per assignar una nova ubicació del vehicle.
     * 
     * 
     * @param ubicacio Coordenades de latitud i longitud en una instància de
     *                 {@link Coordenades}
     */
    public void setUbicacio(Coordenades ubicacio) {
        this.ubicacio = ubicacio;
    }

    // mètodes instància
    /** Canvia l'estat del vehicle a en moviment */
    public void engegar() {
        this.estat = EN_MOVIMENT;
    }

    /** Canvia l'estat del vehicle a aturat */
    public void aturar() {
        this.estat = ATURAT;
    }

    /** Canvia l'estat del vehicle a en càrrega */
    public void carregar() {
        this.estat = EN_CARREGA;
    }

    /**
     * Mètode per esbrinar la informació del estat del vehicle.
     * Pot estar ATURAT(1), EN_MOVIMENT(2) o EN_CARREGA(3).
     * 
     * @return Una cadena de text amb la informació del estat del vehicle.
     */
    public String informacioEstat() {
        String estat;
        switch (this.estat) {
            case ATURAT:
                estat = "ATURAT";
                break;
            case EN_MOVIMENT:
                estat = "EN_MOVIMENT";
                break;
            default:
                estat = "EN_CARREGA";
        }
        return estat;
    }

    // mètodes estàtics
    /**
     * Mètode per llegir el nombre de vehicles gestionats. Aquest mètode és estàtic,
     * per tant no cal crear un objecte de la classe {@link Vehicle} per poder
     * cridar-lo.
     *
     * @return Un enter amb el nombre de vehicles gestionats.
     */
    public static int getNumVehiclesGestionats() {
        return numVehiclesGestionats;
    }

    // toString()
    /**
     * <p>
     * Mètode heretat de la classe {@link java.lang.Object} per obtenir una
     * representació del vehicle en cadena de text. Per exemple:
     * </p>
     * 
     * <p>
     * <b>{1234ABC, Tesla, Model S, 80%, 400 km, ATURAT, {Longitud: 42.44, Latitud:
     * 2.17}}</b>
     * </p>
     *
     * <p>
     * Genera una cadena de caràcters que mostra informació rellevant sobre
     * l'objecte o la instància de la classe. Sobreescriu el mètode de:
     * {@link java.lang.Object}
     * </p>
     *
     * @return Una cadena de text amb la representació del vehicle.
     */
    @Override
    public String toString() {
        return "{" + this.matricula + ", " + this.marca
                + ", " + this.model + ",  " + this.percentatge
                + "%, " + this.autonomia + " km, " + this.informacioEstat()
                + ", " + this.getUbicacio().toString() + "}";
    }
}
