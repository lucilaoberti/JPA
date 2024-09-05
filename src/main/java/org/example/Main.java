package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("en marcha Alberto");

        try {
            Cliente cliente = new Cliente(null, "Sabrina", "Carpenter", 40101774,null);  // id se deja como null, será generado por la base de datos
            Domicilio domicilio = new Domicilio(null,"San Juan",2024);
            cliente.setDomicilio(domicilio);
            // categorias
            Categoria perecederos= new Categoria();
            perecederos.setDenominacion("Perecederos");
            Categoria lacteos= new Categoria();
            lacteos.setDenominacion("Lacteos");
            Categoria limpieza= new Categoria();
            limpieza.setDenominacion("Limpieza");
            //articulos 1
            Articulo art1= new Articulo ();
            art1.setCantidad(200);
            art1.setDenominacion("Yogurt Ser sabor frutilla");
            art1.setPrecio(20);
             //articulu
            Articulo art2= new Articulo ();
            art2.setDenominacion("Detergente Magistral");
            art2.setCantidad(300);
            art2.setPrecio(80);
            art1.getCategorias().add(perecederos);
            art1.getCategorias().add(lacteos);
            lacteos.getArticulos().add(art1);
            perecederos.getArticulos().add(art1);
            art2.getCategorias().add(limpieza);
            limpieza.getArticulos().add(art2);
            //factura
            Factura factura = new Factura();
            factura.setCliente(cliente);
            factura.setFecha("4/9/24");
            //detalle factura 1
            DetalleFactura det1= new DetalleFactura();
            det1.setArticulo(art1);
            det1.setCantidad(2);
            det1.setSubtotal(40);
            factura.getDetalles().add(det1);
            det1.setFactura(factura);
            //detalle factura 2
            DetalleFactura det2= new DetalleFactura();
            det2.setArticulo(art2);
            det2.setCantidad(1);
            det2.setSubtotal(80);
            det2.setFactura(factura);
            factura.getDetalles().add(det2);
            // total de la factura
            factura.setTotal(120);

            entityManager.persist(factura);

            entityManager.getTransaction().commit();

        }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase Factura");}

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}