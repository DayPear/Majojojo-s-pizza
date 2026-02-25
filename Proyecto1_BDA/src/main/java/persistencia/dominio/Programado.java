/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author maria
 */
public class Programado {
    
    private Integer idProgramado;
    private Integer idCupon;

    /**
     *
     */
    public Programado() {
    }

    /**
     *
     * @param idProgramado
     * @param idCupon
     */
    public Programado(Integer idProgramado, Integer idCupon) {
        this.idProgramado = idProgramado;
        this.idCupon = idCupon;
    }
    
    /**
     *
     * @param idProgramado
     */
    public Programado(Integer idProgramado) {
        this.idProgramado = idProgramado;
    }

    /**
     *
     * @return
     */
    public Integer getIdProgramado() {
        return idProgramado;
    }

    /**
     *
     * @param idProgramado
     */
    public void setIdProgramado(Integer idProgramado) {
        this.idProgramado = idProgramado;
    }

    /**
     *
     * @return
     */
    public Integer getIdCupon() {
        return idCupon;
    }

    /**
     *
     * @param idCupon
     */
    public void setIdCupon(Integer idCupon) {
        this.idCupon = idCupon;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Programado{" + "idProgramado=" + idProgramado + ", idCupon=" + idCupon + '}';
    }
    
}
