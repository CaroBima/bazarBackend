

package com.bazar.bazar.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MayorVentaDto {
    private double codigo_venta;
    private int totalProductos;
    private String nombreCliente;
    private String apellidoCliente;
    private Double montoTotal;

    public MayorVentaDto() {
    }

    public MayorVentaDto(double codigo_venta, int totalProductos, String nombreCliente, String apellidoCliente, Double montoTotal) {
        this.codigo_venta = codigo_venta;
        this.totalProductos = totalProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.montoTotal = montoTotal;
    }
    
    
}
