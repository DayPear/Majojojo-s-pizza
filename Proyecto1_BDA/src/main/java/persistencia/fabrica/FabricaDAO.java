/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.fabrica;

import persistencia.DAOs.ClienteDAO;
import persistencia.DAOs.IClienteDAO;
import persistencia.DAOs.IPedidoDAO;
import persistencia.DAOs.IProgramadoDAO;
import persistencia.DAOs.IUsuarioDAO;
import persistencia.DAOs.PedidoDAO;
import persistencia.DAOs.ProgramadoDAO;
import persistencia.DAOs.UsuarioDAO;
import persistencia.conexion.ConexionBD;
import persistencia.conexion.IConexionBD;

/**
 *
 * @author maria
 */
public class FabricaDAO {
   
    private static IConexionBD conexion = new ConexionBD();
    
    public static IPedidoDAO obtenerPedidoDAO(){
        IPedidoDAO pedidoDAO = new PedidoDAO(conexion);
        return pedidoDAO;
    }
    
    public static IProgramadoDAO obtenerProgramadoDAO(){
        IProgramadoDAO programadoDAO = new ProgramadoDAO(conexion);
        return programadoDAO;
    }
    
    public static IClienteDAO obtenerClienteDAO(){
        IClienteDAO clienteDAO = new ClienteDAO(conexion);
        return clienteDAO;
    }
    
    public static IUsuarioDAO obtenerUsuarioDAO(){
        IUsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
        return usuarioDAO;
    }
}
