package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name="denominacion")
    private String denominacion ;
    @ManyToMany(mappedBy = "categorias")
    private Set<Articulo> articulos = new HashSet<>();
}
