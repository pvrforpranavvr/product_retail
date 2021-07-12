package com.product.productretail.controller;

import com.product.productretail.exception.ProductRetailException;
import com.product.productretail.model.Product;
import com.product.productretail.model.Response;
import com.product.productretail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("${version}/product")
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) throws ProductRetailException {

        productService.create(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("${version}/product/{sku}")
    public ResponseEntity<Response> deleteBySku(@PathVariable long sku) throws ProductRetailException {

        if (sku == 0L) {

            throw new ProductRetailException(ProductRetailException.BUSINESS_EXCEPTION, "sku required");

        } else {

            productService.deleteBySku(sku);
        }

        return new ResponseEntity<>(new Response("Deleted"), HttpStatus.OK);
    }

    @GetMapping("${version}/product")
    public ResponseEntity<List<Product>> getAll() {

        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

}
