
package negocio.BOs;

import java.util.List;
import negocio.DTOs.PedidoExpressResumenDTO;
import negocio.excepciones.NegocioException;

/**
 *
 * @author PIña
 */
public interface IPedidoExpressBO {
    
    List<PedidoExpressResumenDTO> listarResumenExpress() throws NegocioException;
}
