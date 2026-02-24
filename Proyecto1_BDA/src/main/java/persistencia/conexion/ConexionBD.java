/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class ConexionBD implements IConexionBD {
    //Crdenciales
    private final String cadenaConexion = "jdbc:mysql://localhost:3306/pizzeria";
    private final String usuario = "root";
    private final String contrasenia = "4$h31ji85";
    private static final Logger LOG = Logger.getLogger(ConexionBD.class.getName());
    
    /**
     *
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Connection crearConexion() throws PersistenciaException{
        try {
            Connection cone = DriverManager.getConnection(cadenaConexion, usuario, contrasenia);
            LOG.info("Conexion exitosa.");
            return cone;
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, "No se puso establecer la conexion.", ex);
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
}
