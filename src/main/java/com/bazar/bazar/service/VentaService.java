
package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.model.Producto;
import com.bazar.bazar.model.Venta;
import com.bazar.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Caro
 */
@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepo;
    
    @Override
    public void guardarVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> buscarVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta buscarUnaVenta(Long idVenta) {
        return ventaRepo.findById(idVenta).orElse(null);
    }

    @Override
    public Venta modificarVenta(Long idVenta, LocalDate nuevaFechaVenta, Double nuevoTotal, List<Producto> listaProd, Cliente nuevoCliente) {
        //implementar metodo para modificar venta
        Venta venta = this.buscarUnaVenta(idVenta);
                
                
        //verifico que se hayan pasado valores en los parametros para no guardar un valor null en la bbdd
        if(nuevaFechaVenta != null){
           venta.setFecha_venta(nuevaFechaVenta); 
       }
        
        if(nuevoTotal != null){
            venta.setTotal(nuevoTotal);
        }
            
        if(listaProd.size() != 0){
            venta.setListaProductos(listaProd);
        }
        
        if(nuevoCliente != null){
            venta.setUnCliente(nuevoCliente);
        }
        
        
       this.guardarVenta(venta);
       return venta;
    }



    @Override
    public void eliminarVenta(Long idVenta) {
        ventaRepo.deleteById(idVenta);
    }

}
