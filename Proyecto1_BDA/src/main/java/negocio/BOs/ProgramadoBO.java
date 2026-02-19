/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.excepciones.NegocioException;
import persistencia.DAOs.IProgramadoDAO;
import persistencia.dominio.Programado;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class ProgramadoBO implements IProgramadoBO {
    
    private final IProgramadoDAO programadoDAO;
    private final Logger LOG = Logger.getLogger(ProgramadoBO.class.getName());
    
    public ProgramadoBO(IProgramadoDAO programado){
        this.programadoDAO = programado;
    }
    
    @Override
    public Programado insertarProgramado(Programado programado) throws NegocioException {
        if(programado == null){
            LOG.log(Level.WARNING, "El pedido programado no puede ser nulo.");
            throw new NegocioException("Pedido programado nulo.");
        }
        
        if(programado.getIdProgramado() < 1){
            LOG.log(Level.WARNING, "El ID no puede ser menor a 1.");
            throw new NegocioException("ID del pedido programado inválido.");
        }
        // lueo valido
        try{
            Programado pro = programadoDAO.consultarProgramado(programado.getIdProgramado());
            if(pro == null){
                LOG.log(Level.SEVERE, "No se pudo dar de alta en la base de datos.");
                throw new NegocioException("Errores al meter el pedido programado a la base.");
            }
            LOG.log(Level.INFO, "Pedido programado registrado con éxto!");
            return pro;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "No se pudo insertar el pedido programado a la base de datos.");
            throw new NegocioException("Problemas para ingresar el pedido programado a la base.");
        }
    }
    
    @Override
    public Programado cancelarProgramado(int numeroProgramado) throws NegocioException {
        return null;
    }
    
    @Override
    public Programado consultarProgramado(int numeroProgramado) throws NegocioException {
        return null;
    }
}
