package com.product.productretail.service.impl;

import com.product.productretail.model.Product;
import com.product.productretail.model.entity.ImageEntity;
import com.product.productretail.model.entity.ProductEntity;
import com.product.productretail.repository.ProductRepository;
import com.product.productretail.service.ImageService;
import com.product.productretail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ImageService imageService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ImageService imageService) {
        this.productRepository = productRepository;
        this.imageService = imageService;
    }


    @Override
    public Product create(Product product) {

        ImageEntity imageEntity = new ImageEntity();

        imageEntity.setImageUrl(product.getPrincipleImage());

        imageService.create(imageEntity);

        List<ImageEntity> savedImage = imageService.createAll(createAllImageEntity(product.getOtherImages()));

        ProductEntity productEntity = new ProductEntity();

        productEntity.setSku(product.getSku());
        productEntity.setName(product.getName());
        productEntity.setBrand(product.getBrand());
        productEntity.setSize(product.getSize());
        productEntity.setPrincipleImage(imageEntity);
        productEntity.setOtherImages(savedImage);

        productRepository.save(productEntity);

        productEntity.setPrice(product.getPrice());

        return product;
    }

    @Override
    public boolean delete(long sku) {

        return productRepository.deleteBySku(sku);
    }

    private List<ImageEntity> createAllImageEntity(List<String> otherImages) {

        List<ImageEntity> imageEntities = new ArrayList<>();

        ImageEntity otherImage = new ImageEntity();


        for (String otherImgae : otherImages) {

            otherImage.setImageUrl(otherImgae);
        }

        return imageEntities;
    }
}
