### Ejercicio en clase (cont)

### Parte I

1. Clone e importe el proyecto.
2. Revise cómo es la estructura de Maven para separar las pruebas de los demás artefactos del proyecto: src/main, src/test.
3. Ejecute la fase de pruebas del proyecto con el comando, y analice cómo son presentados los resultados.

    ```
    mvn test
    ```
4. Especifique las clases de equivalencia identificadas en los comentarios de la clase donde se implementarán las pruebas (CalculadoraTarifasTest).

5. Implemente un caso de prueba para cada clase de equivalencia/condicion de frontera identificado. Recuerde usar la anotacion @Test y seguir la conveción de nombres: 

    ```
    /**
    * Pruebas clase de equivalencia XX: 
    **/
    @Test
    public void testClaseEquivalenciaXX(){
            ...
    }
    ```

6. Una vez implementadas las pruebas, haga la implementación que ya hizo un 'programador poco confiable', en el archivo implementacionPocoConfiabe.txt.
7. Ejecute las pruebas. A partir de los resultados obtenidos, identifique los posibles problemas que tenga la implementación.