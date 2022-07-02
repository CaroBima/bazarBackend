

package com.bazar.bazar.controller;

import com.bazar.bazar.dto.MayorVentaDto;
import com.bazar.bazar.dto.VentasXFechaDTO;
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
    public VentasXFechaDTO traerVentasXFecha(@PathVariable String fecha_venta){
        List<Venta> listaVentas = ventaServ.buscarVentas();
        VentasXFechaDTO ventasXFecha = new VentasXFechaDTO();
        Double montoTotal = 0.0;
        int cantidadVentas = 0;
        
        LocalDate fechaAConsultar = conversorFecha(fecha_venta);
        
        //recorro la lista de ventas buscando aquellas correspondientes a la fecha consultada
        //hago la sumatoria de los montos y sumo uno al contador de ventas de esa fecha
        for(Venta venta : listaVentas){
            if(venta.getFecha_venta().equals(fechaAConsultar)){
                montoTotal += venta.getTotal();
                cantidadVentas ++;
                
            }
        }
                
        ventasXFecha.setCantidadVentas(cantidadVentas);
        ventasXFecha.setMontoTotal(montoTotal);
        return ventasXFecha;
    }
            
    
    /*Obtener el codigo_venta, el total, la cantidad de productos, el nombre del 
    cliente y el apellido del cliente de la venta con el monto más alto de todas.
    a. Métodos HTTP: GET
    b. Endpoint: localhost:8080/ventas/mayor_venta
    */
    @GetMapping("ventas/mayor_venta")
    public List<MayorVentaDto> mayorVenta(){
        Venta mayorVenta = new Venta(); 
        double mayorTotal = 0;
        List<MayorVentaDto> listaMayorVenta = new ArrayList();
        MayorVentaDto mayorV = new MayorVentaDto();
        
        List<Venta> listaVentas = ventaServ.buscarVentas();
        for (Venta venta : listaVentas){
            if(venta.getTotal() > mayorTotal){
                //Ifs para verificar si hay dos o mas ventas con el mismo importe mayor
                if(venta.getTotal() != mayorTotal){
                    mayorV.setCodigo_venta(venta.getCodigo_venta());
                    mayorV.setNombreCliente(venta.getUnCliente().getNombre());
                    mayorV.setApellidoCliente(venta.getUnCliente().getApellido());
                    mayorV.setMontoTotal(venta.getTotal());
                    mayorV.setTotalProductos(venta.getListaProductos().size());    
                    mayorTotal = venta.getTotal();
                    listaMayorVenta.clear();
                    listaMayorVenta.add(mayorV);
                }
                if(venta.getTotal() == mayorTotal){
                    mayorV.setCodigo_venta(venta.getCodigo_venta());
                    mayorV.setNombreCliente(venta.getUnCliente().getNombre());
                    mayorV.setApellidoCliente(venta.getUnCliente().getApellido());
                    mayorV.setMontoTotal(venta.getTotal());
                    mayorV.setTotalProductos(venta.getListaProductos().size());
                    mayorTotal = venta.getTotal();
                    listaMayorVenta.add(mayorV);
                }
               
            }
        }
        
        if(listaMayorVenta.size()== 0){
             System.out.println(listaMayorVenta.size());
            listaMayorVenta.add(mayorV);
        }
            
        return listaMayorVenta;
    }
    
    
    //Formateador de fechas
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