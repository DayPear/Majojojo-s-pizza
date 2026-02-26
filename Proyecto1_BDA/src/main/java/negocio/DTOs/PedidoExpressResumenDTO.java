
package negocio.DTOs;

/**
 *
 * @author piña
 */
public class PedidoExpressResumenDTO {
    
    private String nombre;  // De la tabla pizzas
    private String tamanio; // De la tabla pizzas
    private String notas;   // De la tabla pedidos
    private float costo;    // De la tabla pedidos

    public PedidoExpressResumenDTO() {}

    public PedidoExpressResumenDTO(String nombre, String tamanio, String notas, float costo) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.notas = notas;
        this.costo = costo;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTamanio() { return tamanio; }
    public void setTamanio(String tamanio) { this.tamanio = tamanio; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

    public float getCosto() { return costo; }
    public void setCosto(float costo) { this.costo = costo; }
}
