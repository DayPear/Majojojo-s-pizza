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
    public int agregarPedido(String notas, float costo, String estado, LocalDateTime hora_recoleccion, Integer id_cliente) throws PersistenciaException;
    //public boolean cambiarEstado();
    //public Pedido buscarPedidoPorNumero();
}
