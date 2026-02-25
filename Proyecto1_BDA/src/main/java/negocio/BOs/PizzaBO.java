/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.PizzaNuevaDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAOs.IPizzaDAO;
import persistencia.dominio.Pizza;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class PizzaBO implements IPizzaBO {
    
    private final IPizzaDAO pizzaDAO;
    private static final Logger LOG = Logger.getLogger(ClienteBO.class.getName());
    
    /**
     *
     * @param pizza
     */
    public PizzaBO(IPizzaDAO pizza){
        this.pizzaDAO = pizza;
    }
    
    /**
     *
     * @param pizza
     * @return
     * @throws NegocioException
     */
    @Override
    public Pizza registrarPizza(PizzaNuevaDTO pizza) throws NegocioException {
        Pizza pza = new Pizza();
        if(pizza == null){
            LOG.log(Level.SEVERE, "No puede ser vacía la pizza.");
            throw new NegocioException("Error con la pizza, es nula.");
        }
        if(pizza.getNombre() == null || pizza.getNombre().isBlank() || pizza.getNombre().isEmpty()){
            LOG.log(Level.SEVERE, "Error en el nombre de la pizza.");
            throw new NegocioException("La pizza debe contener un nombre.");
        }
        if(pizza.getNombre().length() > 200){
            LOG.log(Level.SEVERE, "Error en el nombre de la pizza.");
            throw new NegocioException("El nombre de la pizza no puede pasar de 200 caractéres.");
        } else {
            pza.setNombre(pizza.getNombre());
        }
        if(pizza.getTamanio() == null || pizza.getTamanio().isBlank() || pizza.getTamanio().isEmpty()){
            LOG.log(Level.SEVERE, "Error en el tamaño de la pizza.");
            throw new NegocioException("El tamaño de la pizza no puede ser vacío/null.");
        }
        if(pizza.getTamanio() != "Grande" && pizza.getTamanio() != "Mediana" && pizza.getTamanio() != "Chica"){
            LOG.log(Level.SEVERE, "Error en el tamaño de la pizza.");
            throw new NegocioException("El tamaño de la pizza no puede pasar ser diferente de Chica, Mediana o Grande.");
        } else {
            pza.setTamanio(pizza.getTamanio());
        }
        if(pizza.getDescripcion() == null || pizza.getDescripcion().isBlank() || pizza.getDescripcion().isEmpty()){
            LOG.log(Level.SEVERE, "Error en la descripción de la pizza.");
            throw new NegocioException("La pizza debe contener una descripción.");
        }
        if(pizza.getDescripcion().length() > 300){
            LOG.log(Level.SEVERE, "Error en la descripción de la pizza.");
            throw new NegocioException("La descripción no debe pasar de los 300 caractéres.");
        } else {
            pza.setDescripcion(pizza.getDescripcion());
        }
        if(pizza.getPrecio() == null){
            LOG.log(Level.SEVERE, "Error en el precio de la pizza.");
            throw new NegocioException("La pizza debe contener un precio.");
        }
        if(pizza.getPrecio() > 99999) {
            LOG.log(Level.WARNING, "Error con el precio de la pizza.");
            throw new NegocioException("El precio sobrepasa el límite (99999.99)");
        } 
        if (pizza.getPrecio() * 100 != Math.floor(pizza.getPrecio() * 100)) {
            LOG.log(Level.WARNING, "Error con el precio de la pizza.");
            throw new NegocioException("El precio no puede pasar de los dos decimales después del punto.");
        } else {
            pza.setPrecio(pizza.getPrecio());
        }
        if(pizza.getEstado() == null || pizza.getEstado().isBlank() || pizza.getEstado().isEmpty()){
            LOG.log(Level.SEVERE, "Error en el estado de la pizza.");
            throw new NegocioException("El estado no puede estar vacío.");
        }
        if(pizza.getEstado() != "Disponible" && pizza.getEstado() != "No Disponible"){
            LOG.log(Level.SEVERE, "Error en el estado de la pizza.");
            throw new NegocioException("El estado solo puede ser Disponible o No Disponible.");
        } else {
            pza.setEstado(pizza.getEstado());
        } 
        try{
            Pizza p = pizzaDAO.agregarPizza(pza);
            if(p == null){
                LOG.log(Level.WARNING, "No se agregó la pizza en la base de datos.");
                throw new NegocioException("Error al almacenar la pizza en la base de datos.");
            }
            return p;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Error al insertar en la base de datos.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
    
    /**
     *
     * @param id_pizza
     * @return
     * @throws NegocioException
     */
    @Override
    public Pizza consultarPizza(Integer id_pizza) throws NegocioException {
        if(id_pizza == null){
            LOG.log(Level.WARNING, "Debe ingresar un id para consultar.");
            throw new NegocioException("ID no puede estar vacío.");
        }
        if(id_pizza < 1){
            LOG.log(Level.WARNING, "El ID no puede ser menor o igual a 0.");
            throw new NegocioException("ID inválido a consultar");
        }
        try{
            Pizza p = pizzaDAO.consultarPizza(id_pizza);
            if(p == null){
                LOG.log(Level.WARNING, "No se encontró una pizza con dicho ID.");
                throw new NegocioException("Pizza no encontrada.");
            }
            return p;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Error al consultar la base de datos.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
    
    /**
     *
     * @param id_pizza
     * @return
     * @throws NegocioException
     */
    @Override
    public Pizza cancelarPizza(Integer id_pizza) throws NegocioException {
        if(id_pizza == null){
            LOG.log(Level.WARNING, "Debe ingresar un id para consultar.");
            throw new NegocioException("ID no puede estar vacío.");
        }
        if(id_pizza < 1){
            LOG.log(Level.WARNING, "El ID no puede ser menor o igual a 0.");
            throw new NegocioException("ID inválida a consultar.");
        }
        try{
            Pizza p = pizzaDAO.cancelarPizza(id_pizza);
            if(p == null){
                LOG.log(Level.WARNING, "No se encontró una pizza la cual cancelar.");
                throw new NegocioException("Pizza no encontrada.");
            }
            return p;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Error al cancelar el pedido.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
}
