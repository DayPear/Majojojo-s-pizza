/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.time.LocalDateTime;

/**
 *
 * @author Dayanara Peralta G
 */
public class Pedido {
    private Integer numero_pedido;
    private String notas;
    private float costo;
    private String estado;
    private LocalDateTime hora_preparacion;
    private LocalDateTime hora_recoleccion;
    private LocalDateTime hoara_cambio_estado;
    private Integer id_cliente;

    public Pedido() {
    }

    public Pedido(Integer numero_pedido, String notas, float costo, String estado, LocalDateTime hora_preparacion, LocalDateTime hora_recoleccion, LocalDateTime hoara_cambio_estado, Integer id_cliente) {
        this.numero_pedido = numero_pedido;
        this.notas = notas;
        this.costo = costo;
        this.estado = estado;
        this.hora_preparacion = hora_preparacion;
        this.hora_recoleccion = hora_recoleccion;
        this.hoara_cambio_estado = hoara_cambio_estado;
        this.id_cliente = id_cliente;
    }

    public Pedido(String notas, float costo, String estado, LocalDateTime hora_preparacion, LocalDateTime hora_recoleccion, LocalDateTime hoara_cambio_estado, Integer id_cliente) {
        this.notas = notas;
        this.costo = costo;
        this.estado = estado;
        this.hora_preparacion = hora_preparacion;
        this.hora_recoleccion = hora_recoleccion;
        this.hoara_cambio_estado = hoara_cambio_estado;
        this.id_cliente = id_cliente;
    }

    public Integer getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(Integer numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getHora_preparacion() {
        return hora_preparacion;
    }

    public void setHora_preparacion(LocalDateTime hora_preparacion) {
        this.hora_preparacion = hora_preparacion;
    }

    public LocalDateTime getHora_recoleccion() {
        return hora_recoleccion;
    }

    public void setHora_recoleccion(LocalDateTime hora_recoleccion) {
        this.hora_recoleccion = hora_recoleccion;
    }

    public LocalDateTime getHoara_cambio_estado() {
        return hoara_cambio_estado;
    }

    public void setHoara_cambio_estado(LocalDateTime hoara_cambio_estado) {
        this.hoara_cambio_estado = hoara_cambio_estado;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numero_pedido=" + numero_pedido + ", notas=" + notas + ", costo=" + costo + ", estado=" + estado + ", hora_preparacion=" + hora_preparacion + ", hora_recoleccion=" + hora_recoleccion + ", hoara_cambio_estado=" + hoara_cambio_estado + ", id_cliente=" + id_cliente + '}';
    }
    
}
