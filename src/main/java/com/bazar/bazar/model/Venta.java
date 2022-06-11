
package com.bazar.bazar.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Caro
 */
@Getter
@Setter
public class Venta {
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private double total;
    private List<Producto> listaProductos;
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
    
    


}
