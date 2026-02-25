/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.DTOs.TelefonoClienteNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.dominio.TelefonoCliente;

/**
 *
 * @author Dayanara Peralta G
 */
public interface ITelefonoClientesBO {

    /**
     *
     * @param telefono
     * @return
     * @throws NegocioException
     */
    public TelefonoCliente agregarTelefono(TelefonoClienteNuevoDTO telefono) throws NegocioException;
    
    /**
     *
     * @param id_telefono
     * @return
     * @throws NegocioException
     */
    public TelefonoCliente consultarTelefono(int id_telefono) throws NegocioException;
    
    
}
