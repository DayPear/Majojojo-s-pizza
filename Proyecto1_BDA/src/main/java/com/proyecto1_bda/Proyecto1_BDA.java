/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.proyecto1_bda;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.DAOs.PedidoDAO;
import persistencia.DAOs.UsuarioDAO;
import persistencia.conexion.ConexionBD;
import persistencia.conexion.IConexionBD;
import persistencia.dominio.Pedido;
import persistencia.dominio.Usuario;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class Proyecto1_BDA {

    public static void main(String[] args) {
        //IConexionBD conexion = new ConexionBD();
        try{
            //Connection cone = conexion.crearConexion();
            IConexionBD cone = new ConexionBD();
            PedidoDAO ped = new PedidoDAO(cone);
            UsuarioDAO usu = new UsuarioDAO(cone);
            //Pedido pe = new Pedido("Maziso de queso", 199.99f, 1);
            /*if(cone != null){
                System.out.println("Conexion exitosa");
            }*/
            Usuario usuario = usu.agregarUsuario(new Usuario("Maria José", "Valdez", "Iglesias", "Empleado", "majof1669@gmail.com", ("pepita2226".hashCode())));
           // Pedido newPedido = ped.agregarPedido(pe);
            //System.out.println("Registron pedido correcto, numero pedido: " + newPedido);
            System.out.println("ID nuevo usuario: " + usuario.getId());
        } catch (PersistenciaException ex) {
            System.out.println("No se estableció la conexion");
            Logger.getLogger(Proyecto1_BDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
