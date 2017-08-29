/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.test;

import org.junit.Before;
import org.junit.Test;

import edu.eci.arsw.basictdd.CalculadoraTarifas;

import static org.junit.Assert.*;

/**
 * Diseño de pruebas:
 * 
 * Clases de equivalencia:
 *  	
 *      CE0: edad<=0
 *           Resultado esperado: Error - no puede haber edades negativas.
 *  
 *      CE1: 0<edad<18 && dias<=20
 *           Resultado esperado: 0.05.
 *          
 *      CE2: edad>65 && dias<=20.
 *           Resultado esperado: 0.08.
 *           
 *      CE3: edad>65 && dias>20.
 *           Resultado esperado: 0.23.
 *           
 *      CE4: 0<edad<18 && dias>20.
 *           Resultado esperado: 0.20.
 * 
 *      CE5: 18<=edad<=65 && dias<=20.
 *           Resultado esperado: 0.
 *           
 *      CE6: dias>20
 *      	 Resultado esperado: 0.15
 *  
 * Condiciones de frontera:
 * 
 *      CF1: edad==0 o edad==-1
 *           Clases de equivalencia relacionadas:CE0,CE1
 *           Resultado esperado: Error - no puede haber edades negativas.
 *           
 *           
 *      CF2: edad==1 && dias==10
 *           Clases de equivalencia relacionadas:CE0,CE1
 *           Resultado esperado: 0.05.
 *           
 *           
 *      CF3: (edad==15) && dias==10
 *           Clases de equivalencia relacionadas:CE1
 *           Resultado esperado: 0.05.
 *           
 *		CF4: edad==17 && dias==10
 *           Clases de equivalencia relacionadas:CE1,CE5
 *           Resultado esperado: 0.05.
 *           
 *           
 *      CF5: edad==18 && dias==10
 *           Clases de equivalencia relacionadas:CE1,CE5
 *           Resultado esperado: 0.
 *           
 *      CF6: (edad==40) && dias==10
 *           Clases de equivalencia relacionadas:CE5
 *           Resultado esperado: 0.
 *           
 *      CF6: (edad==65) && dias==10
 *           Clases de equivalencia relacionadas:CE5,CE2
 *           Resultado esperado: 0.
 *      
 *      CF7: (edad==66) && dias==10
 *           Clases de equivalencia relacionadas:CE5,CE2
 *           Resultado esperado: 0.08
 *           
 *      CF8: (edad==80) && dias==10
 *           Clases de equivalencia relacionadas:CE2
 *           Resultado esperado: 0.08
 *           
 *      CF2: edad==1 && dias==20
 *           Clases de equivalencia relacionadas:CE0,CE1
 *           Resultado esperado: 0.05.
 *           
 *      CF2: edad==1 && dias==21
 *           Clases de equivalencia relacionadas:CE0,CE1
 *           Resultado esperado: 0.20.
 *           
 *      CF3: (edad==15) && dias==20
 *           Clases de equivalencia relacionadas:CE1
 *           Resultado esperado: 0.05.
 *           
 *      CF3: (edad==15) && dias==21
 *           Clases de equivalencia relacionadas:CE1
 *           Resultado esperado: 0.20.
 *           
 *		CF4: edad==17 && dias==20
 *           Clases de equivalencia relacionadas:CE1,CE5
 *           Resultado esperado: 0.05.
 *           
 *      CF4: edad==17 && dias==21
 *           Clases de equivalencia relacionadas:CE1,CE5
 *           Resultado esperado: 0.20.
 *           
 *      CF5: edad==18 && dias==20
 *           Clases de equivalencia relacionadas:CE1,CE5
 *           Resultado esperado: 0.
 *           
 *      CF5: edad==18 && dias==21
 *           Clases de equivalencia relacionadas:CE1,CE5
 *           Resultado esperado: 0.15.
 *           
 *      CF6: (edad==40) && dias==10
 *           Clases de equivalencia relacionadas:CE5
 *           Resultado esperado: 0.
 *           
 *      CF6: (edad==65) && dias==10
 *           Clases de equivalencia relacionadas:CE5,CE2
 *           Resultado esperado: 0.
 *      
 *      CF7: (edad==66) && dias==10
 *           Clases de equivalencia relacionadas:CE5,CE2
 *           Resultado esperado: 0.08
 *           
 *      CF8: (edad==80) && dias==10
 *           Clases de equivalencia relacionadas:CE2
 *           Resultado esperado: 0.08
 * 
 */
public class CalculadorTarifasTest {
    
    public CalculadorTarifasTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    /**
    * Pruebas clase de equivalencia CE0: 
    **/
    @Test
    public void testClaseEquivalenciaCE0(){
            CalculadoraTarifas c= new CalculadoraTarifas();
            try{
            	c.calculoTarifa(0, 10, 0);            	
            }catch(Exception e)
            {
            	assertEquals("No se esta lanzando la excepcion correcta si la edad es cero"
            			,e.getMessage(),"La edad NO PUEDE ser cero");
            	assertEquals("No se esta lanzando la excepcion correcta si los dias son negativos"
            			,e.getMessage(),"Los dias NO PUEDEN SER NEGATIVOS");
            }
    }
    
    /**
     * Pruebas clase de equivalencia CE1: 
     **/
     @Test
     public void testClaseEquivalenciaCE1(){
    	 CalculadoraTarifas c=new CalculadoraTarifas();
         try {
        	 assertEquals("No se esta calculando correctamente con CF2"
        			 ,95,(int)c.calculoTarifa(100, 10, 1));
        	 assertEquals("No se esta calculando correctamente con CF3"
        			 , 95,(int)c.calculoTarifa(100, 10, 15));
        	 assertEquals("No se esta calculando correctamente con CF4"
        			 ,95, (int)c.calculoTarifa(100, 10, 17));
		} catch (Exception e) {
			fail("Esta lanzando excepcion con parametros correctos");
		}
         
     }
     
     /**
      * Pruebas clase de equivalencia CE2: 
      **/
      @Test
      public void testClaseEquivalenciaCE2(){
    	  CalculadoraTarifas c=new CalculadoraTarifas();
          try {
         	 assertTrue("No se esta calculando correctamente con CF7"
         			 , c.calculoTarifa(100, 10, 66)==92);
         	 assertTrue("No se esta calculando correctamente con CF8"
         			 , c.calculoTarifa(100, 10, 80)==92);
 		} catch (Exception e) {
 			fail("Esta lanzando excepcion con parametros correctos");
 		}
    	  
      }
      
      
      
      /**
       * Pruebas clase de equivalencia CE3: 
       **/
       @Test
       public void testClaseEquivalenciaCE3(){
    	   CalculadoraTarifas c=new CalculadoraTarifas();
           try {
          	 assertTrue("No se esta calculando correctamente con "
          			 , c.calculoTarifa(100, 21, 66)==77);
          	 assertTrue("No se esta calculando correctamente con CF8"
          			 , c.calculoTarifa(100, 30, 80)==77);
  		} catch (Exception e) {
  			fail("Esta lanzando excepcion con parametros correctos");
  		}       
       }
       
       /**
        * Pruebas clase de equivalencia CE4: 
        **/
        @Test
        public void testClaseEquivalenciaCE4(){
        	  CalculadoraTarifas c=new CalculadoraTarifas();
              try {
             	 assertTrue("No se esta calculando correctamente con CF7"
             			 , c.calculoTarifa(100, 21, 17)==80);
             	 assertTrue("No se esta calculando correctamente con CF8"
             			 , c.calculoTarifa(100, 30, 15)==80);
             	 assertTrue("No se esta calculando correctamente con CF8"
             			 , c.calculoTarifa(100, 21, 1)==80);
     		} catch (Exception e) {
     			fail("Esta lanzando excepcion con parametros correctos");
     		}
        }
        
        /**
         * Pruebas clase de equivalencia CE5: 
         **/
         @Test
         public void testClaseEquivalenciaCE5(){
        	  CalculadoraTarifas c=new CalculadoraTarifas();
              try {
             	 assertTrue("No se esta calculando correctamente con CF7"
             			 , c.calculoTarifa(100, 20, 18)==100);
             	 assertTrue("No se esta calculando correctamente con CF8"
             			 , c.calculoTarifa(100, 10, 65)==100);
             	 assertTrue("No se esta calculando correctamente con CF8"
             			 , c.calculoTarifa(100, 20, 50)==100);
     		} catch (Exception e) {
     			fail("Esta lanzando excepcion con parametros correctos");
     		}
         }
         
         /**
          * Pruebas clase de equivalencia CE6: 
          **/
          @Test
          public void testClaseEquivalenciaCE6(){
        	  CalculadoraTarifas c=new CalculadoraTarifas();
              try {
             	 assertTrue("No se esta calculando correctamente con CF7"
             			 , c.calculoTarifa(100, 21, 18)==85);
             	 assertTrue("No se esta calculando correctamente con CF8"
             			 , c.calculoTarifa(100, 30, 65)==85);
             	 assertTrue("No se esta calculando correctamente con CF8"
             			 , c.calculoTarifa(100, 21, 50)==85);
     		} catch (Exception e) {
     			fail("Esta lanzando excepcion con parametros correctos");
     		}
          }
}
