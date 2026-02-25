/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.conexion.IConexionBD;
import persistencia.dominio.Pizza;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class PizzaDAO implements IPizzaDAO{
    private IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(PizzaDAO.class.getName());
  
    /**
     *
     * @param cone
     */
    public PizzaDAO (IConexionBD cone){
        this.conexion = cone;
    }

    /**
     *
     * @param pizza
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Pizza agregarPizza(Pizza pizza) throws PersistenciaException {
        String comandoSQL = """
                            insert into pizzas(
                            	nombre, tamanio, descripcion, precio, estado
                            )values(
                            	?, ?, ?, ?, ?
                            );
                            """;
        
        try(Connection cone = this.conexion.crearConexion();
                PreparedStatement ps = cone.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);){
            ps.setString(1, pizza.getNombre());
            ps.setString(2, pizza.getTamanio());
            ps.setString(3, pizza.getDescripcion());
            ps.setFloat(4, pizza.getPrecio());
            ps.setString(0, pizza.getEstado());
            
            int filasReg = ps.executeUpdate();
            if(filasReg == 0){
                LOG.warning("No se pudo agregar la pizza.");
                throw new PersistenciaException("No se pudo agregar la pizza.");
            }
            
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                    int id = rs.getInt(1);
                    pizza.setId_pizza(id);
                }
                return pizza;
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    /**
     *
     * @param id_pizza
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Pizza consultarPizza(int id_pizza) throws PersistenciaException{
        String comandoSQL = """
                            select
                            	nombre, tamanio, descripcion, precio, estado
                            from pizzas
                            where id_pizza = ?;
                            """;
        try(Connection cone = this.conexion.crearConexion();
                PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, id_pizza);
            try(ResultSet rs = ps.executeQuery()){
                if(!rs.next()){
                    LOG.log(Level.WARNING, "No se encontró el Pizza con el id:" + id_pizza);
                    throw new PersistenciaException("No existe la pizza con el id proporcionado.");
                }
                String nombre = rs.getString("nombre");
                String tamanio = rs.getString("tamanio");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                String estado = rs.getString("estado");
                
                Pizza piz = new Pizza(id_pizza, nombre, tamanio, descripcion, precio, estado);
                return piz;
            }
            
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    /**
     *
     * @param id_pizza
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Pizza cancelarPizza(int id_pizza) throws PersistenciaException {
        String comandoSQL = """
                            update pizzas set estado = "No Disponible" where id_pizza = ?
                            """;
        try(Connection cone = this.conexion.crearConexion(); PreparedStatement ps = cone.prepareStatement(comandoSQL)){
            ps.setInt(1, id_pizza);
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas == 0){
                LOG.log(Level.WARNING, "No se cambió el estado de la pizza.");
                throw new PersistenciaException("No se quitó del catálogo");
            }
            return consultarPizza(id_pizza);
        } catch(SQLException ex){
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    
}
