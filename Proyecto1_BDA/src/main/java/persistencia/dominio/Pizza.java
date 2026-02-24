/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author Dayanara Peralta G
 */
public class Pizza {
    private Integer id_pizza;
    private String nombre;
    private String tamanio;
    private String descripcion;
    private float precio;

    public Pizza() {
    }

    public Pizza(Integer id_pizza, String nombre, String tamanio, String descripcion, float precio) {
        this.id_pizza = id_pizza;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Pizza(String nombre, String tamanio, String descripcion, float precio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(Integer id_pizza) {
        this.id_pizza = id_pizza;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pizza{" + "id_pizza=" + id_pizza + ", nombre=" + nombre + ", tamanio=" + tamanio + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
    
}
