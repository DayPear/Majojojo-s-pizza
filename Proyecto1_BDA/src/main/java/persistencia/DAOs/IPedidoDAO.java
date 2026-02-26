/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import java.time.LocalDateTime;
import java.util.List;
import persistencia.dominio.Pedido;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public interface IPedidoDAO {
    
    /**
     *
     * @param pedido
     * @return
     * @throws PersistenciaException
     */
    Pedido agregarPedido(Pedido pedido) throws PersistenciaException;
    
    /**
     *
     * @param numeroPedido
     * @return
     * @throws PersistenciaException
     */
    Pedido consultarPedido(int numeroPedido) throws PersistenciaException;
    
    /**
     *
     * @param numero_pedido
     * @return
     * @throws PersistenciaException
     */
    Pedido cancelarPedido(int numero_pedido) throws PersistenciaException;
    
    /**
     *
     * @param pedido
     * @return
     * @throws PersistenciaException
     */
    Pedido actualizarEstadoPedido(Pedido pedido) throws PersistenciaException;
    //public boolean cambiarEstado();
    //public Pedido buscarPedidoPorNumero();
    

    /**
     *
     * @param estado_actual
     * @return
     * @throws PersistenciaException
     */
    public List<Pedido> consultarEstado(String estado_actual) throws PersistenciaException;

    Pedido entregarPedido(Pedido pedido) throws PersistenciaException;

}
