/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author Dayanara Peralta G
 */
public class TelefonoClienteNuevoDTO {
    private String telefono;
    private String etiqueta;
    private Integer id_cliente;

    public TelefonoClienteNuevoDTO() {
    }

    /**
     *
     * @param telefono
     * @param etiqueta
     * @param id_cliente
     */
    public TelefonoClienteNuevoDTO(String telefono, String etiqueta, Integer id_cliente) {
        this.telefono = telefono;
        this.etiqueta = etiqueta;
        this.id_cliente = id_cliente;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     *
     * @param etiqueta
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
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
    
}
