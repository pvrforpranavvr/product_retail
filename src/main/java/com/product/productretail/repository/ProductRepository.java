package com.product.productretail.repository;


import com.product.productretail.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


    boolean deleteBySku(long sku);


}
