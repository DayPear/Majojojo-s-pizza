/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.excepciones.NegocioException;
import persistencia.dominio.Pedido;

/**
 *
 * @author maria
 */
public interface IPedidoBO {
    
    public Pedido insertarPedido(Pedido pedido) throws NegocioException;
    
    public Pedido consultarPedido(int numeroPedido) throws NegocioException;
    
    public Pedido cancelarPedido(Pedido pedido) throws NegocioException;
    
}
