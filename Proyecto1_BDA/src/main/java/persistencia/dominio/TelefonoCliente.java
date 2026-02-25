/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author Dayanara Peralta G
 */
public class TelefonoCliente {
    private Integer id_telefono;
    private String telefono;
    private String etiqueta;
    private Integer id_cliente;

    /**
     *
     */
    public TelefonoCliente() {
    }

    /**
     *
     * @param id_telefono
     * @param telefono
     * @param etiqueta
     * @param id_cliente
     */
    public TelefonoCliente(Integer id_telefono, String telefono, String etiqueta, Integer id_cliente) {
        this.id_telefono = id_telefono;
        this.telefono = telefono;
        this.etiqueta = etiqueta;
        this.id_cliente = id_cliente;
    }

    /**
     *
     * @param telefono
     * @param etiqueta
     * @param id_cliente
     */
    public TelefonoCliente(String telefono, String etiqueta, Integer id_cliente) {
        this.telefono = telefono;
        this.etiqueta = etiqueta;
        this.id_cliente = id_cliente;
    }

    /**
     *
     * @return
     */
    public Integer getId_telefono() {
        return id_telefono;
    }

    /**
     *
     * @param id_telefono
     */
    public void setId_telefono(Integer id_telefono) {
        this.id_telefono = id_telefono;
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

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "TelefonosClientes{" + "id_telefono=" + id_telefono + ", telefono=" + telefono + ", etiqueta=" + etiqueta + ", id_cliente=" + id_cliente + '}';
    }
    
    
}
