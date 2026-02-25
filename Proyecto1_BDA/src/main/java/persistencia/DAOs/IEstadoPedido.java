/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import persistencia.dominio.EstadoPedido;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public interface IEstadoPedido {

    /**
     *
     * @param estado
     * @return
     * @throws PersistenciaException
     */
    public EstadoPedido insertarEstado(EstadoPedido estado) throws PersistenciaException;
}
