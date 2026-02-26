/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author Dayanara Peralta G
 */
public class DetallesPedido {
    private Integer id_detalles;
    private Integer numero_pedido;
    private Integer id_pizza;
    private float subtotal;
    private Integer cantidad;
    private String notas;
    private float precio;

    /**
     *
     */
    public DetallesPedido() {
    }

    /**
     *
     * @param id_detalles
     * @param numero_pedido
     * @param id_pizza
     * @param subtotal
     * @param cantidad
     * @param notas
     * @param precio
     */
    
    public DetallesPedido(Integer id_detalles,Integer numero_pedido, Integer id_pizza, float subtotal, Integer cantidad, String notas, float precio) {
        this.id_detalles = id_detalles;
        this.numero_pedido = numero_pedido;
        this.id_pizza = id_pizza;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
        this.notas = notas;
        this.precio = precio;
    }

    public DetallesPedido(Integer numero_pedido, Integer id_pizza, Integer cantidad, String notas, float precio) {
        this.numero_pedido = numero_pedido;
        this.id_pizza = id_pizza;
        this.cantidad = cantidad;
        this.notas = notas;
        this.precio = precio;
    }
    
    /**
     *
     * @return
     */
    public Integer getId_detalles() {
        return id_detalles;
    }

    /**
     *
     * @param id_detalles
     */
    public void setId_detalles(Integer id_detalles) {
        this.id_detalles = id_detalles;
    }

    /**
     *
     * @return
     */
    public Integer getNumero_pedido() {
        return numero_pedido;
    }

    /**
     *
     * @param numero_pedido
     */
    public void setNumero_pedido(Integer numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    /**
     *
     * @return
     */
    public Integer getId_pizza() {
        return id_pizza;
    }

    /**
     *
     * @param id_pizza
     */
    public void setId_pizza(Integer id_pizza) {
        this.id_pizza = id_pizza;
    }

    /**
     *
     * @return
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     *
     * @param subtotal
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    /**
     *
     * @return
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     *
     * @param cantidad
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
    public float getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "DetallesPedido{" + "id_detalles=" + id_detalles + ", numero_pedido=" + numero_pedido + ", id_pizza=" + id_pizza + ", subtotal=" + subtotal + ", cantidad=" + cantidad + ", notas=" + notas + ", precio=" + precio + '}';
    }
}
