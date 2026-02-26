/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import persistencia.dominio.Empleado;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public interface IEmpleadoDAO {
    
    Empleado agregarEmpleado(Empleado empleado) throws PersistenciaException;
    
    Empleado consultarEmpleado(Empleado empleado) throws PersistenciaException;
    
    Empleado validarIdUsuario(int id_empleado) throws PersistenciaException;
}
