package com.ecommerce.microcommerce.Repository;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(int id);
    List<Product> findByPrixGreaterThan(float prixLimit);
    List<Product> findByNomContains(String str);
    List<Product> OrderByNom();
    List<Product> OrderByPrix();

    @Query(value="SELECT id, nom, prix FROM Product p WHERE p.prix > :prixLimit",nativeQuery = true)
    List<Product>  chercherUnProduitCher(@Param("prixLimit") Float prix);

}