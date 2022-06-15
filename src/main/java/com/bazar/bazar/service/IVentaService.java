
package com.bazar.bazar.service;


import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.model.Producto;
import com.bazar.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Caro
 */
public interface IVentaService {
    public void guardarVenta(Venta venta);
    public List<Venta> buscarVentas();
    public Venta buscarUnaVenta(Long idVenta);
    public Venta  modificarVenta(Long idVenta, LocalDate nuevaFechaVenta, Double total, List<Producto> listaProd, Cliente uncliente);
    public void eliminarVenta(Long idVenta);
    
}
