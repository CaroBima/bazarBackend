

package com.bazar.bazar.repository;

import com.bazar.bazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Caro
 */
public interface IProductoRepository extends  JpaRepository<Producto, Long> {
    
}
