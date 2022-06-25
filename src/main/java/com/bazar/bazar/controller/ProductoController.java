package com.bazar.bazar.controller;

import com.bazar.bazar.model.Producto;
import com.bazar.bazar.model.Venta;
import com.bazar.bazar.service.IProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService productoServ;
    
    //Endpoint que permite agregar un nuevo producto
    @PostMapping("/productos/crear")
    public void createPersona(@RequestBody Producto producto){
        productoServ.guardarProducto(producto);
    }
    
    //devuelve el listado completo de productos
    @GetMapping("/productos")
    public List<Producto> traerProductos(){
        return  productoServ.buscarProductos();
    }
    
    //endpoint para borrar un producto
    @DeleteMapping("/producto/eliminar/{codigo_producto}")
    public void deletePersona(@PathVariable Long codigo_producto){
        productoServ.eliminarProducto(codigo_producto);
    }
    
    //Edición de un producto:
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto,
                                @RequestParam( required = false, name = "nombre") String nuevoNombre,
                                @RequestParam( required = false, name = "marca") String nuevaMarca,
                                @RequestParam( required = false, name = "costo") Double nuevoCosto,
                                @RequestParam( required = false, name = "cantidad_disponible") Double nuevaCantDisp){
    
       
        //se envia la id original para buscar a la persona a modificar + los nuevos datos
        productoServ.modificarProducto(codigo_producto, nuevoNombre, nuevaMarca, nuevoCosto, nuevaCantDisp);
        
        
        return productoServ.buscarUnProducto(codigo_producto);
    }
    
    
    @GetMapping("/productos/falta_stock")
    public List<Producto> productosFaltantes(){
        List<Producto> listaProdFaltantes  = new ArrayList();
        List<Producto> todosLosProductos;
        
        todosLosProductos = productoServ.buscarProductos();
        
        for (Producto prod : todosLosProductos){
            if(prod.getCantidad_disponible() < 5.0){
                System.out.println(prod.getCantidad_disponible());
                listaProdFaltantes.add(prod);
               
            }
        }
        
        return listaProdFaltantes;
    }
    
}
