/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author maria
 */
public class PedidoExpressNuevoDTO {
    
    private int idPedidoExpress;
    private String folio;
    private String pin;

    /**
     *
     */
    public PedidoExpressNuevoDTO() {
    }

    /**
     *
     * @param idPedidoExpress
     * @param folio
     * @param pin
     */
    public PedidoExpressNuevoDTO(int idPedidoExpress, String folio, String pin) {
        this.idPedidoExpress = idPedidoExpress;
        this.folio = folio;
        this.pin = pin;
    }

    /**
     *
     * @return
     */
    public int getIdPedidoExpress() {
        return idPedidoExpress;
    }

    /**
     *
     * @param idPedidoExpress
     */
    public void setIdPedidoExpress(int idPedidoExpress) {
        this.idPedidoExpress = idPedidoExpress;
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
    
}
