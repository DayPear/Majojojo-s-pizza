/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class pruebasPaneles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            javax.swing.JFrame ventana = new javax.swing.JFrame("Prueba de Panel con Fondo");

            // Creamos una instancia del panel
            PanelRealizarPedidoCliente panelTonto = new PanelRealizarPedidoCliente();
            panelTonto.setPreferredSize(new java.awt.Dimension(800, 600)); //tamaño sugerido
            ventana.add(panelTonto);
            ventana.pack(); //ajusta la ventana al tamaño del panel

            // Configuraciones
            ventana.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            ventana.add(panelTonto); 
            ventana.setSize(900, 700); 
            ventana.setLocationRelativeTo(null); 
            ventana.setVisible(true); 
        });
    }

}
