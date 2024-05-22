/**
 * Esta clase representa una medición que incluye memoria, tiempo de ejecución y texto.
 */
public class Medicion {

    // Variable de instancia para la memoria
    private Long memoria;
    // Variable de instancia para el tiempo de ejecución
    private Long tiempoEjecucion;
    // Variable de instancia para el texto
    private String texto;

    /**
     * Constructor para la clase Medicion.
     * @param texto El texto de la medición.
     * @param memoria La memoria de la medición.
     * @param tiempoEjecucion El tiempo de ejecución de la medición.
     */
    public Medicion(String texto, Long memoria, Long tiempoEjecucion) {
        this.texto = texto;
        this.memoria = memoria;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    // Getters y setters para las variables de instancia

    public Long getMemoria() {
        return memoria;
    }

    public void setMemoria(Long memoria) {
        this.memoria = memoria;
    }

    public Long getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(Long tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Sobrescribe el método toString en la clase Object.
     * Este método devuelve una representación en cadena de la medición.
     * @return Una cadena que representa la medición.
     */
    @Override
    public String toString() {
        return "Medicion: "+texto+" - " + "Consumo de memoria=" + memoria + " Bytes , tiempo de ejecución =" + tiempoEjecucion  + " nanosecs ";
    }

    /**
     * Este método imprime la representación en cadena de la medición.
     */
    public void print(){
        System.out.println(this.toString());
    }
}