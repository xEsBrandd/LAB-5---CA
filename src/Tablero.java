public class Tablero {

    private int energiaDisponible;
    private int creditosAcumulados;
    private int dificultadActual;
    private int llamadasAtencionAcumuladas;
    private int tiempoAtencionAcumulado;

    public Tablero(int energiaInicial) {
        this.energiaDisponible = energiaInicial;
        this.creditosAcumulados = 0;
        this.dificultadActual = 0;
        this.llamadasAtencionAcumuladas = 0;
        this.tiempoAtencionAcumulado = 0;
    }

    public boolean consumirEnergia(int cantidad) {
        if (this.energiaDisponible >= cantidad) {
            this.energiaDisponible -= cantidad;
            return true;
        }
        return false;
    }

    public void modificarEnergia(int cantidad) {
        this.energiaDisponible += cantidad;
    }

    public void agregarCreditos(int cantidad) {
        this.creditosAcumulados += cantidad;
    }

    public void modificarDificultad(int cantidad) {
        this.dificultadActual += cantidad;
    }

    public void agregarLlamadasAtencion(int cantidad) {
        this.llamadasAtencionAcumuladas += cantidad;
    }

    public void agregarTiempoAtencion(int cantidad) {
        this.tiempoAtencionAcumulado += cantidad;
    }

    @Override
    public String toString() {
        return "=== ESTADO DEL TABLERO ===\n" +
                "Energía Disponible: " + energiaDisponible + "\n" +
                "Créditos Acumulados: " + creditosAcumulados + "\n" +
                "Dificultad Actual: " + dificultadActual + "\n" +
                "Llamadas de Atención: " + llamadasAtencionAcumuladas + "\n" +
                "Tiempo de Atención: " + tiempoAtencionAcumulado + " min";
    }

    // Getters y Setters
    public int getEnergiaDisponible() { return energiaDisponible; }
    public void setEnergiaDisponible(int energiaDisponible) { this.energiaDisponible = energiaDisponible; }
    
    public int getCreditosAcumulados() { return creditosAcumulados; }
    public void setCreditosAcumulados(int creditosAcumulados) { this.creditosAcumulados = creditosAcumulados; }

    public int getDificultadActual() { return dificultadActual; }
    public void setDificultadActual(int dificultadActual) { this.dificultadActual = dificultadActual; }

    public int getLlamadasAtencionAcumuladas() { return llamadasAtencionAcumuladas; }
    public void setLlamadasAtencionAcumuladas(int llamadasAtencionAcumuladas) { this.llamadasAtencionAcumuladas = llamadasAtencionAcumuladas; }

    public int getTiempoAtencionAcumulado() { return tiempoAtencionAcumulado; }
    public void setTiempoAtencionAcumulado(int tiempoAtencionAcumulado) { this.tiempoAtencionAcumulado = tiempoAtencionAcumulado; }
}