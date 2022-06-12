
package com.bazar.bazar.repository;

import com.bazar.bazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Caro
 */
public interface IVentaRepository extends  JpaRepository<Venta, Long>{
    
}
