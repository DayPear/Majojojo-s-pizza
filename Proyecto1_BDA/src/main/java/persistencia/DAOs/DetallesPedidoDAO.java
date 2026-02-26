/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.conexion.IConexionBD;
import persistencia.dominio.DetallesPedido;
import persistencia.dominio.Pedido;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class DetallesPedidoDAO implements IDetallesPedidoDAO{
    private IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(DetallesPedidoDAO.class.getName());

    /**
     *
     * @param conexion
     */
    public DetallesPedidoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     *
     * @param deta
     * @return
     * @throws PersistenciaException
     */
    @Override
    public DetallesPedido insertarDetallePedido(DetallesPedido deta) throws PersistenciaException {
        String comandoSQL = """
                            insert into detalles_pedido(numero_pedido, id_pizza, cantidad, notas, precio)
                            values (?,?,?,?,?);
                            """;
        try(Connection cone = this.conexion.crearConexion();
                PreparedStatement ps = cone.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);){
            ps.setInt(1, deta.getNumero_pedido());
            ps.setInt(2, deta.getId_pizza());
            ps.setInt(3, deta.getCantidad());
            ps.setString(4, deta.getNotas());
            ps.setFloat(5, deta.getPrecio());
            
            int filasReg = ps.executeUpdate();
            if (filasReg == 0){
                LOG.warning("No se pudo agregar los detalles del pedido ");
                throw new PersistenciaException("No se pudo agregar detalles del pedido");
            }
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                   int id = rs.getInt(1);
                   deta.setId_detalles(id);
                   deta.setSubtotal(deta.getCantidad() * deta.getPrecio());
                }
                return deta;
            }
            
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al insertar detalles pedido: " + ex.getMessage());
        }
    }

    /**
     *
     * @param numero_pedido
     * @return
     * @throws PersistenciaException
     */
    @Override
    public DetallesPedido consultarDetallesPedido(int numero_pedido) throws PersistenciaException {
        String comandoSQL = """
                            select id_detalles, id_pizza, subtotal, cantidad, notas, precio
                            from detalles_pedido
                            where numero_pedido = ?;
                            """;
        try(Connection cone = this.conexion.crearConexion(); 
                PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, numero_pedido);
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.log(Level.WARNING, "No se encontraron los detalles del pedido", numero_pedido);
                    throw new PersistenciaException("No existen los detalles del pedido");
                }
                int id_detalles = rs.getInt("id_detalles");
                int id_pizza = rs.getInt("id_pizza");
                float subtotal = rs.getFloat("subtotal");
                int cantidad = rs.getInt("cantidad");
                String notas = rs.getString("notas");
                float precio = rs.getFloat("precio");
                
                DetallesPedido dp = new DetallesPedido(id_detalles, numero_pedido, id_pizza, subtotal, cantidad, notas, precio);
                
                return dp;
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    /**
     *
     * @param detalle
     * @return
     * @throws PersistenciaException
     */
    @Override
    public DetallesPedido actualizarDetallesPedido(DetallesPedido detalle) throws PersistenciaException {
        String comandoSQL = """
                            update detalles_pedido
                            set cantidad = ?, notas = ?
                            where id_detalles = ?;
                            """;
        try(Connection cone = this.conexion.crearConexion(); 
                PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, detalle.getCantidad());
            ps.setString(2, detalle.getNotas());
            ps.setInt(3, detalle.getId_detalles());
            
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas == 0){
                LOG.log(Level.WARNING, "No se actualizó el usuario.");
                throw new PersistenciaException("Falló al actualizar usuario.");
            }
            return consultarDetallesPedido(detalle.getNumero_pedido());
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    @Override
    public float totalPedido(int numero_pedido) throws PersistenciaException{
        String comandoSQL = """
                            select sum(subtotal) as total
                            from detalles_pedido
                            where numero_pedido = ?;
                            """;
        try(Connection cone = this.conexion.crearConexion(); 
                PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, numero_pedido);
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.log(Level.WARNING, "No se encontró el total del pedido:", numero_pedido);
                    throw new PersistenciaException("No existe el total");
                }
                return rs.getFloat("total");
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
}
