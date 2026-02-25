/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.DTOs.UsuarioNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.dominio.Usuario;

/**
 *
 * @author maria
 */
public interface IUsuarioBO {
    
    /**
     *
     * @param usuario
     * @return
     * @throws NegocioException
     */
    Usuario registrarUsuario(UsuarioNuevoDTO usuario) throws NegocioException;
    
    /**
     *
     * @param usuario
     * @return
     * @throws NegocioException
     */
    Usuario validarUsuario(UsuarioNuevoDTO usuario) throws NegocioException;
    
    /**
     *
     * @param idUsuario
     * @return
     * @throws NegocioException
     */
    Usuario consultarUsuario(int idUsuario) throws NegocioException;
    
    //boolean usuarioAsociadoEmpleado(int idUsuario) throws NegocioException;
}
