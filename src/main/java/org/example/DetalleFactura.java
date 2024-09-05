package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Detallefactura")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DetalleFactura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int cantidad;
    private int subtotal ;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="fk_factura")
    private Factura factura ;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="fk_articulo")
    private Articulo articulo;
}
