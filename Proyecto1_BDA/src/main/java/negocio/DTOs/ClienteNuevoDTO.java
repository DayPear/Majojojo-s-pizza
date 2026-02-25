/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author maria
 */
public class ClienteNuevoDTO {
    
    private Integer id;
    private String colonia;
    private String calle;
    private String numero;
    private String codigoP;
    private String fechaNacimiento;
    private String estado;

    /**
     *
     */
    public ClienteNuevoDTO() {
    }

    public ClienteNuevoDTO(Integer id, String colonia, String calle, String numero, String codigoP, String fechaNacimiento, String estado) {
        this.id = id;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
        this.codigoP = codigoP;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    public ClienteNuevoDTO(Integer id, String colonia, String calle, String numero, String codigoP) {
        this.id = id;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
        this.codigoP = codigoP;
    }
    
    public ClienteNuevoDTO(String colonia, String calle, String numero, String codigoP, String fechaNacimiento, String estado) {
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
        this.codigoP = codigoP;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ClienteNuevoDTO{" + "colonia=" + colonia + ", calle=" + calle + ", numero=" + numero + ", codigoP=" + codigoP + ", fechaNacimiento=" + fechaNacimiento + ", estado=" + estado + '}';
    }
    
}
