/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author maria
 */
public class DetallesPedidoNuevoDTO {
    
    private Integer id;
    private Integer numero_pedido;
    private Integer id_pizza;
    private Integer cantidad;
    private String notas; 
    private Float precio;
    private Float subototal;

    public DetallesPedidoNuevoDTO() {
    }

    public DetallesPedidoNuevoDTO(Integer id, Integer numero_pedido, Integer id_pizza, Integer cantidad, String notas, Float precio, Float subototal) {
        this.id = id;
        this.numero_pedido = numero_pedido;
        this.id_pizza = id_pizza;
        this.cantidad = cantidad;
        this.notas = notas;
        this.precio = precio;
        this.subototal = subototal;
    }

    public DetallesPedidoNuevoDTO(Integer id, Integer numero_pedido, Integer id_pizza, Integer cantidad, String notas, Float precio) {
        this.id = id;
        this.numero_pedido = numero_pedido;
        this.id_pizza = id_pizza;
        this.cantidad = cantidad;
        this.notas = notas;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(Integer numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public Integer getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(Integer id_pizza) {
        this.id_pizza = id_pizza;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getSubototal() {
        return subototal;
    }

    public void setSubototal(Float subototal) {
        this.subototal = subototal;
    }

    @Override
    public String toString() {
        return "DetallesPedidoDTO{" + "id=" + id + ", numero_pedido=" + numero_pedido + ", id_pizza=" + id_pizza + ", cantidad=" + cantidad + ", notas=" + notas + ", precio=" + precio + ", subototal=" + subototal + '}';
    }
    
}
