/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.UsuarioNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAOs.IUsuarioDAO;
import persistencia.dominio.Usuario;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class UsuarioBO implements IUsuarioBO {
    
    private final IUsuarioDAO usuarioDAO;
    private final Logger LOG = Logger.getLogger(UsuarioBO.class.getName());
    
    public UsuarioBO(IUsuarioDAO usuario){
        this.usuarioDAO = usuario;
    }
    
    @Override
    public UsuarioNuevoDTO registrarUsuario(UsuarioNuevoDTO usuario) throws NegocioException {
        Usuario usu = new Usuario();
        if(usuario.getNombres() == null || usuario.getNombres().isBlank() || usuario.getNombres().isEmpty()){
            LOG.log(Level.WARNING, "Nombre inválido para el registro.");
            throw new NegocioException("Error en el nombre del usuario.");
        } else {
            usu.setNombres(usuario.getNombres());
        }
        if(usuario.getApellidoM() == null || usuario.getApellidoP().isBlank() || usuario.getApellidoP().isEmpty()){
            LOG.log(Level.WARNING, "Apellido Paterno inválido para el registro.");
            throw new NegocioException("Error en el apellido paterno del usuario.");
        } else {
            usu.setApellido_paterno(usuario.getApellidoP());
        }
        if(usuario.getApellidoM() == null || usuario.getApellidoM().isBlank() || usuario.getApellidoM().isEmpty()){
           usu.setApellido_materno("");
        } else {
            usu.setApellido_materno(usuario.getApellidoM());
        }
        if(usuario.getRol() != "Empleado" || usuario.getRol() != "Cliente"){
            LOG.log(Level.WARNING, "Rol no existente en el sistema.");
            throw new NegocioException("Error con el rol del usuario.");
        } else {
            usu.setRol(usuario.getRol());
        }
        if(usuario.getCorreo() == null || usuario.getCorreo().isBlank() || usuario.getCorreo().isEmpty()){
            LOG.log(Level.WARNING, "El Correo no puede estar vacío/ser nulo.");
            throw new NegocioException("Error con el correo del usuario.");
        }
        if(!usuario.getCorreo().matches("[A-Za-z0-9-_.+@A-za-z.]")){
            LOG.log(Level.WARNING, "El correo no corresponde con el formato adecuado.");
            throw new NegocioException("Error con el correo del usuario.");
        } else {
            usu.setCorreo(usuario.getCorreo());
        }
        if(usuario.getContra() == null || usuario.getContra().isBlank() || usuario.getContra().isEmpty()){
            LOG.log(Level.WARNING, "La contraseña no puede estar vacía.");
            throw new NegocioException("Error con la contraseña del usuario.");
        } else {
            usu.setContrasenia(usuario.getContra().hashCode());
        }
        try{
            Usuario u = usuarioDAO.agregarUsuario(usu);
            if(u == null){
                LOG.log(Level.WARNING, "El usuario no se pudo insertar.");
                throw new NegocioException("No se hizo la insersión de usuario.");
            }
            return usuario;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Problemas con la insersión del usuario.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
    
    @Override
    public UsuarioNuevoDTO validarUsuario(UsuarioNuevoDTO usuario) throws NegocioException {
        return null;
    }
    
    @Override
    public UsuarioNuevoDTO consultarUsuario(int idUsuario) throws NegocioException {
        if(idUsuario < 1){
            LOG.log(Level.SEVERE, "El ID del usuario no puede ser 0 o menor.");
            throw new NegocioException("Problemas con el ID del usuario.");
        }
        try{
            Usuario u = usuarioDAO.consultarUsuario(idUsuario);
            if(u == null){
                LOG.log(Level.SEVERE, "Parece ser que el usuario no existe en nuestros registros.");
                throw new NegocioException("No se encontró al usuario");
            }
            // aún no sé q hacer con la contra del usuario para devolver el hash code a un string.
            return new UsuarioNuevoDTO(u.getNombres(), u.getApellido_paterno(), u.getApellido_materno(), u.getRol(), u.getCorreo(), u.getContrasenia().toString());
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Problemas para consultar al usuario.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
}
