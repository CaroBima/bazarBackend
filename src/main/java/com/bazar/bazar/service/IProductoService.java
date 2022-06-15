
package com.bazar.bazar.service;

import com.bazar.bazar.model.Producto;
import java.util.List;

/**
 *
 * @author Caro
 */
public interface IProductoService {
    public void guardarProducto(Producto producto);
    public List<Producto> buscarProductos();
    public Producto buscarUnProducto(Long idProducto);
    public Producto modificarProducto(Long idProducto, String nuevoNombre, String nuevaMarca, Double nuevoCosto, Double nuevaCantDisp);
    public void eliminarProducto(Long idProducto);
}
