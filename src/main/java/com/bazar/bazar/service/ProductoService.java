
package com.bazar.bazar.service;

import com.bazar.bazar.model.Producto;
import com.bazar.bazar.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Caro
 */
@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepo;
    
    @Override
    public void guardarProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public List<Producto> buscarProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto buscarUnProducto(Long idProducto) {
        return productoRepo.findById(idProducto).orElse(null);
    }

    @Override
    public Producto modificarProducto(Long idProducto, String nuevoNombre, String nuevaMarca, Double nuevoCosto, Double nuevaCantDisp) {
    
        Producto producto = this.buscarUnProducto(idProducto);
                
        //verifico que se haya pasado este parametro para no guardar un valor null en la bbdd
        if(nuevoNombre != null){
           producto.setNombre(nuevoNombre); 
       }
        
        if(nuevaMarca != null){
            producto.setMarca(nuevaMarca);
        }
            
        if(nuevoCosto != null){
            producto.setCosto(nuevoCosto);
        }
        
        if(nuevaCantDisp != null){
            producto.setCantidad_disponible(nuevaCantDisp);
        }
        
        
       this.guardarProducto(producto);
       return producto;    
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        productoRepo.deleteById(idProducto);
    }
    
}
