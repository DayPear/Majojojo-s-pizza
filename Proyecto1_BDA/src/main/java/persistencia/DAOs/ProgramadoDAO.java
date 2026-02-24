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
import persistencia.dominio.Programado;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class ProgramadoDAO implements IProgramadoDAO {
    
    private IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(ProgramadoDAO.class.getName());
    
    public ProgramadoDAO(IConexionBD cone){
        this.conexion = cone;
    }
    
    @Override
    public Programado agregarProgramado(Programado programado) throws PersistenciaException {
        String comandoSQL = """
                            insert into programados(id_programado, id_cupon) 
                            values(?, ?)
                            """;
        try(Connection cone = conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, programado.getIdProgramado());
            ps.setInt(2, programado.getIdCupon());
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas == 0){
                LOG.log(Level.WARNING, "No se agregó el pedido programado.");
                throw new PersistenciaException("Error al agregar el pedido programado.");
            }
            return programado;
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    @Override
    public Programado consultarProgramado(int numeroProgramado) throws PersistenciaException {
        return null;
    }
}
