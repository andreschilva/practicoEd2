/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles;

/**
 *
 * @author Andres
 */
public class ExeceptionOrdenNoValido extends Exception {

    public ExeceptionOrdenNoValido() {
        super("orden del arbol no puede ser menor");
    }
    

    public ExeceptionOrdenNoValido(String msg) {
        super(msg);
    }    
    
    
    
}
