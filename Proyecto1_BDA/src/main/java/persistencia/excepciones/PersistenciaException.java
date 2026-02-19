/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.excepciones;

/**
 *
 * @author Dayanara Peralta G
 */
public class PersistenciaException extends Exception{

    /**
     *
     */
    public PersistenciaException() {
    }

    /**
     *
     * @param message
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
