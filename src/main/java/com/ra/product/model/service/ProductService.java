package com.ra.product.model.service;

import com.ra.product.model.dao.ProductDAOImpl;
import com.ra.product.model.entity.Product;

import java.util.List;

public class ProductService implements IGenericService<Product, Integer>{
    private final ProductDAOImpl productDAOimpl = new ProductDAOImpl();
    @Override
    public List<Product> getAll() {
        return productDAOimpl.getAll();
    }

    @Override
    public boolean save(Product product) {
        return productDAOimpl.save(product);
    }

    @Override
    public Product getById(Integer productId) {
        return productDAOimpl.getById(productId);
    }

    @Override
    public boolean update(Product product, Integer productId) {
        return productDAOimpl.update(product,productId);
    }

    @Override
    public void delete(Integer productId) {
        productDAOimpl.delete(productId);
    }
}
