/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.conexion.IConexionBD;
import persistencia.dominio.EstadoPedido;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class EstadoPedidoDAO implements IEstadoPedido {
    private IConexionBD cone;
    private static final Logger LOG = Logger.getLogger(EstadoPedidoDAO.class.getName());
    
    /**
     *
     * @param conexion
     */
    public EstadoPedidoDAO(IConexionBD conexion){
        this.cone = conexion;
    }

    /**
     *
     * @param estado
     * @return
     * @throws PersistenciaException
     */
    @Override
    public EstadoPedido insertarEstado(EstadoPedido estado) throws PersistenciaException {
        String comandoSQL = """
                            insert into estados_pedido(estado, hora_cambio, numero_pedido)
                            values(?, ?, ?)
                            """;
        try (Connection con = cone.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(comandoSQL)) {
            ps.setString(1, estado.getEstado());
            ps.setString(2, estado.getHora_cambio());
            ps.setInt(3, estado.getNumero_pedido());
            
            int filasReg = ps.executeUpdate();
            if (filasReg == 0) {
                LOG.warning("No se pudo agregar el estado del pedido");
                throw new PersistenciaException("No se pudo agregar el estado");
            }
            return estado;
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al insertar estado: "+ ex.getMessage());
        }
        
    }
    
}
