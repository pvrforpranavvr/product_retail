package com.product.productretail.controller;

import com.product.productretail.exception.ProductRetailException;
import com.product.productretail.model.Product;
import com.product.productretail.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;


    @Test
    void testProductCreate_noNamePassed_throwValidation() {

        Product product = new Product();


        try {
            productController.create(product);
        } catch (ProductRetailException e) {

            Assertions.assertEquals("name required", e.getExceptionMsg());
        }
    }
}