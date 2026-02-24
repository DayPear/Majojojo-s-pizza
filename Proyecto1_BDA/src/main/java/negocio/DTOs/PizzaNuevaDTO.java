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

    public PizzaNuevaDTO() {
    }

    public PizzaNuevaDTO(String nombre, String tamanio, String descripcion, Float precio, String estado) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "PizzaNuevaDTO{" + "nombre=" + nombre + ", tamanio=" + tamanio + ", descripcion=" + descripcion + ", precio=" + precio + ", estado=" + estado + '}';
    }
    
}
