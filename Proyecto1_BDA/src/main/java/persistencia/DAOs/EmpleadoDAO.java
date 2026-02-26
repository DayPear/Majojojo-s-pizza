/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import persistencia.conexion.IConexionBD;
import persistencia.dominio.Empleado;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class EmpleadoDAO implements IEmpleadoDAO {
    
    private IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(EmpleadoDAO.class.getName());
    
    public EmpleadoDAO(IConexionBD cone){
        this.conexion = cone;
    }
    
    @Override
    public Empleado agregarEmpleado(Empleado empleado) throws PersistenciaException {
        String comandoSQL = """
                            insert into empleados(id_empleado) values(?)
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, empleado.getId());
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas == 0){
                LOG.warning("No se pudo agregar al empleado.");
                throw new PersistenciaException("No se pudo agregar al empleado.");
            }
            return empleado;
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Empleado consultarEmpleado(Empleado empleado) throws PersistenciaException {
        String comandoSQL = """
                            select id_empleado from empleados where id_empleado = ?"
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, empleado.getId());
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.warning("No se pudo consultar al empleado.");
                    throw new PersistenciaException("No se pudo consultar al empleado.");
                }
            }
            return empleado;
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public Empleado validarIdUsuario(int id_empleado) throws PersistenciaException {
        String comandoSQL = """
                            select id_empleado
                            from empleados where id_empleado = ?
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, id_empleado);
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.warning("No se logró asociar el empleado con el usuario de id: "+id_empleado);
                    throw new PersistenciaException("No se pudo obtener el empleado asociado al usuario.");
                }
                return new Empleado(rs.getInt("id_empleado"));
            }        
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage());
        }
    }
}
