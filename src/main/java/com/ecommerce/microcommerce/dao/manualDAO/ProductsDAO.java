package com.ecommerce.microcommerce.dao.manualDAO;
import com.ecommerce.microcommerce.model.manualDAO.ProductModel;
import java.util.List;

public interface ProductsDAO {
    public List<ProductModel> findAll();
    public ProductModel findById(int id);
    public ProductModel save(ProductModel product);
}