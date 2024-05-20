public class Medicion {
    
    private Long memoria;
    private Long tiempoEjecucion;
    private String texto;

    public Medicion(String texto, Long memoria, Long tiempoEjecucion) {
        this.texto = texto;
        this.memoria = memoria;
        this.tiempoEjecucion = tiempoEjecucion;
    }
    
    

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
    
    

    @Override
    public String toString() {
        return "Medicion: "+texto+" - " + "Consumo de memoria=" + memoria + " Bytes , tiempo de ejecución =" + tiempoEjecucion  + " nanosecs ";
    }
    
    public void print(){
        System.out.println(this.toString());
    }
}
