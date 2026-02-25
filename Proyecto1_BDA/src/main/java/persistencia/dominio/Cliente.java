/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author Dayanara Peralta G
 */
public class Cliente {
    private Integer id_cliente;
    private String colonia;
    private String calle;
    private String numero;
    private String codigo_postal;
    private Date fecha_nacimiento;

    /**
     *
     */
    public Cliente() {
    }

    /**
     *
     * @param id_cliente
     * @param colonia
     * @param calle
     * @param numero
     * @param codigo_postal
     * @param fecha_nacimiento
     */
    public Cliente(Integer id_cliente, String colonia, String calle, String numero, String codigo_postal, Date fecha_nacimiento) {
        this.id_cliente = id_cliente;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
        this.codigo_postal = codigo_postal;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     *
     * @return
     */
    public Integer getId_cliente() {
        return id_cliente;
    }

    /**
     *
     * @param id_cliente
     */
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     *
     * @return
     */
    public String getColonia() {
        return colonia;
    }

    /**
     *
     * @param colonia
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     *
     * @return
     */
    public String getCalle() {
        return calle;
    }

    /**
     *
     * @param calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     *
     * @return
     */
    public String getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public String getCodigo_postal() {
        return codigo_postal;
    }

    /**
     *
     * @param codigo_postal
     */
    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     *
     * @return
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     *
     * @param fecha_nacimiento
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", colonia=" + colonia + ", calle=" + calle + ", numero=" + numero + ", codigo_postal=" + codigo_postal + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }
    
}
