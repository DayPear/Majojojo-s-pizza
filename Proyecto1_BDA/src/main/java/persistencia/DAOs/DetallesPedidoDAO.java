/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                            insert into detalles_pedido(numero_pedido, id_pizza, subtotal, cantidad, notas, precio)
                            values (?,?,?,?,?,?);
                            """;
        try(Connection cone = this.conexion.crearConexion();
                PreparedStatement ps = cone.prepareStatement(comandoSQL);){
            ps.setInt(1, deta.getNumero_pedido());
            ps.setInt(2, deta.getId_pizza());
            ps.setFloat(3, deta.getSubtotal());
            ps.setInt(4, deta.getCantidad());
            ps.setString(5, deta.getNotas());
            ps.setFloat(6, deta.getPrecio());
            
            int filasReg = ps.executeUpdate();
            if (filasReg == 0){
                LOG.warning("No se pudo agregar los detalles del pedido ");
                throw new PersistenciaException("No se pudo agregar detalles del pedido");
            }
            return deta;
            
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
                return extraerPedido(rs);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private DetallesPedido extraerPedido(ResultSet rs) throws SQLException {
        DetallesPedido p = new DetallesPedido();
        p.setId_detalles(rs.getInt("id_detalles"));
        p.setNumero_pedido(rs.getInt("numero_pedido"));
        p.setId_pizza(rs.getInt("id_pizza"));
        p.setSubtotal(rs.getFloat("subtotal"));
        p.setCantidad(rs.getInt("cantidad"));
        p.setNotas(rs.getString("notas"));
        p.setPrecio(rs.getFloat("precio"));
        return p;
    }
    
}
