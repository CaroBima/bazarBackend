

package com.bazar.bazar.controller;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.model.Producto;
import com.bazar.bazar.model.Venta;
import com.bazar.bazar.service.IVentaService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Caro
 */
@RestController
public class VentaController {
    
    @Autowired
    public IVentaService ventaServ;
    
     //Endpoint que permite agregar una nueva venta
    @PostMapping("/ventas/crear")
    public void crearVenta(@RequestBody Venta venta){
        ventaServ.guardarVenta(venta);
    }
    
      //devuelve el listado completo de ventas
    @GetMapping("/ventas")
    public List<Venta> traerVentas(){
        return  ventaServ.buscarVentas();
    }
    
    //trae una venta en particular
    @GetMapping("/ventas/{codigo_venta}")
    public Venta traerUnaVenta(@PathVariable Long codigo_venta){
        return  ventaServ.buscarUnaVenta(codigo_venta);
    }
    
     //endpoint para borrar una venta
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public void deleteVenta(@PathVariable Long codigo_venta){
        ventaServ.eliminarVenta(codigo_venta);
    }
    
    
        //Edición de un producto:
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVenta (@PathVariable Long codigo_venta,
                                @RequestParam( required = false, name = "fecha_venta") String nuevaFecha,
                                @RequestParam( required = false, name = "total") Double nuevoTotal,
                                @RequestParam( required = false, name = "listaProductos") List<Producto> nuevaListProductos,
                                @RequestParam( required = false, name = "unCliente") Cliente unCliente){
    
       
        //se envia la id original para buscar la venta a modificar + los nuevos datos
        LocalDate nuevaF = conversorFecha(nuevaFecha);
               ventaServ.modificarVenta(codigo_venta, nuevaF, nuevoTotal, nuevaListProductos, unCliente);
        return ventaServ.buscarUnaVenta(codigo_venta);
        
    }
    
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> traerProductosXIdVenta(@PathVariable Long codigo_venta){
        Venta venta = ventaServ.buscarUnaVenta(codigo_venta);
        
        return venta.getListaProductos();
    }
            
    
    @GetMapping("/ventasFecha/{fecha_venta}")
    public List<Venta> traerVentasXFecha(@PathVariable String fecha_venta){
        List<Venta> listaVentasXFecha = new ArrayList();
        List<Venta> listaVentas = ventaServ.buscarVentas();
        System.out.println(fecha_venta);
        LocalDate fechaAConsultar = conversorFecha(fecha_venta);
        
        for(Venta venta : listaVentas){
            System.out.println("entra al for");
            if(venta.getFecha_venta().equals(fechaAConsultar)){
                System.out.println("entra al if");
                listaVentasXFecha.add(venta);
            }
        }
                
        return listaVentasXFecha;
    }
            
    private LocalDate conversorFecha(String fechaAConvertir){
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     Date fechaConvertida=null;

    try {
        Date parsed =  dateFormat.parse(fechaAConvertir);
        fechaConvertida = new Date(parsed.getTime());
        } catch(Exception e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
    return fechaConvertida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}