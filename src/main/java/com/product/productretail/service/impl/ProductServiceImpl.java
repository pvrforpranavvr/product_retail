package com.product.productretail.service.impl;

import com.product.productretail.model.Product;
import com.product.productretail.model.entity.ImageEntity;
import com.product.productretail.model.entity.ProductEntity;
import com.product.productretail.repository.ProductRepository;
import com.product.productretail.service.ImageService;
import com.product.productretail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
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

//        imageService.create(imageEntity);


        ProductEntity productEntity = new ProductEntity();

        productEntity.setSku(product.getSku());
        productEntity.setName(product.getName());
        productEntity.setBrand(product.getBrand());
        productEntity.setSize(product.getSize());
        productEntity.setPrincipleImage(product.getPrincipleImage());
        productEntity.setPrice(product.getPrice());
//        productEntity.setOtherImages(savedImage);

        ProductEntity productEntity1 = productRepository.save(productEntity);

        List<ImageEntity> savedImage = imageService.createAll(createAllImageEntity(product.getOtherImages(), productEntity));


        return product;
    }

    @Override
    public boolean deleteBySku(long sku) {

        int deleted = productRepository.deleteBySku(sku);
        if (deleted == 0) {

            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<Product> getAll() {

        List<ProductEntity> productEntities = productRepository.findAll();
        List<Product> products = new ArrayList<>();

        for (ProductEntity productEntity : productEntities) {

            Product product = new Product();

            product.setName(productEntity.getName());
            product.setBrand(productEntity.getBrand());
            product.setId(productEntity.getProductId());
            product.setPrincipleImage(productEntity.getPrincipleImage());
            product.setPrice(productEntity.getPrice());
            product.setSize(productEntity.getSize());
            product.setSku(productEntity.getSku());

            products.add(product);
        }

        return products;
    }

    private List<ImageEntity> createAllImageEntity(List<String> otherImages, ProductEntity productEntity) {

        List<ImageEntity> imageEntities = new ArrayList<>();

        for (String otherImgae : otherImages) {

            ImageEntity otherImage = new ImageEntity();

            otherImage.setImageUrl(otherImgae);
            otherImage.setProductEntity(productEntity);

            imageEntities.add(otherImage);
        }

        return imageEntities;
    }
}
