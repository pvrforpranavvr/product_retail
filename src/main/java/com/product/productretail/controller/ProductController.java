package com.product.productretail.controller;

import com.product.productretail.exception.ProductRetailException;
import com.product.productretail.model.Product;
import com.product.productretail.model.Response;
import com.product.productretail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("${version}/product")
    public ResponseEntity<Product> create(@RequestBody Product product) throws ProductRetailException {

        validate(product);

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

    private void validate(Product product) throws ProductRetailException {

        if (product.getSku() < 1000000 && product.getSku() > 99999999) {

            throw new ProductRetailException(ProductRetailException.BUSINESS_EXCEPTION, "sku min 1000000 and 99999999");
        }

        if (!StringUtils.hasText(product.getName())) {

            throw new ProductRetailException(ProductRetailException.BUSINESS_EXCEPTION, "name required");
        } else if (product.getName().length() < 3 && product.getName().length() > 50) {

            throw new ProductRetailException(ProductRetailException.BUSINESS_EXCEPTION, "product name min 3 and 50");
        }


        if (!StringUtils.hasText(product.getBrand())) {

            throw new ProductRetailException(ProductRetailException.BUSINESS_EXCEPTION, "brand required");
        } else if (product.getBrand().length() < 3 && product.getBrand().length() > 50) {

            throw new ProductRetailException(ProductRetailException.BUSINESS_EXCEPTION, "product name min 3 and 50");
        }


    }
}
