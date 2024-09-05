package org.example;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cliente")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni", unique = true)
    private int dni;

   @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_domicilio")
    private Domicilio domicilio ;
//en el caso de hacer la relacion bidirreccional entre factura y cliente
//@OneToMany(mappedBy= "cliente")
//private List<Factura> facturas = new ArrayList<Factura>;
}