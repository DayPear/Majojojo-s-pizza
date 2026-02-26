/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import persistencia.dominio.DetallesPedido;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public interface IDetallesPedidoDAO {

    /**
     *
     * @param detalles
     * @return
     * @throws PersistenciaException
     */
    public DetallesPedido insertarDetallePedido(DetallesPedido detalles)throws PersistenciaException;
    
    /**
     *
     * @param id_detalles
     * @return
     * @throws PersistenciaException
     */
    public DetallesPedido consultarDetallesPedido(int id_detalles)throws PersistenciaException;
    
    /**
     *
     * @param detalle
     * @return
     * @throws PersistenciaException
     */
    public DetallesPedido actualizarDetallesPedido(DetallesPedido detalle)throws PersistenciaException;
    
    float totalPedido(int numero_pedido) throws PersistenciaException;
}
