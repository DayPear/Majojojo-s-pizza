/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.EmpleadoNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAOs.IEmpleadoDAO;
import persistencia.dominio.Empleado;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class EmpleadoBO implements IEmpleadoBO {
    
    private final IEmpleadoDAO empleadoDAO;
    private static final Logger LOG = Logger.getLogger(EmpleadoBO.class.getName());
    
    /**
     *
     * @param empleado
     */
    public EmpleadoBO(IEmpleadoDAO empleado){
        this.empleadoDAO = empleado;
    }
    
    @Override
    public Empleado agregarEmpleado(EmpleadoNuevoDTO empleado) throws NegocioException {
        if(empleado == null){
            LOG.log(Level.WARNING, "El empleado no puede ser nulo/estar vacío.");
            throw new NegocioException("El empleado es null.");
        }
        if(empleado.getId() == null || empleado.getId() < 1){
            LOG.log(Level.WARNING, "El empleado debe tener ID y no puede ser menor a 1.");
            throw new NegocioException("ID de empleado inválido.");
        }
        try{
            Empleado e = empleadoDAO.agregarEmpleado(new Empleado(empleado.getId()));
            return e;
        } catch(PersistenciaException pe){
            throw new NegocioException(pe.getMessage());
        }
    }
    
    @Override
    public Empleado consultarEmpleado(EmpleadoNuevoDTO empleado) throws NegocioException {
        if(empleado == null){
            LOG.log(Level.WARNING, "El empleado no puede ser nulo/estar vacío.");
            throw new NegocioException("El empleado es null.");
        }
        if(empleado.getId() == null || empleado.getId() < 1){
            LOG.log(Level.WARNING, "El empleado debe tener ID y no puede ser menor a 1.");
            throw new NegocioException("ID de empleado inválido.");
        }
        try{
            Empleado e = empleadoDAO.consultarEmpleado(new Empleado(empleado.getId()));
            return e;
        } catch(PersistenciaException pe){
            throw new NegocioException(pe.getMessage());
        }
    }
    
    @Override
    public Empleado validarAsociadoEmpleado(Integer idEmpleado) throws NegocioException {
        if(idEmpleado == null || idEmpleado < 1){
            LOG.log(Level.WARNING, "El ID no puede ser 0 o menor o estar vacío.");
            throw new NegocioException("Problemas con el ID.");
        }
        try{
            Empleado e = empleadoDAO.validarIdUsuario(idEmpleado);
            if(e == null){
                LOG.log(Level.WARNING, "No se pudo encontrar un usuario asociado al empleado.");
                throw new NegocioException("Error en la consulta.");
            }
            return e;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Problemas para consultar al usuario.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
}
