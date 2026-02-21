/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAOs;

import java.time.LocalDateTime;
import persistencia.dominio.Pedido;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Dayanara Peralta G
 */
public interface IPedidoDAO {
    
    Pedido agregarPedido(Pedido pedido) throws PersistenciaException;
    
    Pedido consultarPedido(int numeroPedido) throws PersistenciaException;
    
    Pedido cancelarPedido(int numero_pedido) throws PersistenciaException;
    
    Pedido actualizarEstadoPedido(Pedido pedido) throws PersistenciaException;
    //public boolean cambiarEstado();
    //public Pedido buscarPedidoPorNumero();
}
