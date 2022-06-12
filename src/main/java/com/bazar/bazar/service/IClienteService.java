
package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import java.util.List;

/**
 *
 * @author Caro
 */
public interface IClienteService {
    public void agregarCliente(Cliente cliente);
    public List<Cliente> buscarClientes();
    public Cliente buscarUnCliente(Long idCliente);
    public Cliente modificarCliente(Long idCliente);
    public void eliminarCliente(Long idCliente);
}
