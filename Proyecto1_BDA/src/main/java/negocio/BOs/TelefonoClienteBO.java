/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.TelefonoClienteNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAOs.ITelefonoClienteDAO;
import persistencia.dominio.TelefonoCliente;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public class TelefonoClienteBO implements ITelefonoClientesBO {
    private ITelefonoClienteDAO telefonoDAO;
    private static final Logger LOG = Logger.getLogger(TelefonoClienteBO.class.getName());
    
    
    public TelefonoClienteBO(ITelefonoClienteDAO telefono){
        this.telefonoDAO = telefono;
    }

    @Override
    public TelefonoCliente agregarTelefono(TelefonoClienteNuevoDTO telefono) throws NegocioException {
        if(telefono == null){
            LOG.log(Level.WARNING, "El telefono no puede ser nulo.");
            throw new NegocioException("El telefono es nulo.");
        }
        
        if(telefono.getEtiqueta() == null || telefono.getEtiqueta().isEmpty() || telefono.getEtiqueta().isBlank()){
            throw new NegocioException("No se puede agregar: la etiqueta es obligatoria");
        }
        
        if(telefono.getId_cliente() == null){
            throw new NegocioException("No se puede agregar: el ID del cliente es obligatorio");
        }
        
        TelefonoCliente tel = new TelefonoCliente(telefono.getTelefono(), telefono.getEtiqueta(), telefono.getId_cliente());
        try{
            TelefonoCliente telNew = this.telefonoDAO.agregarTelefonoCliente(tel);
            if(telNew == null){
                LOG.warning("No se pudo registrar el nuevo telefono del cliente a la base de datos.");
                throw new NegocioException("No se insertó el telefono del cliente a la base.");
            }
            LOG.log(Level.INFO, "Se insertó el telefono del cliente a la base.");
            return telNew;
        } catch (PersistenciaException ex) {
            LOG.log(Level.WARNING, "Problemas con la insersión del telefono del cliente.");
            throw new NegocioException(ex.getMessage(), ex);
        }
    }

    @Override
    public TelefonoCliente consultarTelefono(int id_telefono) throws NegocioException {
        if (id_telefono < 1) {
            LOG.warning("El ID del telefono no puede ser menor a 1.");
            throw new NegocioException("El ID es invalido.");
        }
        try {
            TelefonoCliente tel = this.telefonoDAO.consultarTelefonoCliente(id_telefono);
            if(tel == null){
                LOG.warning("No se pudo consultar el telefono del cliente de la base de datos.");
                throw new NegocioException("Fallo al consultar el telefono del cliente");
            }
            LOG.log(Level.INFO, "Telefono encontrado.");
            return tel;
        } catch (PersistenciaException ex) {
            LOG.log(Level.WARNING, "Problemas para acceder a la información del telefono del cliente en la base de datos.");
            throw new NegocioException(ex.getMessage(), ex);
        }
    }
}
