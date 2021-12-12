/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.ui;

import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ArbolBinarioBusqueda;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ExcepcionClaveNoexiste;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ExeceptionOrdenNoValido;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.IArbolBusqueda;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.clases.Cliente;

/**
 *
 * @author Andres
 */
public class Proyecto {
  public static void main(String[] args)  {
      IArbolBusqueda<Integer,Cliente> arbolDeClientes = new ArbolBinarioBusqueda<>();
      Cliente cliente1 = new Cliente("Andres","Silva Serrate","calle los pinos",69164434,null);
      
      arbolDeClientes.insertar(45,cliente1);
  }    
}
