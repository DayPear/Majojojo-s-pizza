/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                    LOG.warning("No se logro obtener el tecnico con el id: "+id);
                    throw new PersistenciaException("No se pudo obtener el usuario.");
                }
                Integer idUsuario = rs.getInt("id");
                String nombres = rs.getString("nombres");
                String apellido_paterno = rs.getString("apellido_paterno");
                String apellido_materno = rs.getString("apellido_paterno");
                String rol = rs.getString("rol");
                String correo = rs.getString("correo");
                String contrasenia = rs.getString("contrasenia");
                Usuario usu = new Usuario(id, nombres, apellido_paterno, apellido_materno, rol, correo, contrasenia);
                return usu;
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    @Override
    public Usuario agregarUsuario(Usuario usuario) throws PersistenciaException {
        return null;
    }
    
}
