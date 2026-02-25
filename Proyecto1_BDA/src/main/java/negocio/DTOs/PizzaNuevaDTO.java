/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author maria
 */
public class PizzaNuevaDTO {
    
    private String nombre;
    private String tamanio;
    private String descripcion;
    private Float precio;
    private String estado;

    /**
     *
     */
    public PizzaNuevaDTO() {
    }

    /**
     *
     * @param nombre
     * @param tamanio
     * @param descripcion
     * @param precio
     * @param estado
     */
    public PizzaNuevaDTO(String nombre, String tamanio, String descripcion, Float precio, String estado) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getTamanio() {
        return tamanio;
    }

    /**
     *
     * @param tamanio
     */
    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "PizzaNuevaDTO{" + "nombre=" + nombre + ", tamanio=" + tamanio + ", descripcion=" + descripcion + ", precio=" + precio + ", estado=" + estado + '}';
    }
    
}
