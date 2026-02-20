/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.conexion.IConexionBD;
import persistencia.dominio.Pedido;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class PedidoDAO implements IPedidoDAO {
    private IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(PedidoDAO.class.getName());
    
    /**
     *
     * @param cone
     */
    public PedidoDAO (IConexionBD cone){
        this.conexion = cone;
    }
    
    //lo puse asi pq al momento de hacer el pedido no sabes a que hora van a hacer la pizza ni cuando
    //van a cambiar el estado a menos de que har el registro del pedido se tome como cambio de estado
    //y de igual manera lo de la hora recoleccion
    @Override
    public Pedido agregarPedido(Pedido pedido) throws PersistenciaException {
        String comandoSQL = """
                            insert into pedidos(
                            	notas, costo, estado, hora_recoleccion, id_cliente
                            ) values(
                            	?, ?, ?, ?, ?, 
                            );
                            """;
        try(Connection cone = this.conexion.crearConexion();
                PreparedStatement ps = cone.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);){
            ps.setString(1, pedido.getNotas());
            ps.setFloat(2, pedido.getCosto());
            ps.setString(3, pedido.getEstado());
            if(pedido.getHora_recoleccion() != null){
                Date fecha = Date.valueOf(pedido.getHora_recoleccion());
                ps.setDate(4, fecha);
            } else { // por si aún no hay hora de recolección
                ps.setDate(4, null);
            }
            ps.setInt(5, pedido.getId_cliente());
            //hacer una tablita de los registros de cambios de estados?
            int filasReg = ps.executeUpdate();
            if (filasReg != 1){
                LOG.warning("No se pudo agregar el pedido ");
                throw new PersistenciaException("No se pudo agregar pedido");
            }
            
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(!rs.next()){
                    LOG.warning("Se agregó pero no se pudo obtener el número de pedido");
                    throw new PersistenciaException("Error al obtener el número de pedido");
                }
                return pedido;
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }                    
    }
    
    @Override
    public Pedido consultarPedido(int numeroPedido) throws PersistenciaException {
        String comandoSQL = """
                            select numero_pedido, notas, costo, estado, hora_preparacion, hora_recolecion, hora_cambio_estado, id_cliente
                            from pedidos where numero_pedido = ?
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, numeroPedido);
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.log(Level.WARNING, "No se encontró el Pedido con número:" + numeroPedido);
                    throw new PersistenciaException("No existe el pedido con el número proporcionado.");
                }
            }
            
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
        return null;
    }

    @Override
    public Pedido cancelarPedidio(int numeroPedido) throws PersistenciaException {
        String comandoSQL = """
                            update pedidos 
                            set estado = 'Cancelado' where numero_pedido = ?
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, numeroPedido);
            if(ps.executeUpdate() == 0){
                LOG.log(Level.WARNING, "No se canceló el pedido.");
                throw new PersistenciaException("No se pudo cancelar el pedido.");
            }
            
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage());
        }
        return null;
    }

    @Override
    public Pedido actualizarEstadoPedido(int numeroPedido) throws PersistenciaException {
        return null;
    }
    
    private Pedido extraerPedido(ResultSet rs) throws SQLException {

        Pedido p = new Pedido();
        p.setNumero_pedido(rs.getInt("numero_pedido"));
        p.setNotas(rs.getString("notas"));
        p.setCosto(rs.getFloat("costo"));
        p.setEstado(rs.getString("estado"));
        
        rs.getDate("hora_recoleccion");
        Date fecha = rs.getDate("fecha_ingreso");
        p.setHora_recoleccion(fecha != null ? fecha.toLocalDate() : null);

        return p;
    }
   
}
    
