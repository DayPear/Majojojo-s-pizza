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

    public PedidoExpressNuevoDTO() {
    }

    public PedidoExpressNuevoDTO(int idPedidoExpress, String folio, String pin) {
        this.idPedidoExpress = idPedidoExpress;
        this.folio = folio;
        this.pin = pin;
    }

    public int getIdPedidoExpress() {
        return idPedidoExpress;
    }

    public void setIdPedidoExpress(int idPedidoExpress) {
        this.idPedidoExpress = idPedidoExpress;
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
    
}
