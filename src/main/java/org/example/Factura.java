package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Factura")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name="fecha")
    private String fecha ;
    @Column(name="numero")
    private int numero ;
    @Column(name="total")
    private int total ;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="fk_cliente")
    private Cliente cliente ;


    @OneToMany(mappedBy = "factura ", cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "factura_id")
     private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
}
