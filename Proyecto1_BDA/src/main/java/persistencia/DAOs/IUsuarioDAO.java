/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import persistencia.dominio.Usuario;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public interface IUsuarioDAO {
    
    Usuario consultarUsuario(Integer idUsuario) throws PersistenciaException;
    
    Usuario agregarUsuario(Usuario usuario) throws PersistenciaException;
    
    Usuario validarUsuario(Usuario usuario) throws PersistenciaException;
    
}
