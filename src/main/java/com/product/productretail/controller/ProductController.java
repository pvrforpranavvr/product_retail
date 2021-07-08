package com.product.productretail.controller;

import com.product.productretail.exception.ProductRetailException;
import com.product.productretail.model.Product;
import com.product.productretail.model.Response;
import com.product.productretail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("${version}/product")
    public ResponseEntity<Product> create(@RequestBody Product product) {

        productService.create(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("${version}/product/{sku}")
    public ResponseEntity<Response> delete(@PathVariable long sku) throws ProductRetailException {

        if (sku == 0L) {

            throw new ProductRetailException(ProductRetailException.BUSINESS_EXCEPTION, "sku required");

        } else {

            productService.delete(sku);
        }

        return new ResponseEntity<>(new Response("Deleted"), HttpStatus.OK);
    }
}
