package com.electro_move_solutions;

/**
 * <p>
 * Classe que representa un conjunt de coordenades geogràfiques (latitud i
 * longitud) basades en el sistema de posicionament global (GPS).
 * </p>
 * 
 * <p>
 * Permet emmagatzemar, consultar i modificar la posició, així com
 * calcular la distància en quilòmetres respecte a un altre punt mitjançant
 * la fórmula de Haversine.
 * </p>
 * 
 * @author Santiago Zuazu Martí
 * @version 3.0
 */
public class Coordenades {

    // constants
    /** El radi de la Terra en quilòmetres. */
    public static final double R = 6371.0;
    /** La latitud mínima. */
    public static final double MIN_LAT = -90.0;
    /** La latitud màxima. */
    public static final double MAX_LAT = 90.0;
    /** La longitud mínima. */
    public static final double MIN_LONG = -180.0;
    /** La longitud màxima. */
    public static final double MAX_LONG = 180.0;

    // Atributs: representem les coordenades amb la latitud i la longitud (números
    // amb decimals)
    /** La latitud. */
    private double latitud;

    /** La longitud. */
    private double longitud;

    // Constructors
    // Crea un punt a partir de les coordendes GPS
    /**
     * Constructor de la classe Coordenades. construïm un objecte de tipus
     * {@link Coordenades} a partir de la latitud i la longitud (sistema de
     * posicionament global).
     *
     * @param latitud  La latitud.
     * @param longitud La longitud.
     */
    Coordenades(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // getters i setters
    /**
     * Mètode per llegir la latitud.
     *
     * @return Un valor numèric de tipus doble precisió que representa la latitud.
     */
    public double getLatitud() {
        return this.latitud;
    }

    /**
     * Mètode per llegir la longitud.
     *
     * @return Un valor numèric de tipus doble precisió que representa la
     *         longitud.
     */
    public double getLongitud() {
        return this.longitud;
    }

    /**
     * Mètode per assignar un nou valor a la latitud.
     *
     * @param latitud un valor numèric de tipus doble precisió que representa la
     *                latitud.
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    /**
     * Mètode per assignar un nou valor a la longitud.
     *
     * @param longitud un valor numèric de tipus doble precisió que representa la
     *                 longitud.
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    // mètodes instància

    /**
     * Retornar la distància entre dues coordenades en quilòmetres.
     *
     * @param c2 un objecte de tipus Coordenades amb les coordenades del segon punt.
     * @return double un valor numèric de tipus doble precisió amb la distància
     *         entre les dues coordenades en quilòmetres.
     */
    public double distancia(Coordenades c2) {

        // Convertim les latituds i longituds de graus a radians
        double lat1 = Math.toRadians(this.latitud);
        double lon1 = Math.toRadians(this.longitud);
        double lat2 = Math.toRadians(c2.latitud);
        double lon2 = Math.toRadians(c2.longitud);

        // Diferències entre les coordenades
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        // Fórmula de Haversine
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distància en quilòmetres
        return R * c;
    }

    // toString()
    /**
     * <p>
     * Mètode heretat de la classe {@link java.lang.Object} per obtenir una
     * representació de les coordenades en cadena de text. Per exemple:
     * </p>
     * 
     * <p>
     * <b>{2.1686, 41.3874}</b>
     * </p>
     *
     * <p>
     * Genera una cadena de caràcters que mostra informació rellevant sobre
     * l'objecte o la instància de la classe. Sobreescriu el mètode de:
     * {@link java.lang.Object}.
     * </p>
     *
     * @return String una cadena de text amb la representació de les coordenades.
     */
    public String toString() {
        return "{" + this.latitud + ", " + this.longitud + "}";
    }
}
