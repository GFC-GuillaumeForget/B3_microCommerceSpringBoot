package com.ecommerce.microcommerce;

import com.ecommerce.microcommerce.Repository.ProductRepository;
import com.ecommerce.microcommerce.model.Product;
//import com.sun.org.slf4j.Logger;
//import com.sun.org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;


/* version simple sans Repository */

/*@SpringBootApplication
public class MicrocommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrocommerceApplication.class, args);
    }

}*/

/* version AVEC Repository */
@SpringBootApplication
public class MicrocommerceApplication implements CommandLineRunner {
   // private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment env;

    @Autowired
    ProductRepository productRepository;

    private static int isTest = 0;

    public static void main(String[] args) {
        SpringApplication.run(MicrocommerceApplication.class, args);

        //logger.info("Student id 10001 -> {}", repository.findById(10001L));
    }



    @Override
    public void run(String... args) throws Exception {
        logger.error("*********************GF MICRO APP. RUN*******************");
        if (MicrocommerceApplication.isTest==1) {
            test();
        }

    }

    public void test() throws Exception {
        //Code to run at application startup
        logger.error("*********************GF TEST*******************");
        Integer id = new Integer(1) ;
        Float newPrix = new Float("78.25") ;

        try{
            logger.warn("////////////// Product id 1");
            Optional<Product> r =  productRepository.findById(id);
            logger.warn("////////////// Product id 1 -> {}",r.get());

            logger.warn("/////////  All Products -> {}");
            List<Product> r2 =  productRepository.findAll();
            logger.warn("/////////  All Products -> {}", r2);


            logger.warn("///////// Inserting -> {}");
            //, productRepository.save(new Product(54,"table basse IKEA", newPrix)));
            Product r3 = productRepository.save(new Product("table basse RAKMOM99", newPrix));
        }
        catch (Exception e){
            logger.error(e.toString());
        }

    }



}