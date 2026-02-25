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
    private Float precio;
    private String estado;

    /**
     *
     */
    public Pizza() {
    }

    /**
     *
     * @param id_pizza
     * @param nombre
     * @param tamanio
     * @param descripcion
     * @param precio
     * @param estado
     */
    public Pizza(Integer id_pizza, String nombre, String tamanio, String descripcion, Float precio, String estado) {
        this.id_pizza = id_pizza;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }

    /**
     *
     * @param nombre
     * @param tamanio
     * @param descripcion
     * @param precio
     */
    public Pizza(String nombre, String tamanio, String descripcion, Float precio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.descripcion = descripcion;
        this.precio = precio;
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
        return "Pizza{" + "id_pizza=" + id_pizza + ", nombre=" + nombre + ", tamanio=" + tamanio + ", descripcion=" + descripcion + ", precio=" + precio + ", estado=" + estado + '}';
    }
    
}
