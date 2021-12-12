/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.uagrm.ficct.inf310sb.ed2202102.ui;

import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ArbolMViasBusqueda;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ExcepcionClaveNoexiste;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ExeceptionOrdenNoValido;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.IArbolBusqueda;
import bo.edu.uagrm.ficct.inf310sb.ed2202102.arboles.ArbolB;

/**
 *
 * @author Andres
 */
public class TestArbolMVias {
    public static void main(String[] args) throws ExeceptionOrdenNoValido, ExcepcionClaveNoexiste {
        IArbolBusqueda<Integer,String> arbolMVias1 = new ArbolMViasBusqueda<>(3);
        IArbolBusqueda<Integer,String> arbolMVias2 = new ArbolMViasBusqueda<>(3);
        IArbolBusqueda<Integer,Integer> arbolB1 = new ArbolB<>(5);
        
       /* arbolMVias1.insertar(1,1);
        arbolMVias1.insertar(15,15);
        arbolMVias1.insertar(25,25);
        arbolMVias1.insertar(6,6);
        arbolMVias1.insertar(5,5);
        arbolMVias1.insertar(7,7);
        arbolMVias1.insertar(8,8);
        arbolMVias1.insertar(9,9);
        arbolMVias1.insertar(2,2);
        arbolMVias1.insertar(3,3);
        arbolMVias1.insertar(4,4);
        arbolMVias1.insertar(26,11);
        arbolMVias1.insertar(27,12);
        arbolMVias1.insertar(28,13);
        arbolMVias1.insertar(10,13);
        arbolMVias1.insertar(11,13);*/
       
        arbolMVias1.insertar(60, "andres silva");
        arbolMVias1.insertar(40, "Pepe serrate");
        arbolMVias1.insertar(100, "Juan Morales");
        arbolMVias1.insertar(20, "Juana flores");
        arbolMVias1.insertar(50, "Armando Paredes");
        arbolMVias1.insertar(45, "Joaquin Chumacero");
        arbolMVias1.insertar(22, "Roberto paniagua");
        arbolMVias1.insertar(21, "Esteban Arce");
        arbolMVias1.insertar(23, "Diego Rojas");
        arbolMVias1.insertar(140, "Belen Flores");
        arbolMVias1.insertar(120, "Brenda Tordoya");
        arbolMVias1.insertar(125, "Jose Marco Roca");       

        arbolMVias2.insertar(60, "andres silva");
        arbolMVias2.insertar(40, "Pepe serrate");
        arbolMVias2.insertar(100, "Juan Morales");
        arbolMVias2.insertar(20, "Juana flores");
        arbolMVias2.insertar(50, "Armando Paredes");
        arbolMVias2.insertar(45, "Joaquin Chumacero");
        arbolMVias2.insertar(22, "Roberto paniagua");
        arbolMVias2.insertar(21, "Esteban Arce");
        arbolMVias2.insertar(55, "Diego Rojas");
        arbolMVias2.insertar(140, "Belen Flores");
        arbolMVias2.insertar(120, "Brenda Tordoya");
        arbolMVias2.insertar(125, "Jose Marco Roca");   
        //arbolMVias2.insertar(126, "Jose Marco Roca");   
        
        if (((ArbolMViasBusqueda)arbolMVias1).sonArbolesSimilares((ArbolMViasBusqueda) arbolMVias2)) {
            System.out.println("son arboles similares");
        }else {
            System.out.println("no son arboles similares");
        }
        
        System.out.println("recorrido por niveles: " + arbolMVias1.recorridoPorNiveles());
        System.out.println("recorrido Pre-Orden:   " + arbolMVias1.recorridoPreOrden());
        System.out.println("recorrido In-Orden:    " + arbolMVias1.recorridoInOrden());
        System.out.println("recorrido Post-Orden:  " + arbolMVias1.recorridoPostOrden());
        int nivel = 0;
        if (((ArbolMViasBusqueda) arbolMVias1).hayNodosCompletosNivelN(nivel)) {
            System.out.println("Hay Nodos Completos en el nivel " + nivel);
        } else {
            System.out.println("No hay Nodos Completos en el nivel " + nivel);
        }      
        
       /* System.out.println("valor: " + arbolMVias1.eliminar(2));
        System.out.println("valor: " + arbolMVias1.eliminar(4));
        System.out.println("valor: " + arbolMVias1.eliminar(3));
        System.out.println("valor: " + arbolMVias1.eliminar(28));
        */
        System.out.println("recorrido por niveles: " + arbolMVias1.recorridoPorNiveles());
        System.out.println("size: " + arbolMVias1.size());
        System.out.println("altura: " + arbolMVias1.altura());
        System.out.println("cantidad de claves vacias:    " + ((ArbolMViasBusqueda)arbolMVias1).cantidadDeClavesVacias());
        System.out.println("cantidad de claves NO vacias: " + ((ArbolMViasBusqueda)arbolMVias1).cantidadDeClavesNoVacias());
        System.out.println("cantidad de Hijos vacios:     " + ((ArbolMViasBusqueda)arbolMVias1).cantidadDeHijosVacios());
        //System.out.println("cantidad de Hijos vacios del nivel n: " + ((ArbolMViasBusqueda)arbolMVias1).cantidadDeHijosVaciosNivelN(3));
       // System.out.println("cantidad de Hijos vacios antes del nivel n: " + ((ArbolMViasBusqueda)arbolMVias1).cantidadDeHijosVaciosAntesDelNivelN(3));
        //System.out.println("cantidad de Hijos vacios a partir del nivel n: " + ((ArbolMViasBusqueda)arbolMVias1).cantidadDeHijosVaciosAPatirDelNivelN(2));
 
       
        //--------------------ARBOL  B ------------------------------------------
        
        arbolB1.insertar(50,1);
        arbolB1.insertar(20,15);
        arbolB1.insertar(60,25);
        arbolB1.insertar(80,6);
        arbolB1.insertar(25,5);
        arbolB1.insertar(26,7);
        arbolB1.insertar(27,8);
        arbolB1.insertar(100,9);
        arbolB1.insertar(200,2);
        arbolB1.insertar(300,3);
        arbolB1.insertar(51,4);
        arbolB1.insertar(55,11);
        arbolB1.insertar(71,12);
        arbolB1.insertar(77,12);
        arbolB1.insertar(81,12);
        arbolB1.insertar(94,12);
        arbolB1.insertar(15,12);
        arbolB1.insertar(23,12);
        arbolB1.insertar(57,12);
        arbolB1.insertar(43,12);
        arbolB1.insertar(38,12);
        arbolB1.insertar(121,12);
        arbolB1.insertar(111,12);
        arbolB1.insertar(911,12);
        arbolB1.insertar(110,12);
        arbolB1.insertar(432,12);
        arbolB1.insertar(321,12);
        arbolB1.insertar(210,12);
        arbolB1.insertar(123,12);
        arbolB1.insertar(234,12);
        arbolB1.insertar(345,12);
        arbolB1.insertar(456,12);
        arbolB1.insertar(567,12);
        arbolB1.insertar(98,12);
        
        
        
        System.out.println("recorrido por niveles: " + arbolB1.recorridoPorNiveles());
        System.out.println("recorrido Pre-Orden:   " + arbolB1.recorridoPreOrden());
        System.out.println("recorrido In-Orden:    " + arbolB1.recorridoInOrden());
        System.out.println("recorrido Post-Orden:  " + arbolB1.recorridoPostOrden());
        
        System.out.println(arbolB1.eliminar(38));
        System.out.println(arbolB1.eliminar(50));
        System.out.println(arbolB1.eliminar(456));
        System.out.println(arbolB1.eliminar(200));
        System.out.println(arbolB1.eliminar(100));
        System.out.println(arbolB1.eliminar(98));
        System.out.println(arbolB1.eliminar(94));
        System.out.println(arbolB1.eliminar(71));
        System.out.println(arbolB1.eliminar(80));
        System.out.println(arbolB1.eliminar(77));
        System.out.println(arbolB1.eliminar(321));
        System.out.println(arbolB1.eliminar(60));
        System.out.println(arbolB1.eliminar(57));
        System.out.println(arbolB1.eliminar(234));
        System.out.println(arbolB1.eliminar(911));
        System.out.println(arbolB1.eliminar(300));
        System.out.println(arbolB1.eliminar(345));
        
        
        
       
        
        
        
        
         System.out.println("recorrido por niveles: " + arbolB1.recorridoPorNiveles());
    }
}
