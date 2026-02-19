/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.excepciones.NegocioException;

/**
 *
 * @author maria
 */
public interface IPedidoBO {
    
    public Pedido insertarPedido(Pedido pedido) throws NegocioException;
    
    public Pedido consultarPedido(int numeroPedido) throws NegocioException;
    
    public Pedido cancelarPedido(int numeroPedido) throws NegocioException;
}
