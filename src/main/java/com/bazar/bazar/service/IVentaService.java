
package com.bazar.bazar.service;


import com.bazar.bazar.model.Venta;
import java.util.List;

/**
 *
 * @author Caro
 */
public interface IVentaService {
    public void agregarCliente(Venta venta);
    public List<Venta> buscarClientes();
    public Venta buscarUnCliente(Long idVenta);
    public Venta modificarCliente(Long idVenta);
    public void eliminarCliente(Long idVenta);
    
}
