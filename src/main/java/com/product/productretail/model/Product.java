package com.product.productretail.model;

import java.util.List;

public class Product {

    private int id;
    private long sku;
    private String name;
    private String brand;
    private String size;
    private long price;
    private String principleImage;
    private List<String> otherImages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPrincipleImage() {
        return principleImage;
    }

    public void setPrincipleImage(String principleImage) {
        this.principleImage = principleImage;
    }

    public List<String> getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(List<String> otherImages) {
        this.otherImages = otherImages;
    }
}
