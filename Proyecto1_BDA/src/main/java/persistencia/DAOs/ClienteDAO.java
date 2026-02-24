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
    
    @Override
    public Cliente agregarCliente(Cliente cliente) throws PersistenciaException {
        String comandoSQL =     """
                                insert into clientes (
                                    id_cliente, colonia, calle, numero, codigo_postal, fecha_nacimiento
                                ) values (
                                    ?, ?, ?, ?, ?, ?
                                );
                                """;
        try(Connection cone = this.conexion.crearConexion();
                PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getColonia());
            ps.setString(3, cliente.getCalle());
            ps.setString(4, cliente.getNumero());
            ps.setString(5, cliente.getCodigo_postal());
            ps.setDate(6, cliente.getFecha_nacimiento());      
            int filasReg = ps.executeUpdate();
            if (filasReg != 1){
                LOG.warning("No se pudo agregar el cliente.");
                throw new PersistenciaException("No se pudo agregar el cliente");
            }
            return cliente;
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    @Override
    public Cliente validarIdUsuario(int id_cliente) throws PersistenciaException {
        String comandoSQL = """
                            select id_cliente, colonia, calle, numero, codigo_postal, fecha_nacimiento 
                            from clientes where id = ?
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, id_cliente);
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.warning("No se logró asociar el cliente con el usuario de id: "+id_cliente);
                    throw new PersistenciaException("No se pudo obtener el cliente asociado al usuario.");
                }
                Integer idCliente = rs.getInt("id_cliente");
                String colonia = rs.getString("colonia");
                String calle = rs.getString("calle");
                String numero = rs.getString("numero");
                String codigoP = rs.getString("codigo_postal");
                Date fechaN = rs.getDate("fecha_nacimiento");
                Cliente c = new Cliente(id_cliente, colonia, calle, numero, codigoP, fechaN);
                return c;
            }        
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
}
