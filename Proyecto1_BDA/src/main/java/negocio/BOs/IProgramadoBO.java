/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.excepciones.NegocioException;
import persistencia.dominio.Programado;

/**
 *
 * @author maria
 */
public interface IProgramadoBO {
    
    public Programado insertarProgramado(Programado programado) throws NegocioException;
    
    public Programado cancelarProgramado(int numeroProgramado) throws NegocioException;
    
    public Programado consultarProgramado(int numeroProgramado) throws NegocioException;
    
}
