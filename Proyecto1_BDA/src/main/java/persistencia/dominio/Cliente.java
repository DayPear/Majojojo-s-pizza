/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

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
    private LocalDateTime fecha_nacimiento;

    public Cliente() {
    }

    public Cliente(Integer id_cliente, String colonia, String calle, String numero, String codigo_postal, LocalDateTime fecha_nacimiento) {
        this.id_cliente = id_cliente;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
        this.codigo_postal = codigo_postal;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
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

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public LocalDateTime getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDateTime fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", colonia=" + colonia + ", calle=" + calle + ", numero=" + numero + ", codigo_postal=" + codigo_postal + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }
    
}
