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
import java.time.LocalDateTime;
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

    /**
     *
     * @param pedido
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Pedido agregarPedido(Pedido pedido) throws PersistenciaException {
        String comandoSQL = """
                            insert into pedidos(
                            	notas, costo, id_cliente
                            ) values(
                            	?, ?, ?
                            );
                            """;
        try(Connection cone = this.conexion.crearConexion();
                PreparedStatement ps = cone.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);){
            ps.setString(1, pedido.getNotas());
            ps.setFloat(2, pedido.getCosto());
            ps.setInt(3, pedido.getId_cliente());
            //hacer una tablita de los registros de cambios de estados?
            int filasReg = ps.executeUpdate();
            if (filasReg == 0){
                LOG.warning("No se pudo agregar el pedido ");
                throw new PersistenciaException("No se pudo agregar pedido");
            }            
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(!rs.next()){
                    LOG.warning("Se agregó pero no se pudo obtener el número de pedido");
                    throw new PersistenciaException("Error al obtener el número de pedido");
                }
                pedido.setNumero_pedido(rs.getInt("numero_pedido"));
                return pedido;
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }                    
    }
    
    /**
     *
     * @param numeroPedido
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Pedido consultarPedido(int numeroPedido) throws PersistenciaException {
        String comandoSQL = """
                            select numero_pedido, notas, costo, hora_recoleccion, id_cliente, estado_actual, estado_viejo
                            from pedidos where numero_pedido = ?
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, numeroPedido);
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.log(Level.WARNING, "No se encontró el Pedido con número:" + numeroPedido);
                    throw new PersistenciaException("No existe el pedido con el número proporcionado.");
                }
                return extraerPedido(rs);
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    /**
     *
     * @param numero_pedido
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Pedido cancelarPedido(int numero_pedido) throws PersistenciaException {
        String comandoSQL = """
                            call actualizar_estado_pedido(?, 'Cancelado')
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, numero_pedido);
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.log(Level.WARNING, "No se pudo cancelar el pedido.");
                    throw new PersistenciaException("No se canceló el pedido.");
                }
                LOG.log(Level.INFO, "Se canceló el pedido");
                return extraerPedido(rs);
            }
            // cómo para q regresé un objeto?
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    public Pedido consultarEstado(Pedido pedido) throws PersistenciaException{
        String comandoSQL = """
                            select estado_actual from pedidos where numero_pedido = ?
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, pedido.getNumero_pedido());
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.log(Level.WARNING, "No se pudo consultar el estado del pedido.");
                    throw new PersistenciaException("Error al consultar el estado.");
                }
                pedido.setEstado_actual(rs.getString("estado_actual"));
                return pedido;
            }
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage());
        }
    }

    /**
     *
     * @param pedido
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Pedido actualizarEstadoPedido(Pedido pedido) throws PersistenciaException {
        String comandoSQL = """
                            call actualizar_estado_pedido(?, ?)
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, pedido.getNumero_pedido());
            ps.setString(2, pedido.getEstado_actual());
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.log(Level.WARNING, "No se pudo cambiar el estado del pedido.");
                    throw new PersistenciaException("No se cambió el eatado del pedido.");
                }
                LOG.log(Level.INFO, "Se canceló el pedido");
                return extraerPedido(rs);
            }
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    @Override
    public Pedido entregarPedido(Pedido pedido) throws PersistenciaException {
        String comandoSQL = """
                            call actualizar_estado_pedido(?, 'Entregado')
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, pedido.getNumero_pedido());
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.log(Level.WARNING, "No se pudo entregar el pedido.");
                    throw new PersistenciaException("No se entregó el pedido.");
                }
                LOG.log(Level.INFO, "Se canceló el pedido");
                return extraerPedido(rs);
            }
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    private Pedido extraerPedido(ResultSet rs) throws SQLException {
        Pedido p = new Pedido();
        p.setNumero_pedido(rs.getInt("numero_pedido"));
        p.setNotas(rs.getString("notas"));
        p.setCosto(rs.getFloat("costo"));
        Timestamp hora_recoleccion = rs.getTimestamp("hora_recoleccion");
        if(hora_recoleccion == null){
            p.setHora_recoleccion(null);
        } else {
            LocalDateTime hr = hora_recoleccion.toLocalDateTime();
            String hora = hr.getHour() + ":" + hr.getMinute() + ":" + hr.getSecond();
            p.setHora_recoleccion(hora);
        }
        p.setEstado_actual(rs.getString("estado_actual"));
        p.setEstado_viejo(rs.getString("estado_viejo"));
        p.setId_cliente(rs.getInt("id_cliente"));
        return p;
    }
    
}
    
