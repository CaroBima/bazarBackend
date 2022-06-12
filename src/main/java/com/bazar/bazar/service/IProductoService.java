
package com.bazar.bazar.service;

import com.bazar.bazar.model.Producto;
import java.util.List;

/**
 *
 * @author Caro
 */
public interface IProductoService {
    public void agregarProducto(Producto producto);
    public List<Producto> buscarProductos();
    public Producto buscarUnCliente(Long idProducto);
    public Producto modificarCliente(Long idCliente);
    public void eliminarCliente(Long idCliente);
}
