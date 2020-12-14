package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.Repository.ProductRepository;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductControllerJPA {
//DATA via connector JPA
//using ProductRepository

    @Autowired
    ProductRepository productRepository; //repository JPA table "Product"

    @Autowired
    private RestTemplate restTemplate; //clientREST

    //Récupérer la liste des produits
    @RequestMapping(value="/ProduitsJPA", method=RequestMethod.GET)
    public List<Product>listeProduits() {
        return productRepository.findAll();
    }


    //Récupérer un produit par son Id
    @GetMapping(value="/ProduitsJPA/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productRepository.getOne(id);
    }

    //Récupérer un produit par son Id 2
    @GetMapping(value="/ProduitsJPA2/{id}")
    public Product afficherUnProduit2(@PathVariable int id) {
        return productRepository.findById(id);
    }

    //Récupérer ptoduits plus cher de "price"
    @GetMapping(value="/ProduitsJPA/more/{price}")
    public List<Product> afficherListMorePrice(@PathVariable int price) {
        return productRepository.findByPrixGreaterThan((float)price);
    }

    @GetMapping(value="/ProduitsJPA/sortByColumns/{col1}/{col2}")
    public List<Product> sortByColumns(@PathVariable String col1,@PathVariable String col2) {
        return productRepository.findAll(
                Sort.by(col1).ascending().and(Sort.by(col2)).ascending());

    }
    @GetMapping(value="/ProduitsJPA/sortByNom")
    public List<Product> sortByNom() {
        return productRepository.OrderByNom();

    }



    //Save
    @PostMapping(path="/ProduitsJPA/save",consumes = "application/json")
    public String saveNew(@RequestBody Product typedProduct) {
        Product p = new Product(
                typedProduct.getNom(), Float.valueOf(typedProduct.getPrix()));
        productRepository.saveAndFlush(p);
        return "ok";
    }

    //Delete
    @GetMapping(path="/ProduitsJPA/delete/{id}")
    public String delete(@PathVariable int id) {
        Product p = afficherUnProduit(id);
        productRepository.delete(p);
        return "deleted";
    }

    //Search contains *string*
    @GetMapping(path="/ProduitsJPA/contains/{string}")
    public List<Product> contains(@PathVariable String string) {
        return productRepository.findByNomContains(string);
    }

    //Query example
    @GetMapping(path="/ProduitsJPA/chers/{myfloat}")
    List<Product>  chercherUnProduitCher(@PathVariable Float myfloat){
       return productRepository.chercherUnProduitCher(myfloat);
        //return afficherListMorePrice(500);
    }

    //Call External SErvice
    @GetMapping(path="/ProduitsJPA/call/s1")
    public String callRestExample(){
        String url = "https://filebin.net/t7kfn2p6dxqzc38a";
        //String url ="https://de.catbox.moe/vv5s8e.json";
        /*Product p = restTemplate.getForObject(url,Product.class);
        return p;*/
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        ResponseEntity<String> st = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(requestHeaders), String.class);
        //Gson g = new Gson();
        //DTO dto = g.fromJson(st.getBody(), DTO.class);
        return st.getBody();
    }



}
