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
    
    /**
     *
     * @param pizza
     * @return
     * @throws NegocioException
     */
    Pizza registrarPizza(PizzaNuevaDTO pizza) throws NegocioException;
    
    /**
     *
     * @param id_pizza
     * @return
     * @throws NegocioException
     */
    Pizza consultarPizza(Integer id_pizza) throws NegocioException;
    
    /**
     *
     * @param id_pizza
     * @return
     * @throws NegocioException
     */
    Pizza cancelarPizza(Integer id_pizza) throws NegocioException;
}
