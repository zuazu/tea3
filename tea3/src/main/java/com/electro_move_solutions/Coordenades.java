package com.electro_move_solutions;

public class Coordenades {

    // constants
    public static final double R = 6371.0;

    public static final double MIN_LAT = -90.0;
    public static final double MAX_LAT = 90.0;
    public static final double MIN_LONG = -180.0;
    public static final double MAX_LONG = 180.0;

    // Atributs

    private double latitud;
    private double longitud;

    // Constructors

    // Crea un punt a partir de les coordendes GPS
    Coordenades(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // getters i setters

    public double getLatitud() {
        return this.latitud;
    }

    public double getLongitud() {
        return this.longitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    // mètodes instància

    // Retorna la distància entre dues coordenades en km.
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

    public String toString() {
        return "{" + this.latitud + ", " + this.longitud + "}";
    }
}
