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
    
    UsuarioNuevoDTO registrarUsuario(UsuarioNuevoDTO usuario) throws NegocioException;
    
    UsuarioNuevoDTO validarUsuario(UsuarioNuevoDTO usuario) throws NegocioException;
    
    UsuarioNuevoDTO consultarUsuario(int idUsuario) throws NegocioException;
}
