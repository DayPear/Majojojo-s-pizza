/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author maria
 */
public class ProgramadoNuevoDTO {
    
    private int idProgramado;
    private Integer idCupon;

    /**
     *
     */
    public ProgramadoNuevoDTO() {
    }

    /**
     *
     * @param idProgramado
     * @param idCupon
     */
    public ProgramadoNuevoDTO(int idProgramado, Integer idCupon) {
        this.idProgramado = idProgramado;
        this.idCupon = idCupon;
    }

    /**
     *
     * @return
     */
    public int getIdProgramado() {
        return idProgramado;
    }

    /**
     *
     * @param idProgramado
     */
    public void setIdProgramado(int idProgramado) {
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
        return "ProgramadoNuevoDTO{" + "idProgramado=" + idProgramado + ", idCupon=" + idCupon + '}';
    }
    
}
