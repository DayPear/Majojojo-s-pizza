/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.DTOs.DetallesPedidoNuevoDTO;
import negocio.excepciones.NegocioException;
import persistencia.dominio.DetallesPedido;

/**
 *
 * @author maria
 */
public interface IDetallesPedidoBO {
    
    
    DetallesPedido agregarDetalles(DetallesPedidoNuevoDTO dpnd) throws NegocioException;
    
    DetallesPedido consultarDetalles(DetallesPedidoNuevoDTO dpnd) throws NegocioException;
    
    DetallesPedido actualizarDetalles(DetallesPedidoNuevoDTO dpnd) throws NegocioException;
    
    float totalPedido(DetallesPedidoNuevoDTO dpnd) throws NegocioException;
}
