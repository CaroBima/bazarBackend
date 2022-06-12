
package com.bazar.bazar.repository;

import com.bazar.bazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Caro
 */
public interface IClienteRepository extends  JpaRepository<Cliente, Long> {

    
}
