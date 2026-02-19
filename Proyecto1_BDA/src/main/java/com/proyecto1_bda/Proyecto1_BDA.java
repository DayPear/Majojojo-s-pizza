/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.proyecto1_bda;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.conexion.ConexionBD;
import persistencia.conexion.IConexionBD;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class Proyecto1_BDA {

    public static void main(String[] args) {
        IConexionBD conexion = new ConexionBD();
        try{
            Connection cone = conexion.crearConexion();
            if(cone != null){
                System.out.println("Conexion exitosa");
            }
        } catch (PersistenciaException ex) {
            System.out.println("No se establecio la conexion");
            Logger.getLogger(Proyecto1_BDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
