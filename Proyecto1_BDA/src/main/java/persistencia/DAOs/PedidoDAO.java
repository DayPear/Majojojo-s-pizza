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
                            	notas, costo, estado, hora_preparacion, hora_recoleccion, hora_cambio_estado, id_cliente
                            ) values(
                            	?, ?, ?, ?, ?, ?, ?
                            );
                            """;
        try(Connection cone = this.conexion.crearConexion();
                PreparedStatement ps = cone.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);){
            ps.setString(1, pedido.getNotas());
            ps.setFloat(2, pedido.getCosto());
            ps.setString(3, pedido.getEstado());
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));//al final lo voy a poner como que se hace ahora aunque no sea verdad pq 
            //no se puede dejar null
            ps.setTimestamp(5, Timestamp.valueOf(pedido.getHora_recoleccion()));
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));//la misma cosa no se deja null
            ps.setInt(7, pedido.getId_cliente());
            
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
        return null;
    }

    @Override
    public Pedido cancelarPedidio(int numeroPedido) throws PersistenciaException {
        return null;
    }

    @Override
    public Pedido actualizarEstadoPedido(int numeroPedido) throws PersistenciaException {
        return null;
    }
   
}
    
