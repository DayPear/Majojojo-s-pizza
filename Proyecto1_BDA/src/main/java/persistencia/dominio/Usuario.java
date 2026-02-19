/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author Dayanara Peralta G
 */
public class Usuario {
    
    private Integer id;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String rol;
    private String correo;
    private String contrasenia;

    /**
     *
     */
    public Usuario() {
    }

    /**
     *
     * @param id
     * @param nombres
     * @param apellido_paterno
     * @param apellido_materno
     * @param rol
     * @param correo
     * @param contrasenia
     */
    public Usuario(Integer id, String nombres, String apellido_paterno, String apellido_materno, String rol, String correo, String contrasenia) {
        this.id = id;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.rol = rol;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /**
     *
     * @param nombres
     * @param apellido_paterno
     * @param apellido_materno
     * @param rol
     * @param correo
     * @param contrasenia
     */
    public Usuario(String nombres, String apellido_paterno, String apellido_materno, String rol, String correo, String contrasenia) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.rol = rol;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     *
     * @param apellido_paterno
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     *
     * @return
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     *
     * @param apellido_materno
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
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
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     *
     * @param contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombres=" + nombres + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", rol=" + rol + ", correo=" + correo + ", contrasenia=" + contrasenia + '}';
    }

}
