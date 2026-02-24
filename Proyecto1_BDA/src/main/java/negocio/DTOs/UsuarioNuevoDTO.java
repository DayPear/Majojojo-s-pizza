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

    public UsuarioNuevoDTO() {
    }

    public UsuarioNuevoDTO(String nombres, String apellidoP, String apellidoM, String rol, String correo, String contra) {
        this.nombres = nombres;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.rol = rol;
        this.correo = correo;
        this.contra = contra;
    }

    public UsuarioNuevoDTO(String correo, String contra){
        this.correo = correo;
        this.contra = contra;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public String toString() {
        return "UsuarioNuevoDTO{" + "nombres=" + nombres + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", rol=" + rol + ", correo=" + correo + ", contra=" + contra + '}';
    }
    
}
