/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author danna piña
 */
public class pruebasPaneles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            javax.swing.JFrame ventana = new javax.swing.JFrame("pedido cliente");
            
            ventana.setResizable(false);

            // Creamos una instancia del panel
            PanelPersonalizacionPizza1 panelPP = new PanelPersonalizacionPizza1();
            PanelRealizarPedidoCliente panelRPC = new PanelRealizarPedidoCliente();
            PanelRegistroUsuario panelRU = new PanelRegistroUsuario();
            panelRPC.setPreferredSize(new Dimension(1000, 800));
            panelPP.setPreferredSize(new Dimension(1000, 800)); //tamaño sugerido
            //ventana.add(panelRPC);
            //ventana.add(panelPP);
            ventana.pack(); //ajusta la ventana al tamaño del panel

            // Configuraciones
            ventana.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
           // ventana.add(panelPP); 
            //ventana.add(panelRPC);
            ventana.add(panelRU);
            ventana.setSize(1000, 800); 
            ventana.setLocationRelativeTo(null); 
            ventana.setVisible(true); 
        });
    }

}
