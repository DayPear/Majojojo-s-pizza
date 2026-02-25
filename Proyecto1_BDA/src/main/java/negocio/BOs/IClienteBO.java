/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.DTOs.ClienteNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.dominio.Cliente;

/**
 *
 * @author maria
 */
public interface IClienteBO {
    
    /**
     *
     * @param cliente
     * @return
     * @throws NegocioException
     */
    Cliente registrarCliente(ClienteNuevoDTO cliente) throws NegocioException;
    
    /**
     *
     * @param cliente
     * @return
     * @throws NegocioException
     */
    Cliente consultarCliente(ClienteNuevoDTO cliente) throws NegocioException;
    
    /**
     *
     * @param idUsuario
     * @return
     * @throws NegocioException
     */
    Cliente usuarioAsociadoCliente(int idUsuario) throws NegocioException;
}
