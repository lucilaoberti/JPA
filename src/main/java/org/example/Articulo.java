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
public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name="denominacion")
    private String denominacion ;
    @Column(name="cantidad")
    private int cantidad ;
    @Column(name="precio ")
    private int precio ;
    @ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name="articulo_categoria" ,
            joinColumns = @JoinColumn(name="articulo_id"),
            inverseJoinColumns = @JoinColumn(name="categoria_id")
    )
    private Set<Categoria> categorias= new HashSet<>();
}
