/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import persistencia.dominio.PedidoExpress;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public interface IPedidoExpressDAO {
    
    /**
     *
     * @param press
     * @return
     * @throws PersistenciaException
     */
    public PedidoExpress agregarPedidoExpress(PedidoExpress press) throws PersistenciaException;
    
    /**
     *
     * @param id_express
     * @return
     * @throws PersistenciaException
     */
    public PedidoExpress consultarPedidoExpress(int id_express) throws PersistenciaException;
}
