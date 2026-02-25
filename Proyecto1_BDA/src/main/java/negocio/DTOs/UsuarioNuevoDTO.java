/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author maria
 */
public class UsuarioNuevoDTO {
    
    String nombres;
    String apellidoP;
    String apellidoM;
    String rol;
    String correo;
    String contra;

    /**
     *
     */
    public UsuarioNuevoDTO() {
    }

    /**
     *
     * @param nombres
     * @param apellidoP
     * @param apellidoM
     * @param rol
     * @param correo
     * @param contra
     */
    public UsuarioNuevoDTO(String nombres, String apellidoP, String apellidoM, String rol, String correo, String contra) {
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.rol = rol;
        this.correo = correo;
        this.contra = contra;
    }

    public UsuarioNuevoDTO(String nombres, String apellidoP, String apellidoM) {
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }
    
    /**
     *
     * @param correo
     * @param contra
     */
    public UsuarioNuevoDTO(String correo, String contra){
        this.correo = correo;
        this.contra = contra;
    }
    
    /**
     *
     * @return
     */
    public String getNombres() {
        return nombres;
    }

    /**
     *
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     *
     * @return
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     *
     * @param apellidoP
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     *
     * @return
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     *
     * @param apellidoM
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     *
     * @return
     */
    public String getRol() {
        return rol;
    }

    /**
     *
     * @param rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     *
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return
     */
    public String getContra() {
        return contra;
    }

    /**
     *
     * @param contra
     */
    public void setContra(String contra) {
        this.contra = contra;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "UsuarioNuevoDTO{" + "nombres=" + nombres + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", rol=" + rol + ", correo=" + correo + ", contra=" + contra + '}';
    }
    
}
