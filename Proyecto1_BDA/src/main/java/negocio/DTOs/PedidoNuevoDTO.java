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
    
    private int idPedido;
    private String notas;
    private float costo;
    private String hora_recoleccion;
    private Integer id_cliente;
    private String estado_nuevo;
    private String estado_viejo;

    /**
     *
     */
    public PedidoNuevoDTO() {
    }

    /**
     *
     * @param idPedido
     * @param notas
     * @param costo
     * @param hora_recoleccion
     * @param id_cliente
     * @param estado_nuevo
     * @param estado_viejo
     */
    public PedidoNuevoDTO(int idPedido, String notas, float costo, String hora_recoleccion, Integer id_cliente, String estado_nuevo, String estado_viejo) {
        this.idPedido = idPedido;
        this.notas = notas;
        this.costo = costo;
        this.hora_recoleccion = hora_recoleccion;
        this.id_cliente = id_cliente;
        this.estado_nuevo = estado_nuevo;
        this.estado_viejo = estado_viejo;
    }

    /**
     *
     * @param notas
     * @param costo
     * @param hora_recoleccion
     * @param id_cliente
     * @param estado_nuevo
     * @param estado_viejo
     */
    public PedidoNuevoDTO(String notas, float costo, String hora_recoleccion, Integer id_cliente, String estado_nuevo, String estado_viejo) {
        this.notas = notas;
        this.costo = costo;
        this.hora_recoleccion = hora_recoleccion;
        this.id_cliente = id_cliente;
        this.estado_nuevo = estado_nuevo;
        this.estado_viejo = estado_viejo;
    }
    
    // cuando el pedido es recién creado y aún solo está pendiente ni posee una hora de recolección
    /**
     *
     * @param notas
     * @param costo
     * @param id_cliente
     * @param estado_nuevo
     */
    public PedidoNuevoDTO(String notas, float costo, Integer id_cliente, String estado_nuevo) {
        this.notas = notas;
        this.costo = costo;
        this.id_cliente = id_cliente;
        this.estado_nuevo = estado_nuevo;
    }

    /**
     *
     * @return
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     *
     * @param idPedido
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
    /**
     *
     * @return
     */
    public String getNotas() {
        return notas;
    }

    /**
     *
     * @param notas
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     *
     * @return
     */
    public float getCosto() {
        return costo;
    }

    /**
     *
     * @param costo
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /**
     *
     * @return
     */
    public String getHora_recoleccion() {
        return hora_recoleccion;
    }

    /**
     *
     * @param hora_recoleccion
     */
    public void setHora_recoleccion(String hora_recoleccion) {
        this.hora_recoleccion = hora_recoleccion;
    }

    /**
     *
     * @return
     */
    public Integer getId_cliente() {
        return id_cliente;
    }

    /**
     *
     * @param id_cliente
     */
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     *
     * @return
     */
    public String getEstado_nuevo() {
        return estado_nuevo;
    }

    /**
     *
     * @param estado_nuevo
     */
    public void setEstado_nuevo(String estado_nuevo) {
        this.estado_nuevo = estado_nuevo;
    }

    /**
     *
     * @return
     */
    public String getEstado_viejo() {
        return estado_viejo;
    }

    /**
     *
     * @param estado_viejo
     */
    public void setEstado_viejo(String estado_viejo) {
        this.estado_viejo = estado_viejo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "PedidoNuevoDTO{" + "notas=" + notas + ", costo=" + costo + ", hora_recoleccion=" + hora_recoleccion + ", id_cliente=" + id_cliente + ", estado_nuevo=" + estado_nuevo + ", estado_viejo=" + estado_viejo + '}';
    }
    
}
