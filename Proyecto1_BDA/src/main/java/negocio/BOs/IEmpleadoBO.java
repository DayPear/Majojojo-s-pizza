/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.DTOs.EmpleadoNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.dominio.Empleado;

/**
 *
 * @author maria
 */
public interface IEmpleadoBO {
     
    Empleado agregarEmpleado(EmpleadoNuevoDTO empleado) throws NegocioException;
    
    Empleado consultarEmpleado(EmpleadoNuevoDTO empleado) throws NegocioException;
    
    Empleado validarAsociadoEmpleado(Integer idEmpleado) throws NegocioException;
}
