/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import java.util.List;
import negocio.DTOs.PedidoNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.dominio.DetallesPedido;
import persistencia.dominio.Pedido;

/**
 *
 * @author maria
 */
public interface IPedidoBO {
    
    /**
     *
     * @param pedido
     * @return
     * @throws NegocioException
     */
    public Pedido insertarPedido(PedidoNuevoDTO pedido) throws NegocioException;
    
    /**
     *
     * @param numeroPedido
     * @return
     * @throws NegocioException
     */
    public Pedido consultarPedido(int numeroPedido) throws NegocioException;
    
    /**
     *
     * @param pedido
     * @return
     * @throws NegocioException
     */
    public Pedido cancelarPedido(PedidoNuevoDTO pedido) throws NegocioException;
    
    /**
     *
     * @param numero_pedido
     * @param nuevoEstado
     * @return
     * @throws negocio.excepciones.NegocioException
     */
    public Pedido cambiarEstadoPedido(int numero_pedido, String nuevoEstado)throws NegocioException ;
    
    /**
     *
     * @param detalles
     * @return
     * @throws NegocioException
     */
    public DetallesPedido actualizarDetallesPedido(DetallesPedido detalles) throws NegocioException;
    
    /**
     *
     * @param estado
     * @return
     * @throws NegocioException
     */
    public List<Pedido> consultarEstadoPedido(String estado) throws NegocioException;
}
