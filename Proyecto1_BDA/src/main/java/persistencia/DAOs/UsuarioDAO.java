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
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.conexion.IConexionBD;
import persistencia.dominio.Usuario;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class UsuarioDAO implements IUsuarioDAO{
    private IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class.getName());
    
    /**
     *
     * @param cone
     */
    public UsuarioDAO (IConexionBD cone){
        this.conexion = cone;
    }

    /**
     *
     * @param id
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Usuario consultarUsuario(Integer id) throws PersistenciaException {
        String comandoSQL = """
                            select id_usuario, nombres, apellido_paterno, apellido_materno, rol, correo, contrasenia
                            from usuarios
                            where id_usuario = ?;
                            """;
        try(Connection cone = this.conexion.crearConexion();
                PreparedStatement ps = cone.prepareStatement(comandoSQL);){
            
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.warning("No se logró obtener el usuario con el id: "+id);
                    throw new PersistenciaException("No se pudo obtener el usuario.");
                }
                String nombres = rs.getString("nombres");
                String apellido_paterno = rs.getString("apellido_paterno");
                String apellido_materno = rs.getString("apellido_paterno");
                String rol = rs.getString("rol");
                String correo = rs.getString("correo");
                int contrasenia = rs.getInt("contrasenia");
                Usuario usu = new Usuario(id, nombres, apellido_paterno, apellido_materno, rol, correo, contrasenia);
                return usu;
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    /**
     *
     * @param usuario
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Usuario agregarUsuario(Usuario usuario) throws PersistenciaException {

        String comandoSQL = """
                            insert into usuarios(nombres, apellido_paterno, apellido_materno, rol, correo, contrasenia)
                            values (?, ?, ?, ?, ?, ?);
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellido_paterno());
            ps.setString(3, usuario.getApellido_materno());
            ps.setString(4, usuario.getRol());
            ps.setString(5, usuario.getCorreo());
            ps.setInt(6, usuario.getContrasenia());
            
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas == 0){
                LOG.log(Level.WARNING, "No se pudo agregar el usuario a la base de datos.");
                throw new PersistenciaException("Problemas para la insersión del usuario.");
            }
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                   int id = rs.getInt(1);
                   usuario.setId(id);
                }
                return usuario;
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    /**
     *
     * @param usuario
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Usuario validarUsuario(Usuario usuario) throws PersistenciaException {
        String comandoSQL = """
                            select id_usuario, nombres, apellido_paterno, apellido_materno, rol, correo, contrasenia
                            from usuarios where correo = ? and contrasenia = ?
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setString(1, usuario.getCorreo());
            ps.setInt(2, usuario.getContrasenia());
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.log(Level.WARNING, "No se encontró un usuario con dicha información.");
                    throw new PersistenciaException("No se pudo validar las credenciales.");
                }
                Integer id = rs.getInt("id_usuario");
                String nombres = rs.getString("nombres");
                String apellidoP = rs.getString("apellido_paterno");
                String apellidoM = rs.getString("apellido_materno");
                String rol = rs.getString("rol");
                String correo = rs.getString("correo");
                Integer contra = rs.getInt("contrasenia");
                return new Usuario(id, nombres, apellidoP, apellidoM, rol, correo, contra);
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        } 
    }
    
    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws PersistenciaException {
        String comandoSQL = """
                            update usuarios set nombres = ?, apellido_paterno = ?, apellido_materno = ?
                            where id_usuario = ?
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellido_paterno());
            ps.setString(3, usuario.getApellido_materno());
            ps.setInt(4, usuario.getId());
            
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas == 0){
                LOG.log(Level.WARNING, "No se actualizó el usuario.");
                throw new PersistenciaException("Falló al actualizar usuario.");
            }
            return consultarUsuario(usuario.getId());
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
}
