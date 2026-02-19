/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.conexion;

import java.sql.Connection;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public interface IConexionBD {

    /**
     *
     * @return
     * @throws PersistenciaException
     */
    public Connection crearConexion()throws PersistenciaException;
}
