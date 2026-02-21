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
    private String hora_recoleccion;
    private Integer id_cliente;
    private String estado_actual;
    private String estado_viejo;

    public Pedido() {
    }

    public Pedido(Integer numero_pedido, String notas, float costo, String hora_recoleccion, Integer id_cliente, String estado_actual, String estado_viejo) {
        this.numero_pedido = numero_pedido;
        this.notas = notas;
        this.costo = costo;
        this.hora_recoleccion = hora_recoleccion;
        this.id_cliente = id_cliente;
        this.estado_actual = estado_actual;
        this.estado_viejo = estado_viejo;
    }

    public Pedido(String notas, float costo, Integer id_cliente) {
        this.notas = notas;
        this.costo = costo;
        this.id_cliente = id_cliente;
        this.estado_actual = "Pendiente";
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

    public String getHora_recoleccion() {
        return hora_recoleccion;
    }

    public void setHora_recoleccion(String hora_recoleccion) {
        this.hora_recoleccion = hora_recoleccion;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getEstado_actual() {
        return estado_actual;
    }

    public void setEstado_actual(String estado_nuevo) {
        this.estado_actual = estado_nuevo;
    }

    public String getEstado_viejo() {
        return estado_viejo;
    }

    public void setEstado_viejo(String estado_viejo) {
        this.estado_viejo = estado_viejo;
    }

    @Override
    public String toString() {
        return "Pedido{" + "número_pedido=" + numero_pedido + ", notas=" + notas + ", costo=" + costo + ", hora_recolección=" + hora_recoleccion + ", id_cliente=" + id_cliente + ", estado_nuevo=" + estado_actual + ", estado_viejo=" + estado_viejo + '}';
    }
    
}
