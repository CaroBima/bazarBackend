
package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Caro
 */
@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;
        
    //Guardar un nuevo cliente
    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    //devuelve todos los clientes
    @Override
    public List<Cliente> buscarClientes() {
       return clienteRepo.findAll();
    }

    //Permite buscar un cliente por el id y si no existe devuelve null
    @Override
    public Cliente buscarUnCliente(Long idCliente) {
        return clienteRepo.findById(idCliente).orElse(null);
    }

    //permite modificar uno o varios valores del cliente
    @Override
    public Cliente modificarCliente(Long idCliente, String nuevoNombre, String nuevoApellido, String nuevoDni) {
    
        Cliente cliente = this.buscarUnCliente(idCliente);
                
        //verifico que se haya pasado este parametro para no guardar un valor null en la bbdd
        if(nuevoApellido != null){
           cliente.setApellido(nuevoApellido);
       }
        
        if(nuevoNombre != null){
            cliente.setNombre(nuevoNombre);
        }
            
        if(nuevoDni != null){
            cliente.setDni(nuevoDni);
        }
        
       this.guardarCliente(cliente);
       return cliente;
    }

    //permite eliminar fisicamente al cliente de la bd
    @Override
    public void eliminarCliente(Long idCliente) {
        clienteRepo.deleteById(idCliente);
    }

 
    
}
