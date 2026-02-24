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
    

    @Override
    public TelefonoCliente agregarTelefonoCliente(TelefonoCliente tel) throws PersistenciaException {
        String comandoSQL = """
                            insert into telefonos_clientes(telefono, etiqueta, id_cliente)
                            values(?,?,?);
                            """;
        try (Connection con = conexion.crearConexion();
         PreparedStatement ps = con.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, tel.getTelefono());
        ps.setString(2, tel.getEtiqueta());
        ps.setInt(3, tel.getId_cliente());

        int filas = ps.executeUpdate();

        if (filas != 1) {
            throw new PersistenciaException("No se pudo insertar el teléfono");
        }

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                tel.setId_telefono(rs.getInt(1));
            } else {
                throw new PersistenciaException("No se pudo obtener el id generado");
            }
        }

        return tel;

    } catch (SQLException e) {
        throw new PersistenciaException("Error al insertar teléfono: " + e.getMessage());
    }
    }
    
}
