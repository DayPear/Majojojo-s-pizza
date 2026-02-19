/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

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
        return null;
    }
    
    @Override
    public Programado consultarProgramado(int numeroProgramado) throws PersistenciaException {
        return null;
    }
}
