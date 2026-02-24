/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.DTOs.PizzaNuevaDTO;
import negocio.excepciones.NegocioException;
import persistencia.dominio.Pizza;

/**
 *
 * @author maria
 */
public interface IPizzaBO {
    
    Pizza registrarPizza(PizzaNuevaDTO pizza) throws NegocioException;
    
    Pizza consultarPizza(PizzaNuevaDTO pizza) throws NegocioException;
    
    Pizza cancelarPizza(PizzaNuevaDTO pizza) throws NegocioException;
}
