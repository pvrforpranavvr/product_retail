package com.product.productretail.service;

import com.product.productretail.model.entity.ImageEntity;

import java.util.List;

public interface ImageService {

    void create(ImageEntity imageEntity);

    List<ImageEntity> createAll(List<ImageEntity> imageEntities);
}
