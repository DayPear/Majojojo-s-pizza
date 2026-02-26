
package negocio.BOs;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.PedidoExpressResumenDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAOs.IPedidoExpressDAO;
import persistencia.DAOs.PedidoExpressDAO;
import persistencia.conexion.ConexionBD;
import persistencia.conexion.IConexionBD;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Piña
 */
public class PedidoExpressBO implements IPedidoExpressBO {

   private final IPedidoExpressDAO pedidoExpressDAO; 

    public PedidoExpressBO() {
        IConexionBD conexion = new ConexionBD(); 
        this.pedidoExpressDAO = new PedidoExpressDAO(conexion); 
    }

    @Override
    public List<PedidoExpressResumenDTO> listarResumenExpress() throws NegocioException {
        try {
            
            return pedidoExpressDAO.obtenerPedidosExpress();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar pedidos", e);
        }
    }
}
