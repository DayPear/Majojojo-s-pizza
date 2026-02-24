/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.ClienteNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAOs.IClienteDAO;
import persistencia.dominio.Cliente;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class ClienteBO implements IClienteBO {
    
    private final IClienteDAO clienteDAO;
    private static final Logger LOG = Logger.getLogger(ClienteBO.class.getName());
    
    public ClienteBO(IClienteDAO cliente){
        this.clienteDAO = cliente;
    }
    
    @Override
    public Cliente registrarCliente(ClienteNuevoDTO cliente) throws NegocioException {
        Cliente cli = new Cliente();
        if(cliente == null){
            LOG.log(Level.WARNING, "No se puede validar el cliente si está vacío.");
            throw new NegocioException("Cliente nulo.");
        }
        if(cliente.getId() < 0 || cliente.getId() == null){
            LOG.log(Level.WARNING, "No se puede validar el cliente si no tiene un ID.");
            throw new NegocioException("Cliente sin usuario al cual asociarse.");
        } else {
            cli.setId_cliente(cliente.getId());
        }
        if(cliente.getColonia().trim().length() > 50){
            LOG.log(Level.WARNING, "El nombre de la colonia está muy largo, no puede pasar de 50 carácteres.");
            throw new NegocioException("Colonia inválida.");
        } else {
            cli.setColonia(cliente.getColonia());
        }
        if(cliente.getCalle().trim().length() > 50){
            LOG.log(Level.WARNING, "El nombre de la calle está muy largo, no puede pasar de 50 carácteres.");
            throw new NegocioException("Calle inválida.");
        } else {
            cli.setCalle(cliente.getCalle());
        }
        if(cliente.getNumero().trim().length() > 5){
            LOG.log(Level.WARNING, "El número de casa está muy largo, no puede pasar de 5 digítos.");
            throw new NegocioException("Número de casa inválido.");
        }
        if(!cliente.getNumero().trim().matches("\\d+")){
            LOG.log(Level.WARNING, "El número de casa solo puede contener digítos.");
            throw new NegocioException("Número de casa inválido..");
        } else {
            cli.setNumero(cliente.getNumero());
        }
        if(cliente.getCodigoP().trim().length() > 8){
            LOG.log(Level.WARNING, "El código postal está muy largo, no puede pasar de 8 dígítos.");
            throw new NegocioException("Código postal inválido.");
        }
        if(!cliente.getCodigoP().trim().matches("\\d+")){
            LOG.log(Level.WARNING, "El código postal solo puede contener digítos.");
            throw new NegocioException("Código postal inválido.");
        } else {
            cli.setCodigo_postal(cliente.getCodigoP());
        }    
        int dia = Integer.parseInt(cliente.getFechaNacimiento().substring(0, 2));
        int mes = Integer.parseInt(cliente.getFechaNacimiento().substring(2, 4));
        int anio = Integer.parseInt(cliente.getFechaNacimiento().substring(4, 8));

        LocalDate fecha = LocalDate.of(anio, mes, dia);
        if(fecha.isAfter(LocalDate.now())){
            LOG.log(Level.WARNING, "La fecha de nacimiento no puede ser a futuro.");
            throw new NegocioException("Fecha inválida.");
        }
        Date fechaBD = Date.valueOf(fecha);
        cli.setFecha_nacimiento(fechaBD);
        // falta un método q valide el id del usuario
        try{
            Cliente c = clienteDAO.agregarCliente(cli);
            return c;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Problemas con la insersión del cliente.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
    
    @Override
    public Cliente consultarCliente(ClienteNuevoDTO cliente) throws NegocioException {
        return null;
    }
    
    @Override
    public Cliente usuarioAsociadoCliente(int idUsuario) throws NegocioException {
        if(idUsuario < 1){
            LOG.log(Level.WARNING, "El ID no puede ser 0 o menor.");
            throw new NegocioException("Problemas con el ID.");
        }
        try{
            Cliente c = clienteDAO.validarIdUsuario(idUsuario);
            if(c == null){
                LOG.log(Level.WARNING, "No se pudo encontrar un usuario asociado al cliente.");
                throw new NegocioException("");
            }
            return c;
        } catch(PersistenciaException pe){
            LOG.log(Level.WARNING, "Problemas para consultar al usuario.");
            throw new NegocioException(pe.getMessage(), pe);
        }
    }
    
}
