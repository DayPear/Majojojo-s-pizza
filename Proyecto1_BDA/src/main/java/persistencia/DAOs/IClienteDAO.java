/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import java.time.LocalDateTime;
import persistencia.dominio.Cliente;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public interface IClienteDAO {
    
    Cliente agregarCliente(Cliente cliente)throws PersistenciaException;
    
    /**
     *
     * @param idCliente
     * @return
     * @throws PersistenciaException
     */
    Cliente validarIdUsuario(int idCliente) throws PersistenciaException;
    
    Cliente desactivarCliente(int idCliente) throws PersistenciaException;
    
    Cliente activarCliente(int idCliente) throws PersistenciaException;
}
