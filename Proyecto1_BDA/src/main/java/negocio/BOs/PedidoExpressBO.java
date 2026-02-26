
package negocio.BOs;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.PedidoExpressResumenDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAOs.IPedidoExpressDAO;
import persistencia.DAOs.PedidoExpressDAO;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Piña
 */
public class PedidoExpressBO implements IPedidoExpressBO {

    private final IPedidoExpressDAO pedidoExpressDAO;
    private static final Logger LOG = Logger.getLogger(PedidoExpressBO.class.getName());

    public PedidoExpressBO(IPedidoExpressDAO pedidoExpressDAO) {
        this.pedidoExpressDAO = pedidoExpressDAO;
    }

    @Override
    public List<PedidoExpressResumenDTO> listarResumenExpress() throws NegocioException {
        try {
            List<PedidoExpressResumenDTO> lista = pedidoExpressDAO.obtenerPedidosExpress();

            if (lista == null || lista.isEmpty()) {
                LOG.log(Level.INFO, "No se encontraron pedidos express para mostrar.");
                // Opcional: puedes lanzar excepción o simplemente devolver la lista vacía
            }

            return lista;

        } catch (PersistenciaException pe) {
            LOG.log(Level.SEVERE, "Error al consultar los pedidos express en la base de datos.");
            throw new NegocioException("No se pudo obtener el reporte de pedidos express.", pe);
        }
    }
}
