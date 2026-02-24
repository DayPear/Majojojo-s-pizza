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

    public ProgramadoNuevoDTO() {
    }

    public ProgramadoNuevoDTO(int idProgramado, Integer idCupon) {
        this.idProgramado = idProgramado;
        this.idCupon = idCupon;
    }

    public int getIdProgramado() {
        return idProgramado;
    }

    public void setIdProgramado(int idProgramado) {
        this.idProgramado = idProgramado;
    }

    public Integer getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(Integer idCupon) {
        this.idCupon = idCupon;
    }

    @Override
    public String toString() {
        return "ProgramadoNuevoDTO{" + "idProgramado=" + idProgramado + ", idCupon=" + idCupon + '}';
    }
    
}
