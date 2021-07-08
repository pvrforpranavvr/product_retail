package com.product.productretail.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long sku;
    private String name;
    private String brand;
    private String size;
    private long price;
    @OneToOne
    @JoinColumn(name = "principleImageId", referencedColumnName = "id")
    private ImageEntity principleImage;

    @OneToMany
    @JoinColumn(name = "otherImageId", referencedColumnName = "id")
    private List<ImageEntity> otherImages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }


    public ImageEntity getPrincipleImage() {
        return principleImage;
    }

    public void setPrincipleImage(ImageEntity principleImage) {
        this.principleImage = principleImage;
    }

    public List<ImageEntity> getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(List<ImageEntity> otherImages) {
        this.otherImages = otherImages;
    }
}
