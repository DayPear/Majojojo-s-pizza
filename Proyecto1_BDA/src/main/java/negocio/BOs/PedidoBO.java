/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.PedidoNuevoDTO;
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
    
    /**
     *
     * @param pedido
     */
    public PedidoBO(IPedidoDAO pedido){
        this.pedidoDAO = pedido;
    }
    
    /**
     *
     * @param pedido
     * @return
     * @throws NegocioException
     */
    @Override
    public Pedido insertarPedido(PedidoNuevoDTO pedido) throws NegocioException {
        if(pedido == null){
            LOG.log(Level.WARNING, "El pedido no puede ser nulo.");
            throw new NegocioException("El pedido es nulo.");
        }
        if(pedido.getNotas() == null || pedido.getNotas().isEmpty() || pedido.getNotas().isBlank()){
            pedido.setNotas("S/N");
        }
        Pedido ped = new Pedido(pedido.getNotas(), pedido.getCosto(), pedido.getId_cliente());
        try{
            Pedido p = this.pedidoDAO.agregarPedido(ped);
            if(p == null){
                LOG.warning("No se pudo registrar el pedido a la base de datos.");
                throw new NegocioException("No se insertó el pedido a la base.");
            }
            LOG.log(Level.INFO, "Se insertó el pedido a la base.");
            return p;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Problemas con la insersión del pedido.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
    
    /**
     *
     * @param numeroPedido
     * @return
     * @throws NegocioException
     */
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
    
    /**
     *
     * @param pedido
     * @return
     * @throws NegocioException
     */
    @Override
    public Pedido cancelarPedido(PedidoNuevoDTO pedido) throws NegocioException {
        if(pedido.getIdPedido() < 1){
            LOG.log(Level.WARNING, "El número de pedido no puede ser menor a 1.");
            throw new NegocioException("El número de pedido es inválido.");
        }
        // validaciones
        if(pedido.getEstado_nuevo() != "Pendiente" || pedido.getEstado_nuevo() != "Listo"){
            LOG.log(Level.WARNING, "Dado al estado actual del pedido, este ya no puede ser cancelado.");
            throw new NegocioException("No se pudo cancelar el pedido.");
        }
        try{
            Pedido pe = this.pedidoDAO.cancelarPedido(pedido.getIdPedido());
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
    
