/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.fabrica;

import negocio.BOs.IPedidoBO;
import negocio.BOs.IProgramadoBO;
import negocio.BOs.PedidoBO;
import negocio.BOs.ProgramadoBO;
import persistencia.fabrica.FabricaDAO;

/**
 *
 * @author maria
 */
public class FabricaBOs {
    
    // método que crea un PedidoBO listo para trabajar con él
    
    public IPedidoBO obtenerPedidoBO(){
        IPedidoBO pedido = new PedidoBO(FabricaDAO.obtenerPedidoDAO());
        return pedido;
    }
    
    public IProgramadoBO obtenerProgramadoBO(){
        IProgramadoBO programado = new ProgramadoBO(FabricaDAO.obtenerProgramadoDAO());
        return programado;
    }
    
}
