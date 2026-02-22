/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.logging.Logger;
import negocio.DTOs.ClienteNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.conexion.IConexionBD;
import persistencia.dominio.Cliente;

/**
 *
 * @author maria
 */
public class ClienteBO implements IClienteBO {
    
    private IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(ClienteBO.class.getName());
    
    @Override
    public Cliente registrarCliente(ClienteNuevoDTO cliente) throws NegocioException {
        return null;
    }
    
    @Override
    public Cliente consultarCliente(ClienteNuevoDTO cliente) throws NegocioException {
        return null;
    }
}
