package com.product.productretail.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class Product {

    private long id;
    @Range(min = 1000000, max = 99999999, message = "sku must be between 1000000 and 99999999")
    private int sku;
    @NotEmpty(message = "Name required")
    private String name;
    @NotEmpty(message = "Brand required")
    private String brand;
    @NotBlank
    private String size;
    @Range(min = 1, max = 99999999, message = "price must be between 1 and 99999999")
    private int price;
    @NotBlank
    private String principleImage;
    private List<String> otherImages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<String> getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(List<String> otherImages) {
        this.otherImages = otherImages;
    }
}
