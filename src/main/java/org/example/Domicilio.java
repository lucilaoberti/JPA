package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Domicilio")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name="nombrecalle")
    private String nombreCalle ;
    @Column(name="numero")
    private int numero ;
// En el caso de tener la relacion cliente-domicilio bidireccional
// @OneToOne(mappedBy = "domicilio")
   // private Cliente cliente ;
}
