/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.arsw.basictdd;

public class CalculadoraTarifas {

    /**
     * calcular la tarifa de cada billete segun el trayecto, la antelacion en la
     * que se obtiene el billete y la edad del pasajero, de acuerdo con la
     * normativa 005:
     * 
     * Normativa 005, sobre los descuentos:
     *  15% de descuento sacando el billete con antelación superior a 20 días. 
     *  5% a los pasajeros con edad inferior a 18 años 
     *      y 8% a los pasajeros con edad superior a 65 años. 
     *  Los descuentos SON ACUMULABLES.
     *
     * @param tarifaBase valor base del vuelo
     * @param diasAntelacion dias
     * @param edad - edad del pasajero
     * @return la tarifa ajustada
     * @throws ExcepcionParametrosInvalidos [XXXXXXXXXXXXXXXXXXXXXXXXXXX]
 *
     */
    public float calculoTarifa(float tarifaBase, int diasAntelacion, int edad) throws ExcepcionParametrosInvalidos{
       
        if (tarifaBase<0 || diasAntelacion<0 || edad < 0 || edad > 120){
            throw new ExcepcionParametrosInvalidos("Invalid parameters");
        }
        if (diasAntelacion > 20){
            tarifaBase=tarifaBase-(tarifaBase*0.15f);
        }
        else if (edad < 18){
            tarifaBase=tarifaBase-(tarifaBase*0.05f);
        }
        else if (edad >= 65){//No cumple con la especificacion, deberia ser edad>65
            tarifaBase=tarifaBase-(tarifaBase*0.8f);// el porcentaje esta mal, deberia ser 0.08
        }
        //No se esta acumulando el descuento
        return tarifaBase; 

    }

}