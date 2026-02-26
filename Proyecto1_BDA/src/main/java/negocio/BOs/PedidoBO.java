/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.PedidoNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAOs.IDetallesPedidoDAO;
import persistencia.DAOs.IEstadoPedidoDAO;
import persistencia.DAOs.IPedidoDAO;
import persistencia.dominio.DetallesPedido;
import persistencia.dominio.EstadoPedido;
import persistencia.dominio.Pedido;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class PedidoBO implements IPedidoBO {
    private IPedidoDAO pedidoDAO;
    private IEstadoPedidoDAO estadoPedidoDAO;
    private IDetallesPedidoDAO detallesPedidoDAO;
    private final Logger LOG = Logger.getLogger(PedidoBO.class.getName());

    /**
     *
     */
    public PedidoBO() {
    }
    
    /**
     *
     * @param pedidoDAO
     */
    public PedidoBO(IPedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }
    
    /**
     *
     * @param pedidoDAO
     * @param estadoPedidoDAO
     * @param detallesPedidoDAO
     */
    public PedidoBO(IPedidoDAO pedidoDAO, IEstadoPedidoDAO estadoPedidoDAO, IDetallesPedidoDAO detallesPedidoDAO) {
        this.pedidoDAO = pedidoDAO;
        this.estadoPedidoDAO = estadoPedidoDAO;
        this.detallesPedidoDAO = detallesPedidoDAO;
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

    /**
     *
     * @param numero_pedido
     * @param nuevoEstado
     * @return
     * @throws NegocioException
     */
    @Override
    public Pedido cambiarEstadoPedido(int numero_pedido, String nuevoEstado) throws NegocioException {
        if (numero_pedido < 1) {
            LOG.log(Level.WARNING, "El numero de pedido no puede ser menor a 1");
            throw new NegocioException("Problema con el nuemro de pedido");
        }
        try {
            Pedido ped = pedidoDAO.consultarPedido(numero_pedido);

            if (ped == null) {
                LOG.log(Level.WARNING, "No se pudo encontrar el pedido");
                throw new NegocioException("Pedido invalido.");
            }
            
            validarEstado(nuevoEstado, "Cambiar estado");
            
            if(!validarCambioEstado(ped.getEstado_actual(), nuevoEstado)){
                LOG.log(Level.WARNING, "No es valido el cambio.");
                throw new NegocioException("Cambio no valido");
            }
            
            String viejo = ped.getEstado_actual();
            
            ped.setEstado_actual(nuevoEstado);
            ped.setEstado_viejo(viejo);
            
            Pedido act = pedidoDAO.actualizarEstadoPedido(ped);
            
            EstadoPedido est = new EstadoPedido();
            est.setEstado(nuevoEstado);
            est.setHora_cambio(LocalDateTime.now());
            est.setNumero_pedido(numero_pedido);
            
            estadoPedidoDAO.insertarEstado(est);
            
            return act;
            
        } catch (PersistenciaException ex) {
            LOG.log(Level.WARNING, "Problemas para cambiar el estado del pedido.");
            throw new NegocioException(ex.getMessage(), ex);
        }
    }
    
    /**
     *
     * @param detalles
     * @return
     * @throws NegocioException
     */
    @Override
    public DetallesPedido actualizarDetallesPedido(DetallesPedido detalles) throws NegocioException{
        if (detalles == null) {
            LOG.log(Level.WARNING, "El numero de pedido no puede ser menor a 1");
            throw new NegocioException("Problema con el nuemro de pedido");
        }
        
        try{
            DetallesPedido dp = detallesPedidoDAO.actualizarDetallesPedido(detalles);
            if(dp == null){
                LOG.warning("No se pudo atualizar el pedido.");
                throw new NegocioException("No se actualizo el pedido.");
            }
            LOG.log(Level.INFO, "Se actualizo el pedido.");
            return dp;
        }catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Problemas con la actualizacion del pedido.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
    
    /**
     *
     * @param estado
     * @return
     * @throws NegocioException
     */
    @Override
    public List<Pedido> consultarEstadoPedido(String estado) throws NegocioException{
        if(estado == null){
            LOG.log(Level.WARNING, "El estado no puede ser null.");
            throw new NegocioException("El estado es inválido.");
        }
        validarEstado(estado, "consultar");
        try{
            return pedidoDAO.consultarEstado(estado);
        }catch(PersistenciaException e){
            throw new NegocioException("Errror al consultar pedidos por estado", e);
        }
    }
    
    private void validarEstado(String nuevoEstado, String opcion) throws NegocioException{
        if (!nuevoEstado.equals("Pendiente") && !nuevoEstado.equals("Listo") &&
        !nuevoEstado.equals("Entregado") && !nuevoEstado.equals("Cancelado") && !nuevoEstado.equals("No Entregado")) {
            throw new NegocioException("No se puede " + opcion + ": El estado no es un estado valido.");
        }
    }
    
    private boolean validarCambioEstado(String estadoActual, String estadoNuevo){
        switch(estadoActual){
            case "Pendiente":
                return estadoNuevo.equals("Listo") || estadoNuevo.equals("Cancelado");
            case "Listo":
                return estadoNuevo.equals("Entregado") || estadoNuevo.equals("Cancelado");
            case "Entregado":
                return false;
            case "Cancelado":
                return false;
            default:
                return false;
        }        
    }
}
    
