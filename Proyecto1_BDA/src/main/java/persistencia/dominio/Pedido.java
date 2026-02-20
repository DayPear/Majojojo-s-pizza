/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.time.LocalDate;

/**
 *
 * @author Dayanara Peralta G
 */
public class Pedido {
    private Integer numero_pedido;
    private String notas;
    private float costo;
    private String estado;
    private LocalDate hora_recoleccion;
    private Integer id_cliente;

    public Pedido() {
    }

    public Pedido(Integer numero_pedido, String notas, float costo, String estado, LocalDate hora_recoleccion, Integer id_cliente) {
        this.numero_pedido = numero_pedido;
        this.notas = notas;
        this.costo = costo;
        this.estado = estado;
        this.hora_recoleccion = hora_recoleccion;
        this.id_cliente = id_cliente;
    }

    public Pedido(String notas, float costo, String estado,  LocalDate hora_recoleccion, Integer id_cliente) {
        this.notas = notas;
        this.costo = costo;
        this.estado = estado;
        this.hora_recoleccion = hora_recoleccion;
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

    public LocalDate getHora_recoleccion() {
        return hora_recoleccion;
    }

    public void setHora_recoleccion(LocalDate hora_recoleccion) {
        this.hora_recoleccion = hora_recoleccion;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numero_pedido=" + numero_pedido + ", notas=" + notas + ", costo=" + costo + ", estado=" + estado + ", hora_recoleccion=" + hora_recoleccion + ", id_cliente=" + id_cliente + '}';
    }
    
}
