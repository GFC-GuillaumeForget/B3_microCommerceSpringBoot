package com.ecommerce.microcommerce.dao.manualDAO;

import com.ecommerce.microcommerce.model.manualDAO.ProductModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//@Repository
public class ProductsDAOImpl implements ProductsDAO {
    /* BDD virtuelle tempo */
    public static List<ProductModel>products=new ArrayList<>();
    static {
        products.add(new ProductModel(1, new String("Ordinateur portable DELL"), new Float(800.60)));
        products.add(new ProductModel(2, new String("Aspirateur Robot"), new Float(230.23)));
        products.add(new ProductModel(3, new String("Table de Ping Pong"), new Float(505.83)));
    }

    @Override
    public List<ProductModel> findAll() {
        //TEST 1 (syntaxe décrite) avec BDD virtuelle
        return products;

        /*try{
           //With Hibernate Template
            List<ProductModel> allList = this.getHibernateTemplate().loadAll(ProductModel.class);
            return allList;
        }
       catch(Exception x){

            return null;

       }*/
    }

    @Override
    public ProductModel findById(int id) {
        //TEST 1 (syntaxe décrite) avec BDD virtuelle
        for (ProductModel product : products) {
            if(product.getId() ==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public ProductModel save(ProductModel product) {
        //TEST 1 (syntaxe décrite) avec BDD virtuelle
        products.add(product);
        return product;
    }
}
