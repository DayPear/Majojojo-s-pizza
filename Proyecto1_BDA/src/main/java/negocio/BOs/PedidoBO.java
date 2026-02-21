/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.excepciones.NegocioException;
import persistencia.DAOs.IPedidoDAO;
import persistencia.dominio.Pedido;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class PedidoBO implements IPedidoBO {
    
    private final IPedidoDAO pedidoDAO;
    private final Logger LOG = Logger.getLogger(PedidoBO.class.getName());
    
    public PedidoBO(IPedidoDAO pedido){
        this.pedidoDAO = pedido;
    }
    
    @Override
    public Pedido insertarPedido(Pedido pedido) throws NegocioException {
        if(pedido == null){
            LOG.log(Level.WARNING, "El pedido no puede ser nulo.");
            throw new NegocioException("El pedido es nulo.");
        }
        if(pedido.getNumero_pedido() != null){
            LOG.log(Level.WARNING, "No se puede registrar un pedido con ID previo.");
            throw new NegocioException("El pedido no se puede registrar con ID.");
        }
        if(pedido.getNotas() == null || pedido.getNotas().isEmpty() || pedido.getNotas().isBlank()){
            pedido.setNotas("S/N");
        }
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
    public Pedido consultarPedido(int numeroPedido) throws NegocioException {
        if(numeroPedido < 1){
            LOG.log(Level.WARNING, "El número pedido no puede ser menor a 1.");
            throw new NegocioException("El número de pedido es inválido.");
        }
        try{
            Pedido ped = this.pedidoDAO.consultarPedido(numeroPedido);
            if(ped == null){
                LOG.warning("No se pudo consultar el pedido de la base de datos.");
                throw new NegocioException("Falló al consultar pedido en la base.");
            }
            LOG.log(Level.INFO, "Pedido encontrado!");
            return ped;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Problemas para acceder a la información del pedido en la base de datos.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
    
    @Override
    public Pedido cancelarPedido(Pedido pedido) throws NegocioException {
        if(pedido.getNumero_pedido() < 1){
            LOG.log(Level.WARNING, "El número de pedido no puede ser menor a 1.");
            throw new NegocioException("El número de pedido es inválido.");
        }
        // validaciones
        if(pedido.getEstado_actual() != "Pendiente" || pedido.getEstado_actual() != "Listo"){
            LOG.log(Level.WARNING, "Dado al estado actual del pedido, este ya no puede ser cancelado.");
            throw new NegocioException("No se pudo cancelar el pedido.");
        }
        try{
            Pedido pe = this.pedidoDAO.cancelarPedido(pedido.getNumero_pedido());
            if(pe == null){     
               LOG.warning("No se pudo cancelar el pedido.");
               throw new NegocioException("Falló al cancelar pedido.");  
            }
            LOG.log(Level.INFO, "Pedido cancelado.");
            return pe;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Problemas para cancelar el pedido.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
}
    
