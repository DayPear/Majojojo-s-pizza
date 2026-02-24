/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.conexion.IConexionBD;
import persistencia.dominio.PedidoExpress;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class PedidoExpresDAO implements IPedidoExpressDAO{
    private IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(PedidoExpresDAO.class.getName());
    

    public PedidoExpresDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    

    @Override
    public PedidoExpress agregarPedidoExpress(PedidoExpress press) throws PersistenciaException {
        String comandoSQL = """
                           insert into express(
                            id_express, folio, pin
                           )values(
                            ?,?,?
                           );
                           """;
        try (Connection con = conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(comandoSQL)) {

            ps.setInt(1, press.getId_express());
            ps.setString(2, press.getFolio());
            ps.setString(3, press.getPin());

            int filasReg = ps.executeUpdate();
            if (filasReg == 0) {
                LOG.warning("No se pudo agregar el pedido express ");
                throw new PersistenciaException("No se pudo agregar pedido express");
            }
            return press;

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al insertar pedido express: " + ex.getMessage());
        }
    }
}
