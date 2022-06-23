package com.bazar.bazar.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private double total;
    
    
    @JoinTable(name = "ventaxproductos", joinColumns = {
                @JoinColumn(name = "codigo_venta", nullable = false)},
                inverseJoinColumns = {
                @JoinColumn(name = "codigo_producto", nullable = false)})
    @ManyToMany 
    (cascade = CascadeType.MERGE)
    private List<Producto> listaProductos;
    
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente unCliente;

    
    //constructores
    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
    
    


}