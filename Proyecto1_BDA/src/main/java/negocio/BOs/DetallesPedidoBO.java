/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.DetallesPedidoNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAOs.IDetallesPedidoDAO;
import persistencia.dominio.DetallesPedido;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class DetallesPedidoBO implements IDetallesPedidoBO {
    
    private final IDetallesPedidoDAO detallesPedidoDAO;
    private static final Logger LOG = Logger.getLogger(DetallesPedidoBO.class.getName());
    
    public DetallesPedidoBO(IDetallesPedidoDAO detalles){
        this.detallesPedidoDAO = detalles;
    }
    
    @Override
    public DetallesPedido agregarDetalles(DetallesPedidoNuevoDTO dpnd) throws NegocioException {
        String notas;
        if(dpnd.getId() != null){
            LOG.log(Level.WARNING, "No puede tener ID previo.");
            throw new NegocioException("Error con el ID");
        }
        if(dpnd.getCantidad() == null || dpnd.getCantidad() == 0){
            LOG.log(Level.WARNING, "Debe tener cantidad.");
            throw new NegocioException("Error con la cantidad");
        }
        if(dpnd.getId_pizza() == null || dpnd.getId_pizza() < 1){
            LOG.log(Level.WARNING, "Debe tener ID pizza.");
            throw new NegocioException("Error con la pizza.");
        }
        if(dpnd.getNumero_pedido() == null || dpnd.getNumero_pedido() < 1){
            LOG.log(Level.WARNING, "Debe tener número de pedido.");
            throw new NegocioException("Error con el número de pedido.");
        }
        if(dpnd.getNotas() == null || dpnd.getNotas().isBlank() || dpnd.getNotas().isEmpty()){
            notas = null;
        } else {
            notas = dpnd.getNotas();
        }
        if(dpnd.getPrecio() == null){
            LOG.log(Level.WARNING, "Debe tener un precio.");
            throw new NegocioException("Error con el precio.");
        }
        try{
            DetallesPedido dp = detallesPedidoDAO.insertarDetallePedido(new DetallesPedido(dpnd.getNumero_pedido(), dpnd.getId_pizza(), dpnd.getCantidad(), notas, dpnd.getCantidad()));
            return dp;
        } catch(PersistenciaException pe){
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
    
    @Override
    public DetallesPedido consultarDetalles(DetallesPedidoNuevoDTO dpnd) throws NegocioException {
        if(dpnd.getNumero_pedido()== null || dpnd.getNumero_pedido() < 1){
            LOG.log(Level.WARNING, "Debe tener número de pedido válido.");
            throw new NegocioException("Error con el número de pedido.");
        }
        try{
            DetallesPedido dp = detallesPedidoDAO.consultarDetallesPedido(dpnd.getNumero_pedido());
            return dp;
        } catch(PersistenciaException pe){
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
    
    @Override
    public DetallesPedido actualizarDetalles(DetallesPedidoNuevoDTO dpnd) throws NegocioException {
        String notas;
        if(dpnd.getId() == null || dpnd.getId() < 1){
            LOG.log(Level.WARNING, "Debe un ID previo válido.");
            throw new NegocioException("Error con el ID");
        }
        if(dpnd.getCantidad() == null || dpnd.getCantidad() == 0){
            LOG.log(Level.WARNING, "Debe tener cantidad.");
            throw new NegocioException("Error con la cantidad");
        }
        if(dpnd.getId_pizza() == null || dpnd.getId_pizza() < 1){
            LOG.log(Level.WARNING, "Debe tener ID pizza.");
            throw new NegocioException("Error con la pizza.");
        }
        if(dpnd.getNumero_pedido() == null || dpnd.getNumero_pedido() < 1){
            LOG.log(Level.WARNING, "Debe tener número de pedido.");
            throw new NegocioException("Error con el número de pedido.");
        }
        if(dpnd.getNotas() == null || dpnd.getNotas().isBlank() || dpnd.getNotas().isEmpty()){
            notas = null;
        } else {
            notas = dpnd.getNotas();
        }
        if(dpnd.getPrecio() == null){
            LOG.log(Level.WARNING, "Debe tener un precio.");
            throw new NegocioException("Error con el precio.");
        }
        try{
            DetallesPedido dp = detallesPedidoDAO.actualizarDetallesPedido(new DetallesPedido(dpnd.getNumero_pedido(), dpnd.getId_pizza(), dpnd.getCantidad(), notas, dpnd.getCantidad()));
            return dp;
        } catch(PersistenciaException pe){
            throw new NegocioException(pe.getMessage(), pe);
        }
    }

    @Override
    public float totalPedido(DetallesPedidoNuevoDTO dpnd) throws NegocioException {
        if(dpnd.getNumero_pedido()== null || dpnd.getNumero_pedido() < 1){
            LOG.log(Level.WARNING, "Debe tener número de pedido válido.");
            throw new NegocioException("Error con el número de pedido.");
        }
        try{
            Float total = detallesPedidoDAO.totalPedido(dpnd.getNumero_pedido());
            return total;
        } catch(PersistenciaException pe){
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
}
