/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import persistencia.dominio.TelefonoCliente;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public interface ITelefonoClienteDAO {

    /**
     *
     * @param tel
     * @return
     * @throws PersistenciaException
     */
    public TelefonoCliente agregarTelefonoCliente(TelefonoCliente tel) throws PersistenciaException;
    
    /**
     *
     * @param id_telefono
     * @return
     * @throws PersistenciaException
     */
    public TelefonoCliente consultarTelefonoCliente(int id_telefono) throws PersistenciaException;
}
