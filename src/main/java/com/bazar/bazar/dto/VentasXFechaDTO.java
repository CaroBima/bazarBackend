

package com.bazar.bazar.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VentasXFechaDTO {
    private double montoTotal;
    private double cantidadVentas;

    public VentasXFechaDTO() {
    }

    public VentasXFechaDTO(double montoTotal, double cantidadVentas) {
        this.montoTotal = montoTotal;
        this.cantidadVentas = cantidadVentas;
    }

}
