/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.excepciones.NegocioException;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class PedidoBO implements IPedidoBO {
    
    private final IPedidoDAO pedidoDAO;
    private final Logger LOG = Logger.getLogger(PedidoBO.class.getName());
    
    public PedidoBO(IPedidoBO pedido){
        this.pedidoDAO = pedido;
    }
    
    @Override
    public Pedido insertarPedido(Pedido pedido) throws NegocioException {
        if(pedido == null){
            LOG.log(Level.WARNING, "El pedido no puede ser nulo.");
        }
        // al rato hago validaciones
        try{
            Pedido ped = this.pedidoDAO.agregarPedido(pedido);
            if(ped == null){
                LOG.warning("No se pudo registrar el pedido a la base de datos.");
                throw new NegocioException("No se insertó el pedido a la base.");
            }
            LOG.log(Level.INFO, "Se insertó el pedido a la base.");
            return ped;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Problemas con la insersión del pedido.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
    
    @Override
    public Pedido consultarPedido(int numeroPedido) throws NegocioException {}
    
    @Override
    public Pedido cancelarPedido(int numeroPedido) throws NegocioException {}
}
    
}
