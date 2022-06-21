package com.bazar.bazar.controller;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.service.IClienteService;
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

/**
 *
 * @author Caro
 */
@RestController
public class ClienteController {
    
     @Autowired
    private IClienteService clienteServ;
    
    
    //Endpoint que permite agregar un nuevo producto
    @PostMapping("/clientes/crear")
    public void createCliente(@RequestBody Cliente cliente){
        clienteServ.guardarCliente(cliente);
    }
    
    //devuelve el listado completo de productos
    @GetMapping("/clientes")
    public List<Cliente> traerClientes(){
        return  clienteServ.buscarClientes();
    }
    
    //trae un cliente en particular
    @GetMapping("/clientes/{id_cliente}")
    public Cliente traerUnCliente(@PathVariable Long id_cliente){
        return  clienteServ.buscarUnCliente(id_cliente);
    }
    
    //endpoint para borrar un producto
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public void deleteCliente(@PathVariable Long id_cliente){
        clienteServ.eliminarCliente(id_cliente);
    }
    
    //Edición de un producto:
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editPersona(@PathVariable Long id_cliente,
                                @RequestParam( required = false, name = "nombre") String nuevoNombre,
                                @RequestParam( required = false, name = "apellido") String nuevoApellido,
                                @RequestParam( required = false, name = "dni") String nuevoDni){
    
       
        //se envia la id original para buscar a la persona a modificar + los nuevos datos
        clienteServ.modificarCliente(id_cliente, nuevoNombre, nuevoApellido, nuevoDni);
        return clienteServ.buscarUnCliente(id_cliente);
    }
    
}
