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
import persistencia.dominio.Cliente;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class ClienteDAO implements IClienteDAO{
    private IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    public ClienteDAO(IConexionBD cone){
        this.conexion = cone;
    }

    
    
//en la bd la fecha nacimiento no seria solo date?
    @Override
    public Cliente agregarCliente(Integer id_cliente, String colonia, String calle, String numero, String codigo_postal, LocalDateTime fecha_nacimiento) throws PersistenciaException {
        String comandoSQL =     """
                                insert into clientes (
                                    id_cliente, colonia, calle, numero, codigo_postal, fecha_nacimiento
                                ) values (
                                    ?, ?, ?, ?, ?, ?
                                );
                                """;
        try(Connection cone = this.conexion.crearConexion();
                PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, id_cliente);
            ps.setString(2, colonia);
            ps.setString(3, calle);
            ps.setString(4, numero);
            ps.setString(5, codigo_postal);
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.from(fecha_nacimiento)));
            
            int filasReg = ps.executeUpdate();
            if (filasReg != 1){
                LOG.warning("No se pudo agregar el pedido ");
                throw new PersistenciaException("No se pudo agregar pedido");
            }
            Cliente cli = new Cliente(id_cliente, colonia, calle, numero, codigo_postal, fecha_nacimiento);
            return cli;
            
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
}
