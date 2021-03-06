package com.product.productretail.service;

import com.product.productretail.model.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    boolean deleteBySku(int sku);

    List<Product> getAll();
}
