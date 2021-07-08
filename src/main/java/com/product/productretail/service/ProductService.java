package com.product.productretail.service;

import com.product.productretail.model.Product;

public interface ProductService {

    Product create(Product product);

    boolean delete(long sku);
}
