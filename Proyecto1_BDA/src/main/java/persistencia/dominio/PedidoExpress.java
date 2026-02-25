/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author Dayanara Peralta G
 */
public class PedidoExpress {
    private Integer id_express;
    private String folio;
    private String pin;

    /**
     *
     */
    public PedidoExpress() {
    }

    /**
     *
     * @param id_express
     * @param folio
     * @param pin
     */
    public PedidoExpress(Integer id_express, String folio, String pin) {
        this.id_express = id_express;
        this.folio = folio;
        this.pin = pin;
    }

    /**
     *
     * @return
     */
    public Integer getId_express() {
        return id_express;
    }

    /**
     *
     * @param id_express
     */
    public void setId_express(Integer id_express) {
        this.id_express = id_express;
    }

    /**
     *
     * @return
     */
    public String getFolio() {
        return folio;
    }

    /**
     *
     * @param folio
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     *
     * @return
     */
    public String getPin() {
        return pin;
    }

    /**
     *
     * @param pin
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "PedidoExpress{" + "id_express=" + id_express + ", folio=" + folio + ", pin=" + pin + '}';
    }
    
    
}
