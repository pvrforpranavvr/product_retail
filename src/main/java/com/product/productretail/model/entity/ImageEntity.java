package com.product.productretail.model.entity;

import javax.persistence.*;

@Entity
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long imgId;
    @ManyToOne
    @JoinColumn(name = "productEntityId", referencedColumnName = "productId")
    private ProductEntity productEntity;
    private String imageUrl;

    public long getImgId() {
        return imgId;
    }

    public void setImgId(long imgId) {
        this.imgId = imgId;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
