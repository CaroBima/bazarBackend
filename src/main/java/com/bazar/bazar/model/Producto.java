

package com.bazar.bazar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Caro
 */
@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long codigo_producto;
   private String nombre;
   private String marca;
   private Double costo;
   private Double cantidad_disponible;

   
   //constructores
    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }
   
    
}
