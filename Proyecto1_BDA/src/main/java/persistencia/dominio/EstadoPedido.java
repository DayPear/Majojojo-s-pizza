/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author Dayanara Peralta G
 */
public class EstadoPedido {
    private Integer id_estado_pedido;
    private String estado;
    private String hora_cambio;
    private Integer numero_pedido;

    public EstadoPedido() {
    }

    public EstadoPedido(Integer id_estado_pedido, String estado, String hora_cambio, Integer numero_pedido) {
        this.id_estado_pedido = id_estado_pedido;
        this.estado = estado;
        this.hora_cambio = hora_cambio;
        this.numero_pedido = numero_pedido;
    }

    public EstadoPedido(String estado, String hora_cambio, Integer numero_pedido) {
        this.estado = estado;
        this.hora_cambio = hora_cambio;
        this.numero_pedido = numero_pedido;
    }

    public Integer getId_estado_pedido() {
        return id_estado_pedido;
    }

    public void setId_estado_pedido(Integer id_estado_pedido) {
        this.id_estado_pedido = id_estado_pedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHora_cambio() {
        return hora_cambio;
    }

    public void setHora_cambio(String hora_cambio) {
        this.hora_cambio = hora_cambio;
    }

    public Integer getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(Integer numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    @Override
    public String toString() {
        return "EstadoPedido{" + "id_estado_pedido=" + id_estado_pedido + ", estado=" + estado + ", hora_cambio=" + hora_cambio + ", numero_pedido=" + numero_pedido + '}';
    }
}
