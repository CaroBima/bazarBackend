
package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import java.util.List;

/**
 *
 * @author Caro
 */
public interface IClienteService {
    public void guardarCliente(Cliente cliente);
    public List<Cliente> buscarClientes();
    public Cliente buscarUnCliente(Long idCliente);
    public Cliente modificarCliente(Long idCliente, String nuevoNombre, String nuevoApellido, String nuevoDni);
    public void eliminarCliente(Long idCliente);
}
