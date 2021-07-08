package com.product.productretail.service.impl;

import com.product.productretail.model.Product;
import com.product.productretail.model.entity.ProductEntity;
import com.product.productretail.repository.ProductRepository;
import com.product.productretail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {

        ProductEntity productEntity = new ProductEntity();

        productEntity.setSku(product.getSku());
        productEntity.setName(product.getName());
        productEntity.setBrand(product.getBrand());
        productEntity.setSize(product.getSize());

        productRepository.save(productEntity);

        productEntity.setPrice(product.getPrice());

        return product;
    }

    @Override
    public boolean delete(long sku) {

        return productRepository.deleteBySku(sku);
    }
}
