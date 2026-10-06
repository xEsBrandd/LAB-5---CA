public class CartaCatedratico extends Carta {

    private String departamento;
    private int llamadasAtencion;
    private int tiempoAtencion;

    public CartaCatedratico(
            int id,
            String nombre,
            int costoEnergia,
            String descripcion,
            String departamento,
            int llamadasAtencion,
            int tiempoAtencion
    ) {
        super(id, nombre, costoEnergia, descripcion);
        this.departamento = departamento;
        this.llamadasAtencion = llamadasAtencion;
        this.tiempoAtencion = tiempoAtencion;
    }

    @Override
    public void jugarCarta(Tablero tablero) {
        if (tablero.consumirEnergia(getCostoEnergia())) {
            tablero.agregarLlamadasAtencion(llamadasAtencion);
            tablero.agregarTiempoAtencion(tiempoAtencion);
        }
    }

    @Override
    public String toString() {
        return "CartaCatedratico{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", costoEnergia=" + getCostoEnergia() +
                ", descripcion='" + getDescripcion() + '\'' +
                ", departamento='" + departamento + '\'' +
                ", llamadasAtencion=" + llamadasAtencion +
                ", tiempoAtencion=" + tiempoAtencion +
                '}';
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getLlamadasAtencion() {
        return llamadasAtencion;
    }

    public void setLlamadasAtencion(int llamadasAtencion) {
        this.llamadasAtencion = llamadasAtencion;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(int tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }
}