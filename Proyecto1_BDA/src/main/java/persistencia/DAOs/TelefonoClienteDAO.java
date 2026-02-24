/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.conexion.IConexionBD;
import persistencia.dominio.TelefonoCliente;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class TelefonoClienteDAO implements ITelefonoClienteDAO{
    private IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(TelefonoClienteDAO.class.getName());
    
    /**
     *
     * @param tel
     * @return
     * @throws PersistenciaException
     */
    @Override
    public TelefonoCliente agregarTelefonoCliente(TelefonoCliente tel) throws PersistenciaException {
        String comandoSQL = """
                            insert into telefonos_clientes(telefono, etiqueta, id_cliente)
                            values(?,?,?);
                            """;
        try (Connection con = conexion.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(comandoSQL)) {

            ps.setString(1, tel.getTelefono());
            ps.setString(2, tel.getEtiqueta());
            ps.setInt(3, tel.getId_cliente());

            int filas = ps.executeUpdate();

            if (filas != 1) {
                LOG.warning("No se pudo agregar el cliente.");
                throw new PersistenciaException("No se pudo insertar el teléfono");
            }

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    tel.setId_telefono(rs.getInt(1));
                }
                return tel;
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al insertar teléfono: " + e.getMessage());
        }
    }

    @Override
    public TelefonoCliente consultarTelefonoCliente(int id_telefono) throws PersistenciaException {
        String comandoSQL = """
                            select telefono, etiqueta, id_cliente
                            from telefonos_clientes
                            where id_telefono = 2;
                            """;
        
        try (Connection con = conexion.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(comandoSQL)) {
            ps.setInt(1, id_telefono);
            
            try(ResultSet rs = ps.executeQuery()){
                TelefonoCliente tel = new TelefonoCliente();
                tel.setId_telefono(rs.getInt("id_telefono"));
                tel.setTelefono(rs.getString("telefono"));
                tel.setEtiqueta(rs.getString("etiqueta"));
                tel.setId_cliente(rs.getInt("id_cliente"));
                return tel;
            }
            
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
        
    }
    
    

}
