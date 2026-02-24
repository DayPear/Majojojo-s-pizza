/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import persistencia.dominio.Pizza;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public interface IPizzaDAO {

    /**
     *
     * @param pizza
     * @return
     * @throws PersistenciaException
     */
    public Pizza agregarPizza(Pizza pizza) throws PersistenciaException;
    
    /**
     *
     * @param id_pizza
     * @return
     * @throws PersistenciaException
     */
    public Pizza consultarPizza(int id_pizza) throws PersistenciaException;
    
    
    
}
