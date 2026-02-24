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

    public PedidoExpress() {
    }

    public PedidoExpress(Integer id_express, String folio, String pin) {
        this.id_express = id_express;
        this.folio = folio;
        this.pin = pin;
    }

    public Integer getId_express() {
        return id_express;
    }

    public void setId_express(Integer id_express) {
        this.id_express = id_express;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "PedidoExpress{" + "id_express=" + id_express + ", folio=" + folio + ", pin=" + pin + '}';
    }
    
    
}
