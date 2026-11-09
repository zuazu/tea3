public class PuntCarrega {

    // declaració de les constants

    public static final int TYPE2 = 1;
    public static final int CCS = 2;
    public static final int CHADEMO = 3;

    public static final int DISPONIBLE = 1;
    public static final int OCUPAT = 2;
    public static final int AVARIAT = 3;

    // el valor d'aquest atribut és el mateix per a tots els objectes
    private static int numPuntsCarregaGestionats = 0;

    // atributs
    private String identificador;
    private Coordenades ubicacio;
    private double potencia;
    private int connector;
    private int estat;

    // Constructors

    public PuntCarrega(String identificador, Coordenades ubicacio, double potencia, int connector) {
        this.identificador = identificador;
        this.ubicacio = new Coordenades(ubicacio.getLatitud(), ubicacio.getLongitud());
        this.potencia = potencia;
        this.connector = connector;
        this.estat = DISPONIBLE;
        numPuntsCarregaGestionats++;
    }

    // getters i setters

    public String getIdentificador() {
        return this.identificador;
    }

    public Coordenades getUbicacio() {
        return this.ubicacio;
    }

    public double getPotencia() {
        return this.potencia;
    }

    public int getConnector() {
        return this.connector;
    }

    public int getEstat() {
        return this.estat;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setUbicacio(Coordenades ubicacio) {
        this.ubicacio = ubicacio;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public void setConnector(int connector) {
        this.connector = connector;
    }

    public void setEstat(int estat) {
        this.estat = estat;
    }

    // mètodes instància
    // obté la distància entre dos punts de càrrega
    public double distancia(PuntCarrega pc) {
        return this.ubicacio.distancia(pc.getUbicacio());
    }

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

    public static int getNumPuntsCarregaGestionats() {
        return numPuntsCarregaGestionats;
    }

    // toString()
    @Override
    public String toString() {
        return "{" + this.identificador + ", " + this.ubicacio.toString()
                + ", " + this.potencia + " kW, " + this.informacioConnector()
                + ", " + this.informacioEstat() + "}";
    }

}
