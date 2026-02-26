/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.DetallesPedidoNuevoDTO;
import negocio.DTOs.PedidoExpressResumenDTO;
import persistencia.conexion.IConexionBD;
import persistencia.dominio.PedidoExpress;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class PedidoExpressDAO implements IPedidoExpressDAO {

    private IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(PedidoExpressDAO.class.getName());

    /**
     *
     * @param conexion
     */
    public PedidoExpressDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     *
     * @param press
     * @return
     * @throws PersistenciaException
     */
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

    /**
     *
     * @param id_express
     * @return
     * @throws PersistenciaException
     */
    @Override
    public PedidoExpress consultarPedidoExpress(int id_express) throws PersistenciaException {
        String comandoSQL = """
                            select folio, PIN
                            from express
                            where id_express = ?;
                            
                            """;
        try (Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)) {
            ps.setInt(1, id_express);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    LOG.log(Level.WARNING, "No se encontró el Pedido Express con número:" + id_express);
                    throw new PersistenciaException("No existe el pedido con el número proporcionado.");
                }
                return extraerPedido(rs);
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }

    }

    private PedidoExpress extraerPedido(ResultSet rs) throws SQLException {
        PedidoExpress pe = new PedidoExpress();
        pe.setFolio(rs.getString("folio"));
        pe.setPin(rs.getString("PIN"));
        return pe;
    }

    @Override
    public List<PedidoExpressResumenDTO> obtenerPedidosExpress() throws PersistenciaException {
        List<PedidoExpressResumenDTO> lista = new ArrayList<>();
        String sql = "SELECT pi.nombre, pi.tamanio, pe.notas, pe.costo "
                + "FROM pedidos pe "
                + "INNER JOIN express ex ON pe.numero_pedido = ex.id_express "
                + "INNER JOIN detalles_pedido dp ON pe.numero_pedido = dp.id_detalles "
                + "INNER JOIN pizzas pi ON dp.id_pizza = pi.id_pizza";

        try (Connection con = this.conexion.crearConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Creamos el DTO "híbrido" con datos de varias tablas
                PedidoExpressResumenDTO reg = new PedidoExpressResumenDTO();
                reg.setNombre(rs.getString("nombre"));
                reg.setTamanio(rs.getString("tamanio"));
                reg.setNotas(rs.getString("notas"));
                reg.setCosto(rs.getFloat("costo"));

                lista.add(reg);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener el resumen de pedidos", e);
        }
        return lista;
    }

}
