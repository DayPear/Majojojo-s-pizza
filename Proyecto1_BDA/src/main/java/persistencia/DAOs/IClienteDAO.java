/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import java.time.LocalDateTime;
import persistencia.dominio.Cliente;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public interface IClienteDAO {
    public Cliente agregarCliente(Integer id_cliente, String colonia, String calle, String numero, String codigo_postal, LocalDateTime fecha_nacimiento)throws PersistenciaException ;
}
