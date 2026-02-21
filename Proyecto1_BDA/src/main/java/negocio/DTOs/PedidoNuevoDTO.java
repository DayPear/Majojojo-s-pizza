/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

import java.time.LocalDate;

/**
 *
 * @author maria
 */
public class PedidoNuevoDTO {
    
    private String notas;
    private float costo;
    private String hora_recoleccion;
    private Integer id_cliente;
    private String estado_nuevo;
    private String estado_viejo;

    public PedidoNuevoDTO() {
    }

    public PedidoNuevoDTO(String notas, float costo, String hora_recoleccion, Integer id_cliente, String estado_nuevo, String estado_viejo) {
        this.notas = notas;
        this.costo = costo;
        this.hora_recoleccion = hora_recoleccion;
        this.id_cliente = id_cliente;
        this.estado_nuevo = estado_nuevo;
        this.estado_viejo = estado_viejo;
    }
    
    // cuando el pedido es recién creado y aún solo está pendiente ni posee una hora de recolección
    public PedidoNuevoDTO(String notas, float costo, Integer id_cliente, String estado_nuevo) {
        this.notas = notas;
        this.costo = costo;
        this.id_cliente = id_cliente;
        this.estado_nuevo = estado_nuevo;
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

    public String getEstado_nuevo() {
        return estado_nuevo;
    }

    public void setEstado_nuevo(String estado_nuevo) {
        this.estado_nuevo = estado_nuevo;
    }

    public String getEstado_viejo() {
        return estado_viejo;
    }

    public void setEstado_viejo(String estado_viejo) {
        this.estado_viejo = estado_viejo;
    }

    @Override
    public String toString() {
        return "PedidoNuevoDTO{" + "notas=" + notas + ", costo=" + costo + ", hora_recoleccion=" + hora_recoleccion + ", id_cliente=" + id_cliente + ", estado_nuevo=" + estado_nuevo + ", estado_viejo=" + estado_viejo + '}';
    }
    
}
