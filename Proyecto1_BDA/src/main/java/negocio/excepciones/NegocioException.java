/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.excepciones;

/**
 *
 * @author maria
 */
public class NegocioException extends Exception {
    
    /**
     * 
     */
    public NegocioException(){}
    
    /**
     * 
     * @param msg 
     */
    public NegocioException(String msg){
        super(msg);
    }
    
    /**
     * 
     * @param message
     * @param cause 
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
}
