package com.product.productretail.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    @Column(unique = true)
    private int sku;
    private String name;
    private String brand;
    private String size;
    private int price;
    private String principleImage;
    @OneToMany(targetEntity = ImageEntity.class, mappedBy = "productEntity", cascade = CascadeType.ALL)
    private List<ImageEntity> otherImages;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPrincipleImage() {
        return principleImage;
    }

    public void setPrincipleImage(String principleImage) {
        this.principleImage = principleImage;
    }

    public List<ImageEntity> getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(List<ImageEntity> otherImages) {
        this.otherImages = otherImages;
    }
}
