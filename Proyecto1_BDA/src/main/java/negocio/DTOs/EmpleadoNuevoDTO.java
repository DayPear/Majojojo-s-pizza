/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author maria
 */
public class EmpleadoNuevoDTO {
    
    
    private Integer id;

    public EmpleadoNuevoDTO() {
    }

    public EmpleadoNuevoDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmpleadoNuevoDTO{" + "id=" + id + '}';
    }
    
}
