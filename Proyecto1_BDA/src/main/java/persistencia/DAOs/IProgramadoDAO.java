/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import persistencia.dominio.Programado;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public interface IProgramadoDAO {
    
    Programado agregarProgramado(Programado programado) throws PersistenciaException;
    
    Programado consultarProgramado(int numeroProgramado) throws PersistenciaException;
    
}
