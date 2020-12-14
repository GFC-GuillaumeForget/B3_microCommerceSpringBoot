package com.ecommerce.microcommerce.web.controller.manualDAO;

import com.ecommerce.microcommerce.dao.manualDAO.ProductsDAO;
import com.ecommerce.microcommerce.model.manualDAO.ProductModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class ProductController {
//using ProductsDAO

    //@Autowired
    private ProductsDAO productDao; //->permet d'instancier automatiquement l'objet DAO

    //Récupérer la liste des produits
    @RequestMapping(value="/Produits", method=RequestMethod.GET)
    public List<ProductModel>listeProduits() {
        return productDao.findAll();
    }

    //Récupérer un produit par son Id
    @GetMapping(value="/Produits/{id}")
    public ProductModel afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }

    //Récupérer un produit par son Id
    @GetMapping(value="/ProduitFind/{id}")
    public ProductModel afficherUnProduit2(@PathVariable int id) {
        return productDao.findById(id);
    }

}
